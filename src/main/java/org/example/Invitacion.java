package org.example;
import java.time.Instant;
import java.util.List;

public class Invitacion {
    private Instant hora;
    private List<Invitable> invitados;

    public Invitacion(List<Invitable> invitados, Instant hora){
        this.invitados = invitados;
        this.hora = hora;
    }
}
