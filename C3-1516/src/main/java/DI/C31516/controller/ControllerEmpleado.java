package DI.C31516.controller;

import DI.C31516.domain.Empleado;
import DI.C31516.services.ServiceEmpleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping (value = "/di/empleado")
public class ControllerEmpleado {

    @Autowired
    ServiceEmpleado serviceEmpleado;

    @PostMapping (path = "/crearEmpleado", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Empleado> crearEmpleado(@RequestBody Empleado empleado){

        boolean condicion = serviceEmpleado.agregarEmpleado(empleado);

        if(condicion == true){
            return new ResponseEntity<Empleado>(empleado, HttpStatus.OK);
        }
        else{
            return new ResponseEntity("El empleado que quiere crear ya existe", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping (path = "/buscarEmpleadoPorCC/{cc}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Empleado> buscarEmpleadoPorCC(@PathVariable int cc){

        Empleado empleado = serviceEmpleado.buscarEmpleado(cc);

        if(empleado != null){
            return new ResponseEntity<Empleado>(empleado, HttpStatus.OK);
        }
        //TODO Preguntar por que no entra a este else.
        else{
            return new ResponseEntity("No se encontro al empleado", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping (path = "/listarEmpleados", produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<Empleado> lisarEmpleados(){
        return serviceEmpleado.listarEmpleados();
    }

    @DeleteMapping (path = "/borrarEmpleado/{cc}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> borrarEmpleadoPorCC(@PathVariable int cc){

        Empleado empleado = serviceEmpleado.buscarEmpleado(cc);

        if(empleado != null){
            serviceEmpleado.borrarEmpleado(empleado);
            return new ResponseEntity<Boolean>(true, HttpStatus.OK);
        }
        else{
            return new ResponseEntity("No se pudo borrar el empleado", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
