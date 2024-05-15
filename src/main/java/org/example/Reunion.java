package org.example;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Superclase abstracta que representa una reunión, la cual puede ser pogramada y realizada entre un grupo selecto de empleados.
 */
public abstract class Reunion {
    private Date fecha;
    private Instant horaPrevista;
    private Duration duracionPrevista;
    private List<Empleado> invitados;
    private Instant horaInicio;
    private Instant horaFin;
    private List<Asistencia> asistenciaList;
    private List<Asistencia> retrasoList;
    private Empleado organizador;

    /**
     * Método constructor de la clase Reunion que asigna la configuración a las variables anteriormente definidas.
     * @param organizador       El empleado que organiza la reunión.
     * @param fecha             La fecha en la que se realizará la reunión.
     * @param horaPrevista      La hora prevista de inicio de la reunión.
     * @param duracionPrevista  La duración prevista de la reunión.
     * @param invitados         La lista de empleados invitados a la reunión.
     *
     */
    public Reunion(Empleado organizador, Date fecha, Instant horaPrevista, Duration duracionPrevista, List<Empleado> invitados) {
        this.organizador = organizador;
        this.fecha = fecha;
        this.horaPrevista = horaPrevista;
        this.duracionPrevista = duracionPrevista;
        this.invitados = invitados;
        asistenciaList = new ArrayList<Asistencia>();
        retrasoList = new ArrayList<Asistencia>();
    }

    /**
     * Método get para obtener la fecha.
     * @return  Fecha de la reunion.
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * Método get para obtener la hora prevista.
     * @return Hora prevista de la reunion.
     */
    public Instant getHoraPrevista() {
        return horaPrevista;
    }

    /**
     * Método get para obtener la duración prevista.
     * @return Duración prevista de la reunion.
     */
    public Duration getDuracionPrevista() {
        return duracionPrevista;
    }

    /**
     * Método get para obtener las asistencias.
     * @return Lista de asistencia de la reunion.
     */
    public List<Asistencia> obtenerAsistencas() {
        return asistenciaList;
    }

    /**
     * Método get para obtener los retrasos.
     * @return  Lista de retrasos de la reunion.
     */
    public List<Asistencia> obtenerRetrasos() {
        return retrasoList;
    }

    /**
     * Método get para obtener el total de asistencia.
     * @return Número de asistencias de la reunion.
     */
    public int obtenerTotalAsistencia() {
        return retrasoList.size() + asistenciaList.size();
    }

    //NO OLVIDAR--------------------------------------
    // public obtenerAusencias() {}
    // public float obtenerPorcentajeAsistencia() {}

    /**
     * Método que calcula el tiempo en segundos.
     * @return Float en segundos de la duración.
     */
    public float calcularTiempoReal() {
        if ( horaInicio!=null && horaFin!=null ) {
            Duration duracion = Duration.between(horaInicio,horaFin);
            return duracion.toMillis()/1000.0000f; //Devolver tiempo en segundos
        } else {
            return 0.000f;
        }
    }

    /**
     * Método que inicia la reunion.
     * @throws RuntimeException Cuando la reunion se ha iniciado previamente.
     */
    public void Iniciar() {
        if (horaInicio!=null) {
            throw new RuntimeException("No se puede iniciar la Reunion dos veces.");
        }
        horaInicio = Instant.now();
    }

    /**
     * Método que finaliza la reunion.
     * @throws RuntimeException Cuando la reunion se ha finalizado previamente.
     */
    public void Finalizar() {
        if (horaFin!=null) {
            throw new RuntimeException("No se puede finalizar la Reunion dos veces.");
        }
        horaFin = Instant.now();
    }

    /**
     * Método get para obtener la hora de inicio.
     * @return Hora de inicia de la reunion.
     */
    public Instant getHoraInicio() {
        return horaInicio;
    }

    /**
     * Método get para obtener la hora de finalizacion.
     * @return Hora de finalización de la reunion.
     */
    public Instant getHoraFin() {
        return horaFin;
    }

    /**
     * Método que analiza si el empleado ha llegado a tiempo.
     * @param empleado  Empleado que se unió a la reunion.
     */
    public void llego(Empleado empleado){
        try{
            if(horaInicio.compareTo(Instant.now()) < 0 ){
                Asistencia asistente = new Retraso(empleado);
                retrasoList.add(asistente);
            }
        }catch (Exception e){
            Asistencia asistente = new Asistencia(empleado);
            asistenciaList.add(asistente);
        }
    }
}