package org.example;

/**
 * Clase para marcar la asistencia de un empleado
 */
public class Asistencia {
    /** Empleado que llego a tiempo a lo que le invitaron */
    private Empleado empleado ;

    /**
     * Metodo constructor que asigna el empleado que marca su asistencia
     * @param empleado empleado que llego
     */
    public Asistencia(Empleado empleado){
        this.empleado = empleado ;
    }
}
