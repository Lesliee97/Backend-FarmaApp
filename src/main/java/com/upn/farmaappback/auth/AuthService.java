package com.upn.farmaappback.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.upn.farmaappback.configuration.JwtService;
import com.upn.farmaappback.model.Usuario;
import com.upn.farmaappback.model.repository.UsuarioRepository;

@Service
public class AuthService {

	@Autowired
	private UsuarioRepository usuarioRepository;
 
	@Autowired
	private JwtService jwtService;
 
	@Autowired
	private PasswordEncoder passwordEncoder;
 
	@Autowired
	private AuthenticationManager authenticationManager;
 
	public AuthResponse login(LoginRequest loginRequest) {
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
		UserDetails user = usuarioRepository.findByUsername(loginRequest.getUsername()).orElseThrow();
		String token = jwtService.getToken(user);
 
		AuthResponse response = new AuthResponse();
		response.setToken(token);
		return response;
	}
 
	public AuthResponse register(RegisterRequest registerRequest) {
		Usuario usuario = new Usuario();
 
		usuario.setUsername(registerRequest.getUsername());
		usuario.setApellidos(registerRequest.getApellidos());
		usuario.setNombres(registerRequest.getNombres());
		usuario.setHistoria(registerRequest.getHistoria());
		usuario.setCelular(registerRequest.getCelular());
		
		if(registerRequest.getCorreo() !=null) {
			usuario.setCorreo(registerRequest.getCorreo());
		}
		usuario.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
 
		usuarioRepository.save(usuario);
 
		AuthResponse response = new AuthResponse();
		response.setToken(jwtService.getToken(usuario));
 
		return response;
	}
}
