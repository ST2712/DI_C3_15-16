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
    private Rol rolEmpleado;

    public Empleado(Rol rolEmpleado){
        this.rolEmpleado = rolEmpleado;
    }

}
