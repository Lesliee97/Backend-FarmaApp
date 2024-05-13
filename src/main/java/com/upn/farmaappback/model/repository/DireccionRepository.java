package com.upn.farmaappback.model.repository;

import com.upn.farmaappback.model.Direccione;
import com.upn.farmaappback.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DireccionRepository extends JpaRepository<Direccione, Long> {

    List<Direccione> findByIdUsuario(Usuario idUsuario);
}
