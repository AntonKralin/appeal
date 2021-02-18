package tax.nalog.gov.by.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class SpringConfig {
	private static HibernateSession hSession;
	
	@Bean(name = "hibernateSession")
	@Scope("singleton")
	public HibernateSession hibernateSession() {
		if (hSession == null) {
			hSession = new HibernateSession();
		}
		return hSession;
	}
	

}