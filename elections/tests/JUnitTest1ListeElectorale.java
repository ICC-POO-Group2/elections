package istia.st.elections.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import istia.st.elections.ElectionsException;
import istia.st.elections.ListeElectorale;

public class JUnitTest1ListeElectorale {
	ListeElectorale liste;
	boolean erreur;
	@Before
	public void setUp(){
		//création de la liste électorale
		liste = new ListeElectorale(1, "a", 32000, 0, false);
		erreur = false;
	}
	@Test
	public void testListeElectorale() {
		// test du constructeur
		assertEquals("a", liste.getNom());
		assertEquals(32000, liste.getVoix());
		assertEquals(false, liste.isElimine());
		assertEquals(0, liste.getSieges());
	}
	//vérification validité id 
	@Test
	public void testSetId(){
		try{
			liste.setId(-4);
		}catch(ElectionsException e) {
			erreur = true;
		}
		// dans l'énoncé est demandé de faire assertEquals(true, erreur);
		assertTrue(erreur);
		
	}
	//verification validité nom
	@Test
	public void testSetNom(){
		try{
				liste.setNom("");
		}catch(ElectionsException e){
			erreur=true;
		}
		// dans l'énoncé est demandé de faire assertEquals(true, erreur);
		assertTrue(erreur);
	}
		//vérification validité voix
	@Test
	public void testSetVoix(){
		try {
			liste.setVoix(-4);
		} catch (ElectionsException e) {
			erreur = true;
		}
		// dans l'énoncé est demandé de faire assertEquals(true, erreur);
		assertTrue(erreur);
	}
		//vérification validité sieges
	@Test
	public void testSetSieges(){
		try {
			liste.setSieges(-4);
		} catch (ElectionsException e) {
			erreur = true;
		}
		assertTrue(erreur);
	}

}
