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
@Table(name = "categoria_med")
public class CategoriaMed {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Nationalized
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Nationalized
    @Column(name = "descripcion", length = 200)
    private String descripcion;

    @OneToMany(mappedBy = "idCategoria")
    private Set<Medicamento> medicamentos = new LinkedHashSet<>();

}