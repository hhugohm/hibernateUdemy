package com.infiniteskills.data;

import java.util.Date;
import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.infiniteskills.data.entities.AccountType;

public class Application {

	public static void main(String[] args) {
		
		/* Configuration */
		Configuration configuration = new Configuration();

		configuration.addAnnotatedClass(AccountType.class);

		configuration.setProperties(new Properties() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			{
				put("hibernate.connection.username", "infinite");
				put("hibernate.connection.password", "infinite");
				put("hibernate.connection.driver_class","com.mysql.cj.jdbc.Driver");
				put("hibernate.connection.url","jdbc:mysql://localhost:3306/ifinances?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
			}
		});

		/* Building SessionFactory */
		SessionFactory sessionFactory = configuration
				.buildSessionFactory(new StandardServiceRegistryBuilder(
						).applySettings(configuration.getProperties()).build());
	
		/* Obtain Session and Call Persistence Methods */
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		AccountType type = new AccountType();

		type.setName("Checking 2");
		type.setCreatedDate(new Date());
		type.setLastUpdatedDate(new Date());
		type.setCreatedBy("kevinbowersox 2");
		type.setLastUpdatedBy("kevinbowersox 2");
		
		session.save(type);
		session.getTransaction().commit();
		
		session.close();

	}
}
