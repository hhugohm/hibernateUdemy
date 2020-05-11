package com.infiniteskills.data;

import java.util.Date;

import org.hibernate.Session;

import com.infiniteskills.data.entities.User;
import org.hibernate.Transaction;


public class Application {

	public static void main(String[] args) {
             Transaction transaction = null;
            try  {
               
                Session session = HibernateUtil.getSessionFactory().openSession();
                 transaction = session.beginTransaction();
                
                User user = new User();
                user.setBirthDate(new Date());
                user.setCreatedBy("hugo");
                user.setCreatedDate(new Date());
                user.setEmailAddress("hhugohm@gmail.com");
                user.setFirstName("Hugo");
                user.setLastName("Hidalgo");
                user.setLastUpdatedBy("kevin");
                user.setLastUpdatedDate(new Date());
                
                session.save(user);
                transaction.commit();

                HibernateUtil.shutdown();
            }catch(Exception e){
                e.printStackTrace();
            }
		
	}
}
