package com.upn.farmaappback.model.repository;

import com.upn.farmaappback.model.CategoriaMed;
import com.upn.farmaappback.model.Medicamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface MedicamentoRepository extends JpaRepository<Medicamento, Long> {

  List<Medicamento> findMedicamentoByIdCategoria(CategoriaMed categoriaMed);
}
