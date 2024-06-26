package com.upn.farmaappback.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthController {

	@Autowired
	private AuthService authService;
 
	@PostMapping(value = "login")
	public ResponseEntity<AuthResponse> login(@Validated @RequestBody LoginRequest loginRequest) {
		return ResponseEntity.ok(authService.login(loginRequest));
	}

	@PostMapping(value = "register")
	public ResponseEntity<?> register(@Validated @RequestBody RegisterRequest registerRequest) {
		authService.register(registerRequest);
		Map<String, String> response = new HashMap<>();
		response.put("message", "Registro Completado");
		return ResponseEntity.ok(response);
	}
}
