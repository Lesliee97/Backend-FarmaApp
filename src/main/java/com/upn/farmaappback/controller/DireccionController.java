package com.upn.farmaappback.controller;

import com.upn.farmaappback.service.IDireccion;
import com.upn.farmaappback.service.dto.DireccionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/direcciones")
@CrossOrigin("*")
public class DireccionController {

    @Autowired
    private IDireccion iDireccion;

    @GetMapping("getAllDirecciones/{idUsuario}")
    public ResponseEntity<Object> getAllDirecciones(@PathVariable Long idUsuario){

        List<DireccionDTO> direccionDTO = iDireccion.getAllDirecciones(idUsuario);
        if(direccionDTO.isEmpty()){
            String mensaje = "Dirección no Encontrada";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensaje);
        }else {
            return ResponseEntity.ok(direccionDTO);
        }
    }

    @PostMapping("/saveDireccion")
    public ResponseEntity<DireccionDTO> saveDireccion(@RequestBody DireccionDTO direccionDTO) {
        DireccionDTO direccionGuardadaDTO = iDireccion.saveDireccion(direccionDTO);
        return new ResponseEntity<>(direccionGuardadaDTO, HttpStatus.CREATED);
    }
}
