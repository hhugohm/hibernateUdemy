package com.infiniteskills.data.entities;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Credencial {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idcredencial;
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name = "idusuario")
	private Usuario usuario;
	
	
	private String username;
	
	private String password;

	public int getIdcredencial() {
		return idcredencial;
	}

	public void setIdcredencial(int idcredencial) {
		this.idcredencial = idcredencial;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	
	

	
	
	
}
