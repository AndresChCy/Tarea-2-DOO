package org.example;
import java.util.ArrayList;
import java.util.List;


/**
 * Esta clase representa a un empleado con su respectiva información.
 */

public class Empleado implements Invitable{
    private String id;
    private String apellidos;
    private String nombre;
    private String correo;
    private Departamento departamento;
    /**
     * Constructor de la clase Empleado.
     *
     * @param id        El ID del empleado.
     * @param apellidos Los apellidos del empleado.
     * @param nombre    El nombre del empleado.
     * @param correo    El correo electrónico del empleado.
     * @param departamento El departamento al que pertenece el empleado.
     */
    public Empleado (String id, String apellidos, String nombre, String correo, Departamento departamento) {
        this.id = id;
        this.apellidos = apellidos;
        this.nombre = nombre;
        this.correo = correo;
        this.departamento = departamento;
    }

    // Métodos getters

    /**
     * Obtiene los apellidos del empleado.
     * @return Los apellidos del empleado.
     */
    public String getApellidos() {
        return apellidos;
    }
    /**
     * Obtiene el nombre del empleado.
     * @return El nombre del empleado.
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Obtiene el nombre del departamento al que pertenece el empleado.
     * @return El nombre del departamento del empleado.
     */
    public String getDepartamento() {
        return departamento.getNombre();
    }

    /**
     * Invita al empleado a algo.
     *
     * @return Una lista que contiene al empleado invitado.
     */
    @Override
    public List<Invitable> invitar() {
        List<Invitable> empleadoInvitado = new ArrayList<>();
        empleadoInvitado.add(this);
        System.out.println("Invitando a " + nombre + " " + apellidos);
        return empleadoInvitado;
    }
    /**
     * Devuelve una representación en forma de cadena de texto del empleado.
     *
     * @return Una cadena de texto que representa al empleado.
     */
    @Override
    public String toString() {
        return "Empleado{Nombre = " + nombre + ", Apellidos = " +
                apellidos + ", Id = " + id + ", Correo = " + correo
                + ", Departamento = " + this.getDepartamento() + "}\n";
    }

}
