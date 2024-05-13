package com.upn.farmaappback.service.dto;

import lombok.Data;

@Data
public class DireccionesDTO {

    private Long id;
    private String nombre;
    private String referencia;
    private String calle;
    private String numero;
    private String indicaciones;
    private String num_contacto;
    private Long idUsuario;
}
