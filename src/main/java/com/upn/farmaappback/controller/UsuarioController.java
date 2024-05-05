package com.upn.farmaappback.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upn.farmaappback.service.IUsuario;

@RestController
@RequestMapping("/usuario")
@CrossOrigin("*")
public class UsuarioController {

	@Autowired
	private IUsuario iUsuario;
	
	@GetMapping(value="getAll")
	public ResponseEntity<Object> getAll(){
		return ResponseEntity.ok(iUsuario.getAllUsuarios());
	}
}
