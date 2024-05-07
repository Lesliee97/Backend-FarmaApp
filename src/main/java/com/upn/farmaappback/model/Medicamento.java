package com.upn.farmaappback.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "medicamentos")
public class Medicamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Nationalized
    @Column(name = "nombre", nullable = false, length = 500)
    private String nombre;

    @Column(name = "concentracion", nullable = false, length = 200)
    private String concentracion;

    @Nationalized
    @Column(name = "forma_farmaceutica", nullable = false, length = 50)
    private String formaFarmaceutica;

    @Column(name = "precio_unitario", nullable = false, precision = 6, scale = 2)
    private double precioUnitario;

    @Column(name = "stock", nullable = false)
    private Integer stock;

    @Nationalized
    @Column(name = "principio_activo", nullable = false, length = 200)
    private String principioActivo;

    @Column(name = "imagen")
    private byte[] imagen;

    @Column(name = "es_restringido")
    private Character esRestringido;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_proveedor")
    private Proveedor idProveedor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_categoria")
    private CategoriaMed idCategoria;

}