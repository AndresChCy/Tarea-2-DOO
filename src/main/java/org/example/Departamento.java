package org.example;
import java.util.ArrayList;

public class Departamento implements Invitable{
    private String nombre;
    private ArrayList<Empleado> empleados;
    //Constructor
    public Departamento(String nombre) {
        this.nombre = nombre;
        this.empleados = new ArrayList<>();
    }
    // Método getter
    public String getNombre() {
        return nombre;
    }
    // Método para agregar empleado al departamento
    public void addEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }
    // Método para obtener la cantidad de empleados en el departamento
    public int obtenerCantidadEmpleados() {
        return empleados.size();
    }
    // Método para obtener la lista de empleados del departamento
    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }
    public void invitar() {
        System.out.println("Invitando al departamento " + nombre);for (Empleado empleado : empleados) {
            empleado.invitar();
        }
    }
}
