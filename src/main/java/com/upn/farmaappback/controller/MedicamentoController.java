package com.upn.farmaappback.controller;

import com.upn.farmaappback.service.IMedicamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medicamentos")
@CrossOrigin("*")
public class MedicamentoController {

    @Autowired
    private IMedicamento iMedicamento;

    @GetMapping(value = "getAllMedicamentos")
    public ResponseEntity<Object> getAllMedicamentos() {
        return ResponseEntity.ok(iMedicamento.getAllMedicamentoEnStock());
    }


}
