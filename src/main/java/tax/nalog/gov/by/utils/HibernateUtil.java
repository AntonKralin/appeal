package tax.nalog.gov.by.utils;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import tax.nalog.gov.by.entity.*;

public class HibernateUtil {
	private SessionFactory sessionFactory;
	private static final Logger logger = Logger.getLogger(HibernateUtil.class);
	
	public SessionFactory getMySQLSessionFactory() {
		if (sessionFactory == null) {
			try {
				logger.info("create MySQL SessionFactory");
				//AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
				//XMLSettings xml = ctx.getBean(XMLSettings.class);
				//ctx.close();
				String pass = "Ythy,thu2@";
				String login = "appeal";

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
				settings.put("hibernate.connection.CharSet", "utf-8");
				settings.put("hibernate.connection.useUnicode", true);
				settings.put("hibernate.connection.characterEncoding", "utf-8");
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
				logger.info("create H2 SessionFactory");
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
		config.addAnnotatedClass(Departments.class);
		return config;
	}
	
}