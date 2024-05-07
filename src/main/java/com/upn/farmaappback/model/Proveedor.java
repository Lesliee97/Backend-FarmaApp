package com.upn.farmaappback.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "proveedor")
public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Nationalized
    @Column(name = "razon_social", nullable = false, length = 100)
    private String razonSocial;

    @Nationalized
    @Column(name = "ruc", nullable = false, length = 11)
    private String ruc;

    @Nationalized
    @Column(name = "num_contacto", length = 9)
    private String numContacto;

    @Nationalized
    @Column(name = "correo_contacto", length = 100)
    private String correoContacto;

    @OneToMany(mappedBy = "idProveedor")
    private Set<Medicamento> medicamentos = new LinkedHashSet<>();

}