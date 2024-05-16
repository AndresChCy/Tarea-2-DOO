package org.example;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public abstract class Reunion {
    private Date fecha;
    private Instant horaPrevista;
    private Duration duracionPrevista;
    private List<Invitable> ausentes;
    private List<Invitacion> invitaciones;
    private Instant horaInicio;
    private Instant horaFin;
    private List<Asistencia> asistenciaList;
    private List<Asistencia> retrasoList;

    public Reunion(Date fecha, Instant horaPrevista, Duration duracionPrevista, List<Invitable> invitados) {
        this.fecha = fecha;
        this.horaPrevista = horaPrevista;
        this.duracionPrevista = duracionPrevista;
        asistenciaList = new ArrayList<Asistencia>();
        retrasoList = new ArrayList<Asistencia>();
        this.ausentes = new ArrayList<Invitable>();
        this.invitaciones = new ArrayList<Invitacion>();
        for (Invitable invitado : invitados){
            this.invitaciones.add(new Invitacion(invitado, horaPrevista));
        }
        for(int i = 0 ; i < this.invitaciones.size();i++){
            this.ausentes.addAll(this.invitaciones.get(i).obtenerInvitados());
        }

    }

    public Date getFecha() {
        return fecha;
    }

    public Instant getHoraPrevista() {
        return horaPrevista;
    }

    public Duration getDuracionPrevista() {
        return duracionPrevista;
    }

    public List<Asistencia> obtenerAsistencas() {
        return asistenciaList;
    }

    public List<Invitable> obtenerAusencias() {
        return ausentes;
    }
    public List<Asistencia> obtenerRetrasos() {
        return retrasoList;
    }
    public int obtenerTotalAsistencia() {
        return retrasoList.size() + asistenciaList.size();
    }
    public float obtenerPorcentajeAsistencia() {
        float asistencias = retrasoList.size() + asistenciaList.size();
        float todos = retrasoList.size() + asistenciaList.size() + ausentes.size();
        float porcentajeAsistencia= asistencias/todos;
        return porcentajeAsistencia*100;
    }

    public float calcularTiempoReal() {
        if ( horaInicio!=null && horaFin!=null ) {
            Duration duracion = Duration.between(horaInicio,horaFin);
            return duracion.toMillis()/1000.0000f; //Devolver tiempo en segundos
        } else {
            return 0.000f;
        }
    }

    public void Iniciar() {
        horaInicio = Instant.now();
    }

    public void Finalizar() {
        horaFin = Instant.now();
    }

    public Instant getHoraInicio() {
        return horaInicio;
    }

    public Instant getHoraFin() {
        return horaFin;
    }

    public void llego(Empleado empleado){
        try{
            if(ausentes.remove(empleado) && horaInicio.compareTo(Instant.now()) < 0 ){
                Asistencia asistente = new Retraso(empleado);
                retrasoList.add(asistente);

            }
        }catch (Exception e){
            Asistencia asistente = new Asistencia(empleado);
            asistenciaList.add(asistente);

        }
    }

}
