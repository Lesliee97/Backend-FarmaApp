package com.upn.farmaappback.controller;

import com.upn.farmaappback.model.repository.CategoriaRepository;
import com.upn.farmaappback.service.ICategoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categorias")
@CrossOrigin("*")
public class CategoriaController {
    @Autowired
    private ICategoria iCategoria;

    @GetMapping(value = "getAllCategorias")
    public ResponseEntity<Object> getAllCategorias() {
        return ResponseEntity.ok(iCategoria.getAllCategorias());
    }
}
