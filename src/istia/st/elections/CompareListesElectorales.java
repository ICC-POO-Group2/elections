package istia.st.elections;

import java.util.Comparator;

public class CompareListesElectorales implements Comparator<ListeElectorale> {

	@Override
	public int compare(ListeElectorale listeElectorale1, ListeElectorale listeElectorale2) {
		if(listeElectorale1.getSieges()<listeElectorale2.getSieges()){
			return 1;
		}
		if(listeElectorale1.getSieges()> listeElectorale2.getSieges()){
			return -1;
		}
		return 0;
	}

}
