package uy.edu.um;

import java.util.ArrayList;

public class Persona implements Comparable<Persona> {

    private String nombre;
    private long cedula;
    private String apellido;
    private ArrayList<Infraccion> infraccioens;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getCedula() {
        return cedula;
    }

    public void setCedula(long cedula) {
        this.cedula = cedula;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Persona(String cedula, String nombre, String apellido) {
    this.cedula= Long.parseLong(cedula);
    this.nombre =nombre;
    this.apellido=apellido;
    this.infraccioens = new ArrayList<Infraccion>(100);

    }
    public int compareTo(Persona o) {
        int a = 0;
        if(this.cedula != o.getCedula()){
            if(this.cedula < o.getCedula()){
                a = -1;
            }
            else{
                a=1;
            }
        }
        return a;

    }
}
