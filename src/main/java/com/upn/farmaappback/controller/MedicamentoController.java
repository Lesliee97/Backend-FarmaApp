package com.upn.farmaappback.controller;

import com.upn.farmaappback.service.IMedicamento;
import com.upn.farmaappback.service.dto.MedicamentoInStockDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping("getAllMedicamentoInStockById/{id}")
    public ResponseEntity<Object> getAllMedicamentoInStockById(@PathVariable Long id) {
        List<MedicamentoInStockDTO> medicamentosInStock = iMedicamento.getAllMedicamentoInStockById(id);

        if (medicamentosInStock.isEmpty()) {
            String mensaje = "Medicamento no Encontrado";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensaje); // Devuelve 404 si no se encuentra ningún medicamento en stock con el ID proporcionado
        } else {
            return ResponseEntity.ok(medicamentosInStock);
        }
    }

    @GetMapping(value = "getAllMedicamentosByCategory/{idCategoria}")
    public ResponseEntity<Object> getAllMedicamentosByCategory(@PathVariable Long idCategoria){
        return ResponseEntity.ok(iMedicamento.getAllMedicamentosByCategoria(idCategoria));
    }

}
