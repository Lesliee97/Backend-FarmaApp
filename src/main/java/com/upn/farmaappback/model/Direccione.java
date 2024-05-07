package com.upn.farmaappback.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "direcciones")
public class Direccione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Nationalized
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Nationalized
    @Column(name = "referencia", length = 100)
    private String referencia;

    @Nationalized
    @Column(name = "calle", nullable = false, length = 100)
    private String calle;

    @Nationalized
    @Column(name = "numero", nullable = false, length = 10)
    private String numero;

    @Nationalized
    @Column(name = "indicaciones", length = 500)
    private String indicaciones;

    @Nationalized
    @Column(name = "num_contacto", length = 9)
    private String numContacto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario")
    private Usuario idUsuario;

}