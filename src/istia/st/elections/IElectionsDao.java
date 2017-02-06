package istia.st.elections;

public interface IElectionsDao {
	public double getSeuilElectoral();
	public int getNbSiegesAPourvoir();
	public ListeElectorale[] getListesElectorales();
	public void setListesElectorales(ListeElectorale[] listesElectorales);
}
