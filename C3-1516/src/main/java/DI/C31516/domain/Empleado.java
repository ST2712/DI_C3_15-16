package DI.C31516.domain;

import lombok.Data;

@Data
public class Empleado {

    public enum Rol{
        ADMINISTRADOR, OPERATIVO;
    }

    private String nombre;
    private String correo;
    private String nombreEmpresaPertenece;
    private int numCedula;
    private Rol rolEmpleado;

}
