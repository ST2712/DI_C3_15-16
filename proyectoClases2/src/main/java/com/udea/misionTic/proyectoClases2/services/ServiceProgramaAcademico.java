package com.udea.misionTic.proyectoClases2.services;

import com.udea.misionTic.proyectoClases2.domain.Persona;
import com.udea.misionTic.proyectoClases2.repository.EntityPersona;
import com.udea.misionTic.proyectoClases2.repository.RepositoryPersona;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceProgramaAcademico {

    @Getter
    @Setter
    private String nombrePrograma;

    @Autowired
    RepositoryPersona repositoryPersona;

    ArrayList<Persona> listaP;

    public ServiceProgramaAcademico(ArrayList<Persona> listaP) {
        this.listaP = listaP;
    }

    public String inscribirAlumno(Persona alumno){
        String inscripcion = "El alumno " + alumno.getNombre() + " " + alumno.getApellido() + " con " + alumno.getEdad() + " años, quedó inscrito al programa.";

        return inscripcion;
    }

    public ArrayList<String> doWhile(int a){
        ArrayList<String> objTraza = new ArrayList();
        do{

            System.out.println("Hola mundo " + a);
            objTraza.add("Hola mundo " + String.valueOf(a));
            a++;
        }while(a < 10);
        return objTraza;
    }

    public boolean addPersona(Persona persona){

        Persona objPersona = new Persona();
        objPersona.setNombre(persona.getNombre());
        objPersona.setApellido(persona.getApellido());
        objPersona.setEdad(persona.getEdad());
        objPersona.setId(persona.getId());

        listaP.add(objPersona);

        return Boolean.TRUE;

    }

    public ArrayList<Persona> listar(){

        System.out.println("Metodo listar del service");

        return listaP;
    }

    public Persona buscarPersona(int id){

        Persona persona = null;

        int dato = 0;

        for(Persona p: listaP){
            if(p.getId() == id){
                return p;
            }
        }

        return persona;
    }

    public boolean addPersonaCC(Persona persona, String doc){

        Persona objPersona = new Persona();
        objPersona.setNombre(persona.getNombre());
        objPersona.setApellido(persona.getApellido());
        objPersona.setEdad(persona.getEdad());
        objPersona.setId(persona.getId());
        objPersona.setDoc(doc);

        System.out.println("Creo la persona con cedula de ciudadania");

        listaP.add(objPersona);

        return Boolean.TRUE;

    }

    public boolean addPersonaTI(Persona persona, String doc){

        Persona objPersona = new Persona();
        objPersona.setNombre(persona.getNombre());
        objPersona.setApellido(persona.getApellido());
        objPersona.setEdad(persona.getEdad());
        objPersona.setId(persona.getId());
        objPersona.setDoc(doc);

        System.out.println("Creo la persona con tarjeta de identidad");

        listaP.add(objPersona);

        return Boolean.TRUE;

    }

    public Boolean borrarPersona(Persona persona){

        listaP.remove(persona);

        return Boolean.TRUE;
    }

    public List<EntityPersona> listarTodosJPA(){

        List<EntityPersona> list = repositoryPersona.findAll();

        return list;

    }

    public Boolean insertarPersonaJPA(EntityPersona persona){

        try{
            repositoryPersona.save(persona);
        }catch (Exception e){
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    public Boolean actualizarTodoJPA(EntityPersona persona){
        try{
            repositoryPersona.save(persona);
        }catch (Exception e){
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    public void actualizarParcialJPA(EntityPersona persona){

        EntityPersona perTemp =  repositoryPersona.findById(persona.getId()).orElse(null);

        if(persona.getNombre() != null){
            perTemp.setNombre(persona.getNombre());
        }
        else if(persona.getApellido() != null){
            perTemp.setApellido(persona.getApellido());
        }
        else if(persona.getEdad() != null){
            perTemp.setEdad(persona.getEdad());
        }
        else if(persona.getDoc() != null){
            perTemp.setDoc(persona.getDoc());
        }
        else if(persona.getContraseña() != null){
            perTemp.setContraseña(persona.getContraseña());
        }

        repositoryPersona.save(perTemp);
    }

    public void borrarPersonaJPA(Long id){

        repositoryPersona.deleteById(id);
    }

}