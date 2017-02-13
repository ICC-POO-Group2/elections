package istia.st.elections;

public interface IElectionsMetier {
	public ListeElectorale[] getListesElectorales();
	
	public int getNbSiegesAPourvoir();
	
	public double getSeuilElectoral();
	
	public void recordResultats(ListeElectorale[] listesElectorales);
	
	public ListeElectorale[] calculerSieges(ListeElectorale[] listesElectorales);
}
