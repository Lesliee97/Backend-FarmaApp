package com.upn.farmaappback.model;

import java.util.Collection;
import java.util.List;

import javax.persistence.*;

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
	private Long id;
	@Basic(optional = false)
	private String username;
	@Basic(optional = false)
	private String password;
	@Basic(optional = false)
	private String nombres;
	@Basic(optional = false)
	private String apellidos;
	@Basic(optional = false)
	private String historia;
	@Basic(optional = false)
	private String celular;
	@Basic(optional = true)
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
	@OneToMany(mappedBy = "idUsuario")
	private List<Direccione> direcciones;

	@OneToMany(mappedBy = "idUsuario")
	private List<MedFavUsuario> medFavUsuarios;
}
