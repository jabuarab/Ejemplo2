package uy.edu.um;


import uy.edu.um.Exeptionss.InfraccionNoExiste;
import uy.edu.um.Exeptionss.PersonaNoExiste;

import uy.edu.um.Exeptionss.PersonaYaExiste;

public interface SeguridadEstadioMgt {
    void agregarPersona(String cedula,  String nombre, String apellido) throws PersonaYaExiste;

    void agregarInfraccion(String cedula, long idInfraccion, String descripcion) throws PersonaNoExiste;

    boolean personaEstaHabilitada(String cedula) throws PersonaNoExiste;

    void agregarReclamo(String cedula, long idInfraccion, String descripcion) throws PersonaNoExiste, InfraccionNoExiste;

    void anularInfraccion(String cedula, long idInfraccion) throws PersonaNoExiste, InfraccionNoExiste;

}
