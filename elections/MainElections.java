package istia.st.elections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class MainElections {

	public static void main(String[] args) {
		/** Declaration des variables locales**/
		int nbSiegesAPourvoir = 0;
		boolean saisieOK;
		int totalVoix = 0;
		int i;
		int nbListes;
		int nbVoixUtiles = 0;
		double quotientElectoral;
		int nbSiegesPourvus = 0;
		int iSiege;
		int iMax;
		double moyenne[] =null;
		Scanner s = new Scanner(System.in);
		boolean scaner;//chien de garde du scanner !
		ListeElectorale liste = new ListeElectorale();
		ArrayList<ListeElectorale> arrayDesListes = new ArrayList<ListeElectorale>();
		ListeElectorale[] tableauDesListes = null;
		do{
			System.out.println("Nombre de sièges à pourvoir :");
			scaner=false; // chien de garde pour le scanner !
			//DEBUT introduction du nombre des sieges à pourvoir !
			saisieOK = false;
			do{
				try{
					nbSiegesAPourvoir= s.nextInt();
					scaner=true;
				}catch(InputMismatchException e){
					System.out.println("Erreur: tapez un nombre entier");
					s.next();
					// vider tampon !
				}
			}while(!scaner);
			if(nbSiegesAPourvoir<=0){
				System.out.println("Erreur: Le nombre doit etre plus grand que 0 ");
			}else{
				saisieOK=true;
			}
		}while(!saisieOK);
		//FIN de l'introduction du nombre des sièges à pourvoir!
		//DEBUT de la saisie du nom de la liste (*) pour arreter la saisie
		i=0;
		System.out.println("Nom de la liste no "+ (i+1) + ", (*) pour arreter l'encodage !");
		liste.setNom(s.next().trim());
		while(!"*".equals(liste.getNom())){
			
			
				if(liste.getNom() ==""){
					System.out.println("Erreur : Tapez un nom non vide");
				}
				else{
					liste.setId(i+1);
					i++;
				}
				
			//FIN de la saisie du nom de la liste (*) pour arreter la saisie
			//DEBUT saisie du nombre des voix pour la liste i
			if(liste.getNom()!="*"){
				saisieOK=false;
				do{
					System.out.println("Nombre de voix de la liste ["+ liste.getNom()+"]");
					scaner=false;
					do{
						try {
							liste.setVoix(s.nextInt());
							scaner=true;
						} catch (InputMismatchException e) {
							System.out.println("Vous devez entrer un entier !!");
							s.next();	
						}
					}while(!scaner);
					if(liste.getVoix()<0){
						System.out.println("Erreur : tapez un nombre entier >= 0 ");
					}
					else{
						saisieOK=true;
					}
				}while(!saisieOK);
				
			}
			
			//FIN saisie du nombre des voix pour la liste i
			//DEBUT comptage des voix
			totalVoix= totalVoix+liste.getVoix();
			//FIN comptage des voix
			//DEBUT Ajout de la liste dans le tableau dinamique !
			arrayDesListes.add(liste);
			liste = new ListeElectorale();
			//FIN Ajout de la liste dans le tableau dinamique !
			System.out.println("Nom de la liste no "+ (i+1) + ", (*) pour arreter l'encodage !");
			liste.setNom(s.next().trim());
		};
		s.close();
		//DEBUT Sauvegarde dans un tableau statique
		tableauDesListes = new ListeElectorale[arrayDesListes.size()];
		moyenne = new double[arrayDesListes.size()];
		
		/**Iterator pour parcourir le tableau dinamique**/
		Iterator<ListeElectorale> it = arrayDesListes.iterator();
		i=0;
		while(it.hasNext()){
			tableauDesListes[i]=it.next();
			i++;
		}
		nbListes=tableauDesListes.length; ;
		//FIN Sauvegarde dans un tableau statique
		//DEBUT  Calcul des voix utiles
				for(i=0; i<nbListes; i++){
					if((double)tableauDesListes[i].getVoix()/totalVoix<0.05){
						tableauDesListes[i].setElimine(true);
					}
					else{
						tableauDesListes[i].setElimine(false);
						nbVoixUtiles=nbVoixUtiles+tableauDesListes[i].getVoix();
					}
				}
		//FIN  Calcul des voix utiles
		//DEBUT Verification si tous les liste sont eliminées !
		if(nbVoixUtiles==0){
			System.out.println("Erreur : Aucune liste encodé ou toutes ont été éliminées");
			System.exit(1);
		}
		//FIN Verification si tous les liste sont eliminées !
		//DEBUT Répartition des sièges qu quotient
		quotientElectoral= (double)nbVoixUtiles/nbSiegesAPourvoir;
		nbSiegesPourvus = 0;
		for(i=0; i<nbListes; i++){
			if(!tableauDesListes[i].isElimine()){
				tableauDesListes[i].setSieges((int)(tableauDesListes[i].getVoix()/quotientElectoral));
				moyenne[i]=(double)tableauDesListes[i].getVoix()/(tableauDesListes[i].getSieges()+1);
				
				//tableauDesListes[i].setMoyenne((double)tableauDesListes[i].getVoix()/(tableauDesListes[i].getSieges()+1) );
				nbSiegesPourvus= nbSiegesPourvus+tableauDesListes[i].getSieges();
			}
			else{
				tableauDesListes[i].setSieges(0);
			}
		}
		//FIN Répartition des sièges qu quotient
		//DEBUT Répartition des sieges restantes à la plus forte moyenne
		for(iSiege=0; iSiege<nbSiegesAPourvoir-nbSiegesPourvus; iSiege++){
			//recherche de la liste ayant la + forte moyenne
			double moyenneMax = -1;
			iMax=-1;
			for(i=0; i<nbListes; i++){
				ListeElectorale le = tableauDesListes[i];
				if(!le.isElimine()){
					if(moyenne[i]>moyenneMax){
						moyenneMax = moyenne[i];
						iMax=i;
					}
				}
			}
		 // On attribue 1 siège à la liste de + forte moyenne
			tableauDesListes[iMax].setSieges(tableauDesListes[iMax].getSieges()+1);
		 // Et on change sa moyenne
			moyenne[iMax]=(double)tableauDesListes[iMax].getVoix()/(tableauDesListes[iMax].getSieges()+1);
			//tableauDesListes[iMax].setMoyenne((double)tableauDesListes[iMax].getVoix()/(tableauDesListes[iMax].getSieges()+1));
		}
		//FIN Répartition des sieges restantes à la plus forte moyenne
		//DEBUT Tri du tableau !
		Arrays.sort(tableauDesListes, new CompareListesElectorales());
		//FIN Tri du tableau  !	
		//DEBUT Affichage du contenu du tableau !!!
		
		for(i=0; i<nbListes; i++){
				System.out.println("La liste ["+ tableauDesListes[i].getNom()+"] a obtenu ["+ tableauDesListes[i].getSieges()+"] siège(s)");
		}
		
		
		
		//FIN Affichage du contenu du tableau !!!
		
		
	}

}
