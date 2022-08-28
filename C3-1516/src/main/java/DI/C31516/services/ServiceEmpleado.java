package DI.C31516.services;

import DI.C31516.domain.Empleado;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ServiceEmpleado {

    private ArrayList<Empleado> listaEmpleados;

    public ServiceEmpleado(ArrayList<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    public boolean agregarEmpleado(Empleado empleado){

        boolean agregado = false;
        boolean esRepetido = false;
        int cedula = empleado.getNumCedula();

        for (int i = 0; i < listaEmpleados.size(); i++) {

            if(cedula == listaEmpleados.get(i).getNumCedula()){
                esRepetido = true;
            }
        }

        if(!esRepetido){
            listaEmpleados.add(empleado);
            agregado = true;
        }

        return agregado;
    }

    public Empleado buscarEmpleado(int numCedula){

        Empleado aBuscar = null;

        for(int i = 0; i < listaEmpleados.size(); i++){

            if(listaEmpleados.get(i).getNumCedula() == numCedula){
                aBuscar = listaEmpleados.get(i);
            }
        }

        return aBuscar;
    }

    public boolean borrarEmpleado(Empleado empleado){

        boolean borrado = false;

        if(buscarEmpleado(empleado.getNumCedula()) != null){
            listaEmpleados.remove(empleado);
            borrado = true;
        }

        return borrado;
    }

    public ArrayList<Empleado> listarEmpleados(){
        return listaEmpleados;
    }
}
