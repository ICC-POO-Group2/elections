package istia.st.elections;

import java.io.*;
/**
 * @author Viorel FLORICA
 * */
public class ListeElectorale {
/** Propriétées !*/
	private int id;
	private String nom;
	private int voix;
	private int sieges;
	private boolean elimine;
/** Cosntructeurs !*/
	public ListeElectorale(){
		/**Constructeur par defaut !*/
	}
	public ListeElectorale(int id, String nom, int voix, int sieges, boolean elimine){
		this.id=id;
		this.nom=nom;
		this.voix=voix;
		this.sieges=sieges;
		this.elimine=elimine;
		
	}
/** Getters et Setters ! */
	public int getId() throws ElectionsException {
		return id;
	}
	public void setId(int id) {
		if(id<1){
			throw new ElectionsException("ERROR:  L'id ne doit pas etre inferieur à 1");
		}
		this.id = id;
	}
	public String getNom() throws ElectionsException{
		if (nom.trim().equals("")){
			throw new ElectionsException("ERROR: Le nom est vide ou contient que des espaces et/ou tabulations");
		}
		return nom;
	}
	public void setNom(String nom) {
		if (nom.trim().equals("")){
			throw new ElectionsException("ERROR: Le nom est vide ou contient que des espaces et/ou tabulations");
		}
		this.nom = nom;
	}
	public int getVoix() {
		return voix;
	}
	public void setVoix(int voix) {
		if (voix<0){
			throw new ElectionsException("ERROR: Les voix ne doivent pas etre negatives !");
		}
		this.voix = voix;
	}
	public int getSieges() throws ElectionsException {
		return sieges;
	}
	public void setSieges(int sieges) throws ElectionsException {
		if(sieges < 0){
			throw new ElectionsException("ERROR: Le nombre de sièges doit être >= 0");
		}
		this.sieges = sieges;
	}
	public boolean isElimine() {
		return elimine;
	}
	public void setElimine(boolean elimine) {
		this.elimine = elimine;
	}
	
/**	Méthodes*/
	@Override
	public String toString() {
		return "[" + id + "," + nom + "," + voix + "," + sieges + ","
				+ elimine + "]";
	}

	
}