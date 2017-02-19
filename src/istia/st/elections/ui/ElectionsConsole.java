package istia.st.elections.ui;

import istia.st.elections.metier.IElectionsMetier;

public class ElectionsConsole implements IElectionsUI {
	private IElectionsMetier electionsMetier;
	
	public void setElectionsMetier(IElectionsMetier electionsMetier){
		this.electionsMetier = electionsMetier;
	}
	public ElectionsConsole() {
		
	}
	public void run() {
		// TODO Demander les listes en compétition à la couche [metier]
		
		//TODO faire la saisie des voix
		
		//TODO faire le calcul des sièges
		
		//TODO enregistrer les résultats
		
		//TODO afficher les resultats
		

	}

}
