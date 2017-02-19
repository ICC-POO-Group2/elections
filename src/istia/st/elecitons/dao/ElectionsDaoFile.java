package istia.st.elecitons.dao;

import java.util.InputMismatchException;
import java.util.Scanner;

import istia.st.elections.ElectionsException;
import istia.st.elections.ListeElectorale;

public class ElectionsDaoFile implements IElectionsDao {
	
	private String inFileName = null;
	private String outFileName = null;
	private String logFileName = null;
	private double seuilElectoral;
	private int nbSiegesAPourvoir;
	private ListeElectorale[] listesElectorales =  null;
	
	// Cosntructeurs
	public ElectionsDaoFile(String inFileName, String outFileName, String logFileName) throws ElectionsException{
		this.inFileName = inFileName;
		this.outFileName = outFileName;
		this.logFileName = logFileName;
		this.seuilElectoral = 0;
		this.nbSiegesAPourvoir = 0;
	}
	private int setNbSiegesAPourvoir(int nbSAPourvoir) {
		int sap = 0;	
		try{
					sap= nbSAPourvoir;
				}catch(InputMismatchException e){
					System.out.println("Erreur: Le chiffres des sieges à pourvoir doit etre strictement positif");
					System.exit(1);
				}
			
		
		return sap;
	}
	private double setSeuilElectoral(int seuil) {
		
		return 0;
	}
	// Getters et Setters
	public double getSeuilElectoral() {
		return seuilElectoral;
	}

	
	public int getNbSiegesAPourvoir() {
		return nbSiegesAPourvoir;
	}

	public ListeElectorale[] getListesElectorales() {
		return listesElectorales;
	}

	public void setListesElectorales(ListeElectorale[] listesElectorales) {
		this.listesElectorales=listesElectorales;

	}

}
