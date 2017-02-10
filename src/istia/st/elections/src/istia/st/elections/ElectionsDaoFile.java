package istia.st.elections;

public class ElectionsDaoFile implements IElectionsDao {
	
	private String inFileName = null;
	private String outFileName = null;
	private String logFileName = null;
	private double seuilElectoral;
	private int nbSiegesAPourvoir;
	private ListeElectorale[] listeElectorales =  null;
	
	// Cosntructeurs
	public ElectionsDaoFile(String inFileName, String outFileName, String logFileName) {
		this.inFileName = inFileName;
		this.outFileName = outFileName;
		this.logFileName = logFileName;
	}
	// Getters et Setters
	@Override
	public double getSeuilElectoral() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getNbSiegesAPourvoir() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ListeElectorale[] getListesElectorales() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setListesElectorales(ListeElectorale[] listesElectorales) {
		// TODO Auto-generated method stub

	}

}
