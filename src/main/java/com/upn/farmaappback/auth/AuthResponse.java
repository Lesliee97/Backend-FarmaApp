package com.upn.farmaappback.auth;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AuthResponse implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String token;

}
