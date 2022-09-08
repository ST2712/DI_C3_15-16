package com.co.software.empresas.desaInt.repository;

import com.co.software.empresas.desaInt.domain.Empleado;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "movimiento_dinero")
public class EntityMovimientoDinero {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "monto_movimiento")
    private Long montoMoviento;

    @Column(name = "concepto_movimiento")
    private String conceptoMovimiento;

    @Column(name = "encargado_movimiento")
    //TODO Preguntar como hacer que sirva con la clase Empleado
    private String empleado;
}
