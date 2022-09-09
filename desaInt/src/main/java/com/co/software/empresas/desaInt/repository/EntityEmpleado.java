package com.co.software.empresas.desaInt.repository;

import com.co.software.empresas.desaInt.util.EnumRol;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Data
@Entity
@Table(name = "empleado")
public class EntityEmpleado {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "correo")
    private String correo;
    //TODO Modificar y preguntar para que sea de tipo empresa y no Sring
    @Column(name = "empresa")
    private String empresa;

    @Column(name = "rol")
    @Enumerated(EnumType.STRING)
    private EnumRol rol;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado")
    @JsonIgnore
    private Collection<EntityMovimientoDinero> movimientoDineroCollection;
}
