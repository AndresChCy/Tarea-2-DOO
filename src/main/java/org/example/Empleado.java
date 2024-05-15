package org.example;

public class Empleado implements Invitable{
    private String id;
    private String apellidos;
    private String nombre;
    private String correo;
    public void invitar() {
        System.out.println("Invitando a " + nombre + " " + apellidos);
    }
}
