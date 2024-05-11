package org.example;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.List;

public class ReunionVirtual extends Reunion {
    public ReunionVirtual(Date fecha, Instant horaPrevista, Duration duracionPrevista, List<Empleado> invitados) {
        super(fecha, horaPrevista, duracionPrevista, invitados);
    }

    private String enlace;

    public void setEnlace(String enlace) {
        this.enlace = enlace;
    }

    public String getEnlace() {
        return enlace;
    }
}
