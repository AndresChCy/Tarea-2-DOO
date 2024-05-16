package org.example;
import java.time.Instant;

public class Retraso extends Asistencia{
    private Instant hora;
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
