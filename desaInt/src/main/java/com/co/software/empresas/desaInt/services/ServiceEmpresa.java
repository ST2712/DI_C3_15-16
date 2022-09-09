package com.co.software.empresas.desaInt.services;

import com.co.software.empresas.desaInt.repository.EntityEmpresa;
import com.co.software.empresas.desaInt.repository.RepositoryEmpresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceEmpresa {

    @Autowired
    RepositoryEmpresa repositoryEmpresa;

    public Boolean insertarEmpresaJpa(EntityEmpresa empresa){

        try{
            repositoryEmpresa.save(empresa);
        }catch (Exception e){
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    public List<EntityEmpresa> listarEmpresasJpa(){

         List<EntityEmpresa> list = repositoryEmpresa.findAll();
         return list;
    }

    public Boolean borrarEmpresaJpa(Long id){

        Boolean encontrado = Boolean.FALSE;
        List<EntityEmpresa> list = listarEmpresasJpa();

        for (int i = 0; i < list.size(); i++) {

            EntityEmpresa empresaActual = list.get(i);
            if(empresaActual.getId() == id){
                repositoryEmpresa.delete(empresaActual);
                encontrado = Boolean.TRUE;
            }
        }
        return encontrado;
    }
}
