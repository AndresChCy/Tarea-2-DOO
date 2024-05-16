package org.example;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Invitacion {
    private Instant hora;
    private List<Invitable> invitados;

    public Invitacion(Invitable invitado, Instant hora){
        this.invitados = invitado.invitar();
        this.hora = hora;

    }
    public List<Invitable> obtenerInvitados(){
        return invitados;
    }
}
