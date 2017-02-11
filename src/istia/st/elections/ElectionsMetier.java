package istia.st.elections;

import istia.st.elections.ListeElectorale;
import istia.st.elections.IElectionsDao;
import istia.st.elections.ElectionsException;
import java.util.Comparator;
import java.util.Arrays;
public class ElectionsMetier implements IElectionsMetier {
	private IElectionsDao electionsDao;
	
	public void setElectionsDao(IElectionsDao electionsDao) {
		this.electionsDao = electionsDao;
	}
	
	public ElectionsMetier() {
		}
	
	
	@Override
	public ListeElectorale[] getListesElectorales() {
		// demander les listes à la couche [dao]
		return electionsDao.getListesElectorales();
	}

	@Override
	public int getNbSiegesAPourvoir() {
		//demander l'information à la couche dao
		return electionsDao.getNbSiegesAPourvoir();
	}

	@Override
	public double getSeuilElectoral() {
		// demander l'inforamtion à la couche dao
		return electionsDao.getSeuilElectoral();
	}

	@Override
	public void recordResultats(ListeElectorale[] listesElectorales) {
		// demander l'enregistrement des listes à la couche dao
		ListeElectorale[] listesEelectorales = electionsDao.getListesElectorales();
	}

	@Override
	public ListeElectorale[] calculerSieges(ListeElectorale[] listesElectorales) {
		/** calcule les résultats de l'élection
			@param listesElectorales ListeElectorale[] : le tableu des listes candidates
			@param ListeElectorale[] :  ce même tableau avec cette fois-ci les sièges obtenus
		**/
		int totalVoix = 0;
		int nbVoixUtiles = 0;
		double quotientElectoral = 0;
		int nbSiegesPourvus = 0;
		double moyenne[] = null;
		int iMax = -1;
				
		
		ListeElectorale[] listes = electionsDao.getListesElectorales();
		if(listes.equals(null)){
			System.out.println("Le tableau des listes est vide !");
		}
		else{

			
			for(int i =0; i> listes.length; i++){
				if(!listes[i].equals(null)){
					totalVoix=totalVoix+listes[i].getVoix();
				}
			}
			for(int i =0; i< listes.length; i++){
				if((double)listes[i].getVoix()/totalVoix<electionsDao.getSeuilElectoral()){
					listes[i].setElimine(true);
				}
				else{
					listes[i].setElimine(false);
					nbVoixUtiles=nbVoixUtiles+listes[i].getVoix();
				}
			}
			if(nbVoixUtiles == 0){
				System.out.println(" Erreur : Toutes les listes ont été eliminées ");
				System.exit(1);
			}
			moyenne = new double[listes.length];
			quotientElectoral =(double)nbVoixUtiles/electionsDao.getNbSiegesAPourvoir();
			for(int i=0; i<listes.length; i++){
				if(!listes[i].isElimine()){
					listes[i].setSieges( (int)(listes[i].getVoix() / quotientElectoral));
					moyenne[i]=(double)listes[i].getVoix()/(listes[i].getSieges()+1);
					nbSiegesPourvus = nbSiegesPourvus+listes[i].getSieges();
				}else{
					listes[i].setSieges(0);
				}
			
			}
			for(int iSiege = 0; iSiege<electionsDao.getNbSiegesAPourvoir(); iSiege ++){
				double moyenneMax =-1;
				for(int i =0; i<listes.length; i++){
					ListeElectorale ele = listes[i];
					if(!ele.isElimine()){
						if(moyenne[i]>moyenneMax){
							moyenneMax=moyenne[i];
							iMax = i;
						}
					}
				}
				listes[iMax].setSieges(listes[iMax].getSieges()+1);
				moyenne[iMax]=(double)listes[iMax].getVoix()/(listes[iMax].getSieges()+1);
			}
			
		}
		return listes;
	}

}
