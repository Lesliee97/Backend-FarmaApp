package com.upn.farmaappback.service.dto;

import lombok.Data;

@Data
public class DireccionDTO {

    private Long id;
    private String nombre;
    private String referencia;
    private String calle;
    private String numero;
    private String indicaciones;
    private String numContacto;
    private Long idUsuario;
}
