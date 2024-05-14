package com.upn.farmaappback.model.repository;

import com.upn.farmaappback.model.MedFavUsuario;
import com.upn.farmaappback.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedFavUsuarioRepository extends JpaRepository<MedFavUsuario, Long> {

    List<MedFavUsuario> findMedFavUsuarioByIdUsuario(Usuario usuario);

}
