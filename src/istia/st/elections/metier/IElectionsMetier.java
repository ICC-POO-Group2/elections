package istia.st.elections.metier;

import istia.st.elections.ListeElectorale;

public interface IElectionsMetier {
	public ListeElectorale[] getListesElectorales();
	
	public int getNbSiegesAPourvoir();
	
	public double getSeuilElectoral();
	
	public void recordResultats(ListeElectorale[] listesElectorales);
	
	public ListeElectorale[] calculerSieges(ListeElectorale[] listesElectorales);
}
