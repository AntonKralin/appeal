package tax.nalog.gov.by.utils;

import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import tax.nalog.gov.by.entity.*;

public class HibernateUtil {
	private SessionFactory sessionFactory;
	
	public SessionFactory getMySQLSessionFactory() {
		if (sessionFactory == null) {
			try {
				
				//AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
				//XMLSettings xml = ctx.getBean(XMLSettings.class);
				//ctx.close();
				String pass = "Ythy,thu2@";
				String login = "admin";

				//String url = "jdbc:mysql://"+xml.getIpBD()+":"+xml.getPortBD()+"/hibernate_db?useSSL=false";
				String url = "jdbc:mysql://localhost:3306/appeal";
				
				Configuration config = new Configuration();
				Properties settings = new Properties();
				settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
				settings.put(Environment.URL, url);
				settings.put(Environment.USER, login);
				settings.put(Environment.PASS, pass);
				settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
				settings.put(Environment.SHOW_SQL, "true");
				settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
				settings.put(Environment.HBM2DDL_AUTO, "update");
				//settings.put(Environment.HBM2DDL_AUTO, "create");
				
				config.setProperties(settings);
				addAnnotatedClass(config);
				
				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
				sessionFactory = config.buildSessionFactory(serviceRegistry);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sessionFactory;
	}
	
	public SessionFactory getH2SessionFactory() {
		if (sessionFactory == null) {
			try {
				
				//ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
				//XMLSettings xml = ctx.getBean(XMLSettings.class);
				String pass = "12345678"; // xml.getBDPassword();
				String login = "sa"; //xml.getBDLogin();
				
				Configuration config = new Configuration();
				Properties settings = new Properties();
				settings.put(Environment.DRIVER, "org.h2.Driver");
				settings.put(Environment.URL, "jdbc:h2:./UchetKT");
				settings.put(Environment.USER, login);
				settings.put(Environment.PASS, pass);
				settings.put(Environment.DIALECT, "org.hibernate.dialect.H2Dialect");
				settings.put(Environment.SHOW_SQL, "true");
				settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
				settings.put(Environment.HBM2DDL_AUTO, "update");
				//settings.put(Environment.HBM2DDL_AUTO, "create");
				
				config.setProperties(settings);
				addAnnotatedClass(config);
				
				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
				sessionFactory = config.buildSessionFactory(serviceRegistry);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}		
		return sessionFactory;
	}
	
	private Configuration addAnnotatedClass(Configuration config) {
		//config.addPackage("tax.nalog.gov.by.entity");
		config.addAnnotatedClass(Admins.class);
		config.addAnnotatedClass(Appeals.class);
		config.addAnnotatedClass(Imns.class);
		return config;
	}
	
}