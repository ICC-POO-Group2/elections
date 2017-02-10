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
		return null;
	}

	@Override
	public int getNbSiegesAPourvoir() {
		//demander l'information à la couche dao
		return 0;
	}

	@Override
	public double getSeuilElectoral() {
		// demander l'inforamtion à la couche dao
		return 0;
	}

	@Override
	public void recordResultats(ListeElectorale[] listesElectorales) {
		// demander l'enregistrement des listes à la couche dao

	}

	@Override
	public ListeElectorale[] calculerSieges(ListeElectorale[] listesElectorales) {
		/** calcule les résultats de l'élection
			@param listesElectorales ListeElectorale[] : le tableu des listes candidates
			@param ListeElectorale[] :  ce même tableau avec cette fois-ci les sièges obtenus
		**/
		return null;
	}

}
