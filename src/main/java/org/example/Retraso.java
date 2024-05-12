package org.example;
import java.time.Instant;

public class Retraso extends Asistencia{
    private Instant hora;
    public Retraso(Empleado empleado){
        super(empleado);
        hora = Instant.now();
    }
}
