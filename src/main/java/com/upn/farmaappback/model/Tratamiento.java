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
@Table(name = "tratamientos")
public class Tratamiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Nationalized
    @Column(name = "frecuencia", nullable = false, length = 100)
    private String frecuencia;

    @Nationalized
    @Column(name = "hora", nullable = false, length = 50)
    private String hora;

    @Nationalized
    @Column(name = "estado", nullable = false, length = 50)
    private String estado;

    @Column(name = "dosis", nullable = false, precision = 5, scale = 2)
    private BigDecimal dosis;

    @Column(name = "fecha_inicio", nullable = false)
    private Instant fechaInicio;

    @Column(name = "fecha_fin", nullable = false)
    private Instant fechaFin;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pedido")
    private Pedido idPedido;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_medicamento")
    private Medicamento idMedicamento;

}