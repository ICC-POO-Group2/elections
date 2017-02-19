package istia.st.elecitons.dao;

import istia.st.elecitons.dao.ElectionsDaoFile;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({ "spring.core.entities" })
public class ConfigDao {
	
	@Bean
	public ElectionsDaoFile daoFile(){
		return new ElectionsDaoFile("data\\elections-in-good.txt", "data\\elections-out.txt", "data\\elections-log.txt");
	}
	
}
