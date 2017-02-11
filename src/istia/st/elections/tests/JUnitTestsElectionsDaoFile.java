package istia.st.elections.tests;

import org.junit.Test;

import junit.framework.TestCase;
import istia.st.elecitons.dao.IElectionsDao;
import istia.st.elections.ListeElectorale;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;


public class JUnitTestsElectionsDaoFile extends TestCase {
	private IElectionsDao electionsDao = null;
	
	public JUnitTestsElectionsDaoFile(){
		super();
		//instanciation couche [dao]
		electionsDao = (IElectionsDao) (new XmlBeanFactory(new ClassPathResource("spring-config-electionsDaoFile.xml"))).getBean("electionsDao");
	}
	
	public void testLectureDataElections(){
		System.out.println("Nombre de sièges à pourvoir : "+ electionsDao.getNbSiegesAPourvoir());
		System.out.println("Seuil électoral : "+ electionsDao.getSeuilElectoral());
		ListeElectorale liste[] = electionsDao.getListesElectorales();
		for(int i=0; i<liste.length; i++){
			System.out.println("["+liste[i].getNom()+","+liste[i].getVoix()+","+liste[i].getSieges()+","+liste[i].isElimine()+"]");
		}
	}
	
	
}
