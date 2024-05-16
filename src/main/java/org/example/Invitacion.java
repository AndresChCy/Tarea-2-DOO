package org.example;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

/**
 * Una invitación para alguien a cierta hora
 */
public class Invitacion {
    /**Instant para marcar la hora a la que hay que llegar */
    private Instant hora;
    /** Lista de invitados a las que fue enviada esta invitación*/
    private List<Invitable> invitados;

    /**
     * Constructor que asigna la hora e invita al individuo o grupo metiendolos en la lista
     * @param invitado a quien va dirigido esta invitación
     * @param hora hora para el evento al cual presentarse
     */
    public Invitacion(Invitable invitado, Instant hora){
        this.invitados = invitado.invitar();
        this.hora = hora;

    }

    /**
     * Obtener la lista de invitados de esta invitación
     * @return la lista de invitados
     */
    public List<Invitable> obtenerInvitados(){
        return invitados;
    }
}
