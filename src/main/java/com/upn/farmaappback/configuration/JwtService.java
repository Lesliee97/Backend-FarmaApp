package com.upn.farmaappback.configuration;

import org.springframework.stereotype.Service;

import com.upn.farmaappback.model.Usuario;
import com.upn.farmaappback.model.repository.UsuarioRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;

@Service
public class JwtService {

	@Autowired
	private UsuarioRepository usuarioRepository;
 
	private static final String SECRET_KEY = "586E3272357538782F413F4428472B4B6250655368566B597033733676397924";
 
	public String getToken(UserDetails usuario) {
		Usuario user = usuarioRepository.findByUsername(usuario.getUsername()).orElseThrow();
		Map<String, Object> extraClaims = new HashMap<>();
		extraClaims.put("userId", user.getId());
		extraClaims.put("firstName", user.getNombres());
		extraClaims.put("lastName", user.getApellidos());
		return getToken(extraClaims, usuario);
	}
 
	private String getToken(Map<String, Object> extraClaims, UserDetails usuario) {
 
		return Jwts.builder().setClaims(extraClaims).setSubject(usuario.getUsername())
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
				.signWith(getKey(), SignatureAlgorithm.HS256).compact();
 
	}
 
	private Key getKey() {
		byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
		return Keys.hmacShaKeyFor(keyBytes);
	}
 
	public String getUsernameFromToken(String token) {
		return getClaim(token, Claims::getSubject);
	}
 
	public boolean isTokenValid(String token, UserDetails userDetails) {
		final String username = getUsernameFromToken(token);
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}
 
	private Claims getAllClaims(String token) {
		return Jwts.parserBuilder().setSigningKey(getKey()).build().parseClaimsJws(token).getBody();
	}
 
	public <T> T getClaim(String token, Function<Claims, T> claimResolver) {
		final Claims claims = getAllClaims(token);
		return claimResolver.apply(claims);
	}
 
	private Date getExpiration(String token) {
		return getClaim(token, Claims::getExpiration);
	}
 
	private boolean isTokenExpired(String token) {
		return getExpiration(token).before(new Date());
	}
}
