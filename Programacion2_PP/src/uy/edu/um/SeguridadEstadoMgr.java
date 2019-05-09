package uy.edu.um;

import uy.edu.um.Exeptionss.InfraccionNoExiste;
import uy.edu.um.Exeptionss.PersonaNoExiste;
import uy.edu.um.Exeptionss.PersonaYaExiste;
import uy.edu.um.Persona;
import uy.edu.um.Infraccion;
import uy.edu.um.Reclamo;
import uy.edu.um.adt.binarytree.withnode.SearchBinaryTreeImpl;

import java.util.ArrayList;

public class SeguridadEstadoMgr implements SeguridadEstadioMgt {
    private SearchBinaryTreeImpl<Persona> personas;
    private ArrayList<Persona> personasBloqueadas= new ArrayList<Persona>(5000);


    public void agregarPersona(String cedula, String nombre, String apellido) throws PersonaYaExiste {
         Persona personAux = new Persona(cedula,nombre,apellido);
         if(this.personas.contains(personAux)){
             throw new PersonaYaExiste();
         }
         personas.add(personAux);
    }

    public void agregarInfraccion(String cedula, long idInfraccion, String descripcion) throws PersonaNoExiste {

    }

    public boolean personaEstaHabilitada(String cedula) throws PersonaNoExiste {
        boolean boolTemp=true;
        for(int i =0;i<personasBloqueadas.size();i++){
            if(personasBloqueadas.get(i).getCedula() == Long.parseLong(cedula)){

            }
        }

        return false;
    }

    public void agregarReclamo(String cedula, long idInfraccion, String descripcion) throws PersonaNoExiste, InfraccionNoExiste {

    }

    public void anularInfraccion(String cedula, long idInfraccion) throws PersonaNoExiste, InfraccionNoExiste {

    }

    public void generarReclamo(Persona)
}















}







