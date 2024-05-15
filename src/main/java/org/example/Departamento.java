package org.example;
import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase representa a un departamento de una organización.
 */
public class Departamento implements Invitable{
    private String nombre;
    private ArrayList<Empleado> empleados;
    /**
     * Constructor de la clase Departamento.
     *
     * @param nombre El nombre del departamento.
     */
    public Departamento(String nombre) {
        this.nombre = nombre;
        this.empleados = new ArrayList<>();
    }
    /**
     * Obtiene el nombre del departamento.
     *
     * @return El nombre del departamento.
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Agrega un empleado al departamento.
     *
     * @param empleado El empleado a agregar.
     */
    public void addEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }
    /**
     * Obtiene la cantidad de empleados en el departamento.
     *
     * @return La cantidad de empleados en el departamento.
     */
    public int obtenerCantidadEmpleados() {
        return empleados.size();
    }
    /**
     * Obtiene la lista de empleados del departamento.
     *
     * @return La lista de empleados del departamento.
     */
    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }
    /**
     * Invita a un empleado del departamento.
     *
     * @return Una lista que contiene al empleado invitado, o una lista vacía si no hay empleados.
     */
    @Override
    public List<Invitable> invitar() {
        List<Invitable> empleadosInvitados = new ArrayList<>();
        if (!empleados.isEmpty()) {
            for (Empleado empleado : empleados) {
                System.out.println("Invitando a " + empleado.getNombre() + " " + empleado.getApellidos());
                empleadosInvitados.add(empleado);
            }
        }
        return empleadosInvitados;
    }
    /**
     * Devuelve una representación en forma de cadena de texto del departamento.
     *
     * @return Una cadena de texto que representa al departamento.
     */
    @Override
    public String toString() {
        return "Departamento{ Nombre = " + nombre + ", Empleados = " + empleados + "}\n";
    }
}
