package com.upn.farmaappback.service.impl;

import com.upn.farmaappback.model.repository.CategoriaRepository;
import com.upn.farmaappback.service.ICategoria;
import com.upn.farmaappback.service.dto.CategoriaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class CategoriaServiceImpl implements ICategoria {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public List<CategoriaDTO> getAllCategorias() {
        final List<CategoriaDTO> response = new ArrayList<CategoriaDTO>();

        this.categoriaRepository.findAll().forEach(categoria -> {
            CategoriaDTO categoriaResponse = new CategoriaDTO();
            categoriaResponse.setId(categoria.getId());
            categoriaResponse.setNombre(categoria.getNombre());
            categoriaResponse.setDescripcion(categoria.getDescripcion());

            response.add(categoriaResponse);
        });
        return response;
    }
}
