package com.upn.farmaappback.controller;

import com.upn.farmaappback.service.IMedFavUsuario;
import com.upn.farmaappback.service.dto.DireccionDTO;
import com.upn.farmaappback.service.dto.MedFavUsuarioRequestDTO;
import com.upn.farmaappback.service.dto.MedFavUsuarioResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/favoritos")
@CrossOrigin("*")
public class MedFavUsuarioController {

    @Autowired
    private IMedFavUsuario medFavUsuario;

    @PostMapping("/saveMedFavUsuario")
    public ResponseEntity<Object> saveMedFavUsuario(@RequestBody MedFavUsuarioRequestDTO medFavUsuarioRequestDTO) {
        MedFavUsuarioResponseDTO savedMedFavUsuario = medFavUsuario.saveMedFavUsuario(medFavUsuarioRequestDTO);
        return new ResponseEntity<>(savedMedFavUsuario, HttpStatus.CREATED);
    }

    @GetMapping("getAllFavoritosUsuario/{idUsuario}")
    public ResponseEntity<Object> getAllFavoritosUsuario(@PathVariable Long idUsuario){

        List<MedFavUsuarioResponseDTO> response = medFavUsuario.getAllMedFavByUsuario(idUsuario);
        if(response.isEmpty()){
            String mensaje = "Favoritos no Encontrados";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensaje);
        }else {
            return ResponseEntity.ok(response);
        }
    }
}
