package com.upn.farmaappback.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.upn.farmaappback.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	Optional<Usuario> findByUsername(String username);
}
