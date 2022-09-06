package com.co.software.empresas.desaInt.services;

import com.co.software.empresas.desaInt.repository.EntityEmpleado;
import com.co.software.empresas.desaInt.repository.RepositoryEmpleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceEmpleado {

    @Autowired
    RepositoryEmpleado repositoryEmpleado;

    public Boolean insertarEmpleadoJpa(EntityEmpleado empleado){

        try{
            repositoryEmpleado.save(empleado);
        } catch (Exception e){
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    public List<EntityEmpleado> listarTodosJpa(){

        List<EntityEmpleado> list =repositoryEmpleado.findAll();
        return list;
    }

    public Boolean borrarEmpleadoJpa(Long id){

        List<EntityEmpleado> list = listarTodosJpa();
        Boolean encontrado = Boolean.FALSE;

        for (int i = 0; i < list.size() && !encontrado; i++){

            EntityEmpleado empleadoActual = list.get(i);
            if( empleadoActual.getId() == id){
                repositoryEmpleado.delete(empleadoActual);
                encontrado = Boolean.TRUE;
            }
        }
        return encontrado;
    }
}
