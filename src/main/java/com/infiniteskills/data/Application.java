package com.infiniteskills.data;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.infiniteskills.data.entities.Bank;

public class Application {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transation = null;
		try {

			transation = session.beginTransaction();
			Bank bank = new Bank();
			bank.setName("banco de mexico");
			bank.setAddressLine1("direccion 1");
			bank.setAddressLine2("direccion 2");
			bank.setCity("mexico");
			bank.setState("ED");
			bank.setZipCode("52104");
			bank.setCreatedBy("HUGO");
			bank.setCreatedDate(new Date());
			bank.setLastUpdatedBy("HUGO");
			bank.setLastUpdatedDate(new Date());
			bank.setInternational(true);

			session.save(bank);
			transation.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
