package com.upn.farmaappback.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upn.farmaappback.model.Usuario;
import com.upn.farmaappback.model.repository.UsuarioRepository;
import com.upn.farmaappback.service.IUsuario;

@Service
public class UsuarioServiceImpl implements IUsuario{

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public List<Usuario> getAllUsuarios() {
		// TODO Auto-generated method stub
		return usuarioRepository.findAll();
	}

}
