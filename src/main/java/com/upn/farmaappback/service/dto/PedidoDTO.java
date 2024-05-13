package com.upn.farmaappback.service.dto;

import com.upn.farmaappback.model.Direccione;
import com.upn.farmaappback.model.Usuario;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

@Data
public class PedidoDTO {

    private Long id;
    private String estado;
    private BigDecimal costoEnvio;
    private Instant fecha;
    private Long idUsuario;
    private Long idDireccion;
    private String codReceta;
}
