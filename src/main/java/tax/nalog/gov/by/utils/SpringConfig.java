package tax.nalog.gov.by.utils;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class SpringConfig {
	private static HibernateSession hSession;
	private static final Logger logger = Logger.getLogger(SpringConfig.class);
	
	@Bean(name = "hibernateSession")
	@Scope("singleton")
	public HibernateSession hibernateSession() {
		logger.info("hibernateSession in.");
		if (hSession == null) {
			hSession = new HibernateSession();
		}
		return hSession;
	}
	

}