package com.upn.farmaappback.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.upn.farmaappback.model.repository.UsuarioRepository;

@Configuration
public class AplicationConfig {
	@Autowired
	private UsuarioRepository usuarioRepository;
 
	@Bean
	AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
		return config.getAuthenticationManager();
	}
 
	@Bean
	AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailService());
		authenticationProvider.setPasswordEncoder(encoder());
 
		return authenticationProvider;
	}
 
	@Bean
	UserDetailsService userDetailService() {
		// TODO Auto-generated method stub
		return usuario -> usuarioRepository.findByUsername(usuario)
				.orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));
	}
 
	@Bean
	PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
}
