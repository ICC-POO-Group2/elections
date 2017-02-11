package istia.st.elections;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import istia.st.elections.ListeElectorale;
import istia.st.elections.IElectionsMetier;
import istia.st.elections.ElectionsException;

import junit.framework.TestCase;

public class JUnitTestsElectionsMetierDaoFile extends TestCase{
	private IElectionsMetier electionsMetier = null;
	
	public JUnitTestsElectionsMetierDaoFile(){
		super();
		electionsMetier = (IElectionsMetier) (new XmlBeanFactory(new ClassPathResource("spring-config-electionsMetierDaoFile.xml"))).getBean("electionsMetier");
	}
	
	public void test1CalculSieges(){
		ListeElectorale[] listes = new ListeElectorale[7];
		//Remplir la liste
		//Calculer les sieges
		// verifier les resultats 
		assertEquals(2, listes[0].getSieges());
		//à completer avec des tests
	}
	public void test2CalculSieges(){
		ListeElectorale[] listes = electionsMetier.getListesElectorales();
		listes[0].setVoix(32000);
		listes[1].setVoix(25000);
		listes[2].setVoix(18000);
		listes[3].setVoix(12000);
		listes[4].setVoix(8000);
		listes[5].setVoix(4500);
		listes[6].setVoix(2000);
		// Calculer les sièges
		// Verifier les résultats
	}
	
	public void test3CalculSieges(){
		// tableau de 25 listes candidates ayant toutes 1 voix
		// toutes les listes auront le meme nombre de voix(4%)
		
		//calcul des sièges normalement on doit avoir une ElectionsException avec un seuil électoral de 5% et on la gère
		boolean erreur = false;
		
		// on erifie les résultats
		assertTrue(erreur);
	}
	public void testEcritureResultatsElections(){
		// Récuperer le tableau des listes candidates aupres de la couche metier
		ListeElectorale[] listes = electionsMetier.getListesElectorales();
		// on fixe en dur les voix
		
		// on calcule les sièges
		
		//on affiche les résultats
		
		// on enregistre les résultats
		
	}
}
