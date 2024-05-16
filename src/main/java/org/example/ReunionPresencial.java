package org.example;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.List;

/**
 * Subclase de Reunion que representa una reunion del tipo presencial.
 */
public class ReunionPresencial extends Reunion {

    private String sala;
    /**
     * Método constructor de ReunionPresencial que hereda los valores de la superclase Reunion.
     * @param organizador       El empleado que organiza la reunión.
     * @param fecha             La fecha en la que se realizará la reunión.
     * @param horaPrevista      La hora prevista de inicio de la reunión.
     * @param duracionPrevista  La duración prevista de la reunión.
     * @param invitados         La lista de empleados invitados a la reunión.
     * @param sala              String de la sala.
     * @param tema              El tipo de reunión.
     */
    public ReunionPresencial(Empleado organizador, Date fecha, Instant horaPrevista, Duration duracionPrevista, List<Invitable> invitados, String sala,tipoReunion tema) {
        super(organizador, fecha, horaPrevista, duracionPrevista, invitados,tema);
        this.sala = sala;
    }

    /**
     * Método toString que devuelve la información de la clase.
     * @return String con la información heredada, más la sala de la reunion.
     */
    public String toString() {
        return super.toString() + "\n"
                + "Sala = " + sala + " }\n";
    }

    /**
     * Método get para obtener la sala de la reunion.
     * @return Sala de la reunion presencial.
     */
    public String getSala() {
        return sala;
    }
}
