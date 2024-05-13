package com.upn.farmaappback.service.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class MedFavUsuarioRequestDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long idUsuario;
    private Long idMedicamento;
}
