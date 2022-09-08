package com.co.software.empresas.desaInt.domain;

import lombok.Data;

@Data
public class MovimientoDinero {

    private Long montoMovimiento;
    private String conceptoMovimiento;
    private Empleado encargadoMovimiento;
}
