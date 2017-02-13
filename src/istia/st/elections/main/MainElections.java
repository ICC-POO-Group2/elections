package istia.st.elections.main;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.sun.org.apache.bcel.internal.util.ClassPath;

import istia.st.elections.ui.IElectionsUI;

public class MainElections {

	public static void main(String[] args) {
		@SuppressWarnings("deprecation")
		IElectionsUI electionsUI =(IElectionsUI) (new XmlBeanFactory(new ClassPathResource("spring-config-electionsUiMetierDaoFile.xml"))).getBean("electionsUI");
	
	electionsUI.run();
	}

}
