package istia.st.elections.tests;

import org.junit.Test;

import istia.st.elections.ListeElectorale;
import istia.st.elections.ElectionsException;
import istia.st.elections.ListeElectorale;

public class MainTest1ListeElectorale {
	@Test
	public void main() {
		ListeElectorale listeElectorale1 = new ListeElectorale(1, "A", 32000,0,false);
		System.out.println("listeElectorale1=" + listeElectorale1);
		listeElectorale1.setSieges(2);
		System.out.println("listeElectorale1="+ listeElectorale1);
		ListeElectorale listeElectorale2 = listeElectorale1;
		System.out.println("listeElectorale2=" + listeElectorale2);
		listeElectorale2.setSieges(3);
		System.out.println("listeElectorale2=" + listeElectorale2);
		System.out.println("listeElectorale1=" + listeElectorale1);
		try{
			listeElectorale2.setSieges(-3);
		} catch(ElectionsException ex){
			System.err.println(" L'exception suivante s'est produite : [" + ex.toString() + "] ");
		}
	}
}
