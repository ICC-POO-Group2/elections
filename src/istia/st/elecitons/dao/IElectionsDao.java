package istia.st.elecitons.dao;

import istia.st.elections.ListeElectorale;

public interface IElectionsDao {
	public double getSeuilElectoral();
	public int getNbSiegesAPourvoir();
	public ListeElectorale[] getListesElectorales();
	public void setListesElectorales(ListeElectorale[] listesElectorales);
}
