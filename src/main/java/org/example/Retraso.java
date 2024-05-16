package org.example;
import java.time.Instant;

/**
 * Clase para marcar la asistencia atrasada de un empleado a un evento
 */
public class Retraso extends Asistencia{
    /** Hora a la que llego el empleado */
    private Instant hora;

    /**
     * Metodo constructor que asigna la hora actual de llegada y el empleado que esta llegando
     * @param empleado el empleado que acaba de llegar
     */
    public Retraso(Empleado empleado){
        super(empleado);
        hora = Instant.now();
    }

    /**
     * Metodo para obtener los datos y hora de llegada del empleado
      * @return un string con los datos y hora del empleado
     */
    @Override
    public String toString(){
        return super.toString() + " hora de llegada: " + this.hora.toString();
    }
}
