package istia.st.elecitons.dao;

import istia.st.elections.ListeElectorale;

public class ElectionsDaoFile implements IElectionsDao {
	
	private String inFileName = null;
	private String outFileName = null;
	private String logFileName = null;
	private double seuilElectoral;
	private int nbSiegesAPourvoir;
	private ListeElectorale[] listesElectorales =  null;
	
	// Cosntructeurs
	public ElectionsDaoFile(String inFileName, String outFileName, String logFileName) {
		this.inFileName = inFileName;
		this.outFileName = outFileName;
		this.logFileName = logFileName;
	}
	// Getters et Setters
	@Override
	public double getSeuilElectoral() {
		return seuilElectoral;
	}

	@Override
	public int getNbSiegesAPourvoir() {
		return nbSiegesAPourvoir;
	}

	@Override
	public ListeElectorale[] getListesElectorales() {
		return listesElectorales;
	}

	@Override
	public void setListesElectorales(ListeElectorale[] listesElectorales) {
		this.listesElectorales=listesElectorales;

	}

}
