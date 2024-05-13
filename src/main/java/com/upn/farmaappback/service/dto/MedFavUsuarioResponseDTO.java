package com.upn.farmaappback.service.dto;

import lombok.Data;

import java.time.Instant;

@Data
public class MedFavUsuarioResponseDTO {

    private Long id;
    private Long idUsuario;
    private Long idMedicamento;
    private Instant fecha;

}
