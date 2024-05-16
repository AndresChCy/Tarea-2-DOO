package org.example;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.List;

/**
 * Subclase de Reunion que representa una reunion del tipo virtual.
 */
public class ReunionVirtual extends Reunion {

    private String enlace;
    /**
     * Método constructor de ReunionVirtual que hereda los valores de la superclase Reunion.
     * @param organizador       El empleado que organiza la reunión.
     * @param fecha             La fecha en la que se realizará la reunión.
     * @param horaPrevista      La hora prevista de inicio de la reunión.
     * @param duracionPrevista  La duración prevista de la reunión.
     * @param invitados         La lista de empleados invitados a la reunión.
     * @param enlace            String del enlace de la reunion.
     */
    public ReunionVirtual(Empleado organizador, Date fecha, Instant horaPrevista, Duration duracionPrevista, List<Empleado> invitados, String enlace) {
        super(organizador, fecha, horaPrevista, duracionPrevista, invitados);
        this.enlace = enlace;
    }

    /**
     * Método toString que devuelve la información de la clase.
     * @return String con la información heredada, más el enlace de la reunion.
     */
    public String toString() {
        return super.toString() + "\n"
                + "Enlace = " + enlace + " }\n";
    }

    /**
     * Método get para obtener el enlace de la reunion.
     * @return String(enlace) de la reunion virtual.
     */
    public String getEnlace() {
        return enlace;
    }
}
