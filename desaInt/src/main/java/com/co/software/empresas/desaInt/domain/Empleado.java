package com.co.software.empresas.desaInt.domain;

import com.co.software.empresas.desaInt.util.EnumRol;
import lombok.Data;

@Data
public class Empleado {

    private String nombre;
    private String correo;
    //TODO Modificar atributo para que sea de tipo empresa y no String
    private String empresa;
    private EnumRol rol;
}
