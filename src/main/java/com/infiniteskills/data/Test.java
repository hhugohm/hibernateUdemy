package com.infiniteskills.data;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.infiniteskills.data.entities.Credencial;
import com.infiniteskills.data.entities.Pais;
import com.infiniteskills.data.entities.User;
import com.infiniteskills.data.entities.Usuario;

public class Test {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transation = null;
		try {

			transation = session.beginTransaction();
			Pais pais = (Pais) session.get(Pais.class, 4);
			
			
			
			Usuario usuario = new Usuario();
            
			usuario.setNombre("CARLOS");
			usuario.setApellido("HIDALGO");
            
            Credencial credencial = new Credencial();
            credencial.setPassword("pass");
            credencial.setUsername("hhugohm");
            credencial.setUsuario(usuario);
            
            //Pais pais = new Pais();
            //pais.setDescripcion("MEXICO");
            
            
            usuario.setCredencial(credencial);
            usuario.setPais(pais);
            
            session.save(credencial);
			transation.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
