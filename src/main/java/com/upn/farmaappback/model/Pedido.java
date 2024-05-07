package com.upn.farmaappback.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "pedido")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Nationalized
    @Column(name = "estado", nullable = false, length = 50)
    private String estado;

    @Column(name = "costo_envio", nullable = false, precision = 3, scale = 2)
    private BigDecimal costoEnvio;

    @Column(name = "fecha", nullable = false)
    private Instant fecha;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario")
    private Usuario idUsuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_direccion")
    private Direccione idDireccion;

    @Nationalized
    @Column(name = "cod_receta", length = 10)
    private String codReceta;

    @OneToMany(mappedBy = "idPedido")
    private Set<DetallePedido> detallePedidos = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idPedido")
    private Set<Pago> pagos = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idPedido")
    private Set<Tratamiento> tratamientos = new LinkedHashSet<>();

}