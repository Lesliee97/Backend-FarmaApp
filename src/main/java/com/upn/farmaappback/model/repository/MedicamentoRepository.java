package com.upn.farmaappback.model.repository;

import com.upn.farmaappback.model.Medicamento;
import com.upn.farmaappback.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface MedicamentoRepository extends JpaRepository<Medicamento, Long> {

}
