package org.example;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.List;

/**
 * Subclase de Reunion que representa una reunion del tipo virtual.
 */
public class ReunionVirtual extends Reunion {
    /**
     * Método constructor de ReunionVirtual que hereda los valores de la superclase Reunion.
     * @param organizador       El empleado que organiza la reunión.
     * @param fecha             La fecha en la que se realizará la reunión.
     * @param horaPrevista      La hora prevista de inicio de la reunión.
     * @param duracionPrevista  La duración prevista de la reunión.
     * @param invitados         La lista de empleados invitados a la reunión.
     */
    public ReunionVirtual(Empleado organizador, Date fecha, Instant horaPrevista, Duration duracionPrevista, List<Empleado> invitados) {
        super(organizador, fecha, horaPrevista, duracionPrevista, invitados);
    }

    private String enlace;

    /**
     * Método set que establece el enlace de la reunión.
     * @param enlace  String del enlace de la reunion.
     */
    public void setEnlace(String enlace) {
        this.enlace = enlace;
    }

    /**
     * Método get para obtener el enlace de la reunion.
     * @return String(enlace) de la reunion virtual.
     */
    public String getEnlace() {
        return enlace;
    }
}
