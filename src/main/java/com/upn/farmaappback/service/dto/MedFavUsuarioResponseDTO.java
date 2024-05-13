package com.upn.farmaappback.service.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.Instant;

@Data
public class MedFavUsuarioResponseDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private Long idUsuario;
    private Long idMedicamento;
    private Instant fecha;

}
