package org.example;
import java.util.ArrayList;

public class Departamento implements Invitable{
    private String nombre;
    private ArrayList<Empleado> empleados;
    public void invitar() {
        System.out.println("Invitando al departamento " + nombre);for (Empleado empleado : empleados) {
            empleado.invitar();
        }
    }
}
