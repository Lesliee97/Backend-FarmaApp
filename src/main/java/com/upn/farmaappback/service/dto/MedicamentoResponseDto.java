package com.upn.farmaappback.service.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class MedicamentoResponseDto
{
    private Long id;
    private String nombre;
    private String formaFarmaceutica;
    private double precioUnitario;
    private Integer stock;
    private String nombreCategoria;
}
