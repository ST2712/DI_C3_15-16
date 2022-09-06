package com.co.software.empresas.desaInt.controller;

import com.co.software.empresas.desaInt.repository.EntityEmpleado;
import com.co.software.empresas.desaInt.services.ServiceEmpleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/empleado")
public class ControllerEmpleado {

    @Autowired
    ServiceEmpleado serviceEmpleado;

    @PostMapping(path = "insertarEmpleadoJPA", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> insertarEmpleadoJpa(@RequestBody EntityEmpleado empleado){

        return new ResponseEntity<Boolean>(serviceEmpleado.insertarEmpleadoJpa(empleado), HttpStatus.OK);
    }

    @GetMapping(path = "listarEmpleadosJpa", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> listarTodosJpa(){

        return new ResponseEntity<Object>(serviceEmpleado.listarTodosJpa(), HttpStatus.OK);
    }

    @DeleteMapping(path = "borrarEmpleadoJpa/{id}")
    public ResponseEntity<Boolean> borrarEmpleadoJpa(@PathVariable Long id){

        return new ResponseEntity<Boolean>(serviceEmpleado.borrarEmpleadoJpa(id), HttpStatus.OK);
    }
}
