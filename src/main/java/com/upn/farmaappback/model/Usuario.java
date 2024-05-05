package com.upn.farmaappback.model;

import java.util.Collection;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

@Data
@Entity
@Table(name="usuarios")
public class Usuario implements UserDetails{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name="id")
	private Long id;
	@Basic(optional = false)
	@Column(name="username")
	private String username;
	@Basic(optional = false)
	@Column(name="password")
	private String password;
	@Basic(optional = false)
	@Column(name="nombres")
	private String nombres;
	@Basic(optional = false)
	@Column(name="apellidos")
	private String apellidos;
	@Basic(optional = false)
	@Column(name="historia")
	private String historia;
	@Basic(optional = false)
	@Column(name="celular")
	private String celular;
	@Basic(optional = true)
	@Column(name="correo")
	private String correo;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(new SimpleGrantedAuthority("USER"));
	}
 
	@Override
	public String getUsername() {
		return this.username;
	}
 
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
 
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
 
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
 
	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.password;
	}
}
