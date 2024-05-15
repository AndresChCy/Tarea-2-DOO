package org.example;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.List;

/**
 * Subclase de Reunion que representa una reunion del tipo presencial.
 */
public class ReunionPresencial extends Reunion {
    /**
     * Método constructor de ReunionPresencial que hereda los valores de la superclase Reunion.
     * @param organizador       El empleado que organiza la reunión.
     * @param fecha             La fecha en la que se realizará la reunión.
     * @param horaPrevista      La hora prevista de inicio de la reunión.
     * @param duracionPrevista  La duración prevista de la reunión.
     * @param invitados         La lista de empleados invitados a la reunión.
     */
    public ReunionPresencial(Empleado organizador, Date fecha, Instant horaPrevista, Duration duracionPrevista, List<Empleado> invitados) {
        super(organizador, fecha, horaPrevista, duracionPrevista, invitados);
    }

    private String sala;

    /**
     * Método set que establece la sala de la reunión.
     * @param sala  String de la sala.
     */
    public void setSala(String sala) {
        this.sala = sala;
    }

    /**
     * Método get para obtener la sala de la reunion.
     * @return Sala de la reunion presencial.
     */
    public String getSala() {
        return sala;
    }
}
