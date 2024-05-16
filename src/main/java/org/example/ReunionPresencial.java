package org.example;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.List;

public class ReunionPresencial extends Reunion {
    public ReunionPresencial(Date fecha, Instant horaPrevista, Duration duracionPrevista, List<Invitable> invitados) {
        super(fecha, horaPrevista, duracionPrevista, invitados);
    }

    private String sala;

    public void setSala(String sala) {
        this.sala = sala;
    }

    public String getSala() {
        return sala;
    }
}
