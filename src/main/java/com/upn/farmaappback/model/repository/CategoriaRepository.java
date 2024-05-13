package com.upn.farmaappback.model.repository;

import com.upn.farmaappback.model.CategoriaMed;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoriaRepository extends JpaRepository<CategoriaMed,Long> {

}
