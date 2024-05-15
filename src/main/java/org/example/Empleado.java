package org.example;

/**
 * Esta clase representa a un empleado con su respectiva información.
 */
public class Empleado implements Invitable{
    private String id;
    private String apellidos;
    private String nombre;
    private String correo;
    /**
     * Constructor de la clase Empleado.
     *
     * @param id        El ID del empleado.
     * @param apellidos Los apellidos del empleado.
     * @param nombre    El nombre del empleado.
     * @param correo    El correo electrónico del empleado.
     */
    public Empleado (String id, String apellidos, String nombre, String correo) {
        this.id = id;
        this.apellidos = apellidos;
        this.nombre = nombre;
        this.correo = correo;
    }

    // Métodos getters

    public String getId() {
        return id;
    }
    public String getApellidos() {
        return apellidos;
    }
    public String getNombre() {
        return nombre;
    }
    public String getCorreo() {
        return correo;
    }
    /**
     * Invita al empleado a algo.
     */
    public void invitar() {
        System.out.println("Invitando a " + nombre + " " + apellidos);
    }
    /**
     * Devuelve una representación en forma de cadena de texto del empleado.
     *
     * @return Una cadena de texto que representa al empleado.
     */
    public String toString() {
        return "Empleado{ Nombre = " + nombre + ", Apellidos = " +
                apellidos + ", Id = " + id + ", Correo = " + correo + "}\n";
    }
}
