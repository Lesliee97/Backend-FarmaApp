package com.upn.farmaappback.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "pago")
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Nationalized
    @Column(name = "estado", nullable = false, length = 50)
    private String estado;

    @Column(name = "fecha", nullable = false)
    private Instant fecha;

    @Column(name = "monto_pagado", nullable = false, precision = 5, scale = 2)
    private BigDecimal montoPagado;

    @Nationalized
    @Column(name = "tipo_tarjeta", nullable = false, length = 100)
    private String tipoTarjeta;

    @Nationalized
    @Column(name = "marca_tarjeta", nullable = false, length = 100)
    private String marcaTarjeta;

    @Column(name = "dig_tarjeta", nullable = false)
    private Integer digTarjeta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pedido")
    private Pedido idPedido;

}