package com.upn.farmaappback.model.repository;

import com.upn.farmaappback.model.CategoriaMed;
import com.upn.farmaappback.model.Medicamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface MedicamentoRepository extends JpaRepository<Medicamento, Long> {

  List<Medicamento> findMedicamentoByIdCategoria(CategoriaMed categoriaMed);

  @Query("SELECT m FROM Medicamento m WHERE LOWER(m.nombre) LIKE %:nombre%")
  List<Medicamento> findMedicamentoByNombre(@Param("nombre") String nombre);
}
