package DI.C31516.domain;

import lombok.Data;

@Data public class MovimientoDinero {

    private int montoMovimientoDinero;
    private String conceptoMovimiento;
    private Empleado empleado;

}
