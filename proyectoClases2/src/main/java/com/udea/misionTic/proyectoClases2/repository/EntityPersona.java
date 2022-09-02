package com.udea.misionTic.proyectoClases2.repository;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "persona")
public class EntityPersona {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "edad")
    private Long edad;

    @Column(name = "doc")
    private String doc;

    @Column(name = "contraseña")
    private String contraseña;
}
