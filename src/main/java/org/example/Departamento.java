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
     * Agrega un nuevo empleado al departamento y establece automáticamente el departamento al que pertenece el empleado.
     *
     * @param id        El ID del empleado.
     * @param apellidos Los apellidos del empleado.
     * @param nombre    El nombre del empleado.
     * @param correo    El correo electrónico del empleado.
     */
    public void inscribirEmpleado(String id, String apellidos, String nombre, String correo) {
        Empleado empleado = new Empleado(id, apellidos, nombre, correo, this);
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
        // Crear un StringBuilder para construir la cadena de texto
        StringBuilder sb = new StringBuilder();
        // Agregar el nombre del departamento a la cadena
        sb.append("Departamento: ").append(nombre).append("\n");
        // Agregar la lista de empleados del departamento a la cadena
        sb.append("Empleados:\n");
        for (Empleado empleado : empleados) {
            sb.append("- ").append(empleado.getNombre()).append(" ").append(empleado.getApellidos()).append("\n");
        }
        // Devolver la cadena construida
        return sb.toString();
    }
}
