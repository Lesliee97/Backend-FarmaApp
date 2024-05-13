package com.upn.farmaappback.service.dto;

import lombok.Data;

@Data
public class MedicamentoInStockDTO {
    private Long id;
    private String nombre;
    private String concentracion;
    private String formaFarmaceutica;
    private double precioUnitario;
    private Integer stock;
    private String principioActivo;
    private Character es_restringido;
    private String nombreCategoria;
}
