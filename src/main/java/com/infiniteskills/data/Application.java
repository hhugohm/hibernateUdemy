package com.infiniteskills.data;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.infiniteskills.data.entities.Bank;
import com.infiniteskills.data.entities.Credential;
import com.infiniteskills.data.entities.User;

public class Application {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transation = null;
		try {

			transation = session.beginTransaction();
			User user = new User();
            user.setBirthDate(new Date());
            user.setCreatedBy("veronica");
            user.setCreatedDate(new Date());
            user.setEmailAddress("colin@gmail.com");
            user.setFirstName("veronica");
            user.setLastName("colin");
            user.setLastUpdatedBy("veronica");
            user.setLastUpdatedDate(new Date());
            
            Credential credential = new Credential();
            credential.setPassword("pass");
            credential.setUsername("vroocc");
            credential.setUser(user);
            
            session.save(credential);
			transation.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
