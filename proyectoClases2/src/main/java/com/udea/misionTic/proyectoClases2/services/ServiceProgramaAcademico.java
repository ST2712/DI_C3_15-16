package com.udea.misionTic.proyectoClases2.services;

import com.udea.misionTic.proyectoClases2.domain.Persona;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ServiceProgramaAcademico {

    @Getter
    @Setter
    private String nombrePrograma;

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

}