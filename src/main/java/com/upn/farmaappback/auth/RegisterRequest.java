package com.upn.farmaappback.auth;

import java.io.Serializable;

import lombok.Data;

@Data
public class RegisterRequest implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String username;
	private String password;
	private String nombres;
	private String apellidos;
	private String historia;
	private String celular;
	private String correo;
	

}
