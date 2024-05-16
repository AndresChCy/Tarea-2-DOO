package org.example;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Superclase abstracta que representa una reunión, la cual puede ser pogramada y realizada entre un grupo selecto de empleados.
 */
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
    private Empleado organizador;
    private List<Nota> listaNotas;
    private tipoReunion tema;

    /**
     * Método constructor de la clase Reunion que asigna la configuración a las variables anteriormente definidas.
     * @param organizador       El empleado que organiza la reunión.
     * @param fecha             La fecha en la que se realizará la reunión.
     * @param horaPrevista      La hora prevista de inicio de la reunión.
     * @param duracionPrevista  La duración prevista de la reunión.
     * @param invitados         La lista de empleados invitados a la reunión.
     *
     */
    public Reunion(Empleado organizador, Date fecha, Instant horaPrevista, Duration duracionPrevista, List<Invitable> invitados,tipoReunion tema) {
        this.organizador = organizador;
        this.fecha = fecha;
        this.horaPrevista = horaPrevista;
        this.duracionPrevista = duracionPrevista;
        this.tema = tema;
        listaNotas = new ArrayList<Nota>();
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


    public List<Invitable> obtenerAusencias() {
        return ausentes;
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

    public float obtenerPorcentajeAsistencia() {
        float asistencias = retrasoList.size() + asistenciaList.size();
        float todos = retrasoList.size() + asistenciaList.size() + ausentes.size();
        float porcentajeAsistencia= asistencias/todos;
        return porcentajeAsistencia*100;
    }

    /**
     * Método que calcula el tiempo en segundos.
     * @return Float en segundos de la duración.
     */
    public float calcularTiempoReal() {
        if ( horaInicio!=null && horaFin!=null ) {
            Duration duracion = Duration.between(horaInicio,horaFin);
            return duracion.toMillis()/1000.0f;
        } else if (horaInicio!=null) {
            Duration duracion = Duration.between(horaInicio,Instant.now());
            return duracion.toMillis()/1000.0f;
        } else {
            return 0.0f;
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

        if (horaInicio==null) {
            throw new RuntimeException("No se ha iniciado la Reunion.");
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
            if(ausentes.remove(empleado) && horaInicio.compareTo(Instant.now()) < 0 ){
                Asistencia asistente = new Retraso(empleado);
                retrasoList.add(asistente);

            }
        }catch (Exception e){
            Asistencia asistente = new Asistencia(empleado);
            asistenciaList.add(asistente);

        }
    }

    /**
     * Método toString que devuelve la información de la clase.
     * @return String con la información de la reunion.
     */
    @Override
    public String toString() {
        return "Reunion {" + "\n" + "Organizador = " + organizador + "\n" +
                "Fecha = " + fecha + "\n" +
                "Hora prevista = " + horaPrevista + "\n" +
                "Duración total = " + this.calcularTiempoReal() + " segundos\n" +
                "Tipo de Reunion = " + this.tema + "\n " +
                "Hora de inicio = " + horaInicio + "\n" +
                "Hora de fin = " + horaFin;
    }
    /**
     * Método para crear una nueva nota y almacenarla en la lista de notas.
     *
     * @param contenido El contenido de la nueva nota.
     */
    public void nuevaNota(String contenido) {
        // Crear una nueva instancia de Nota con el contenido proporcionado
        Nota nuevaNota = new Nota(contenido);
        // Agregar esta nota a la lista de notas
        listaNotas.add(nuevaNota);
    }

    /**
     * Metodo para generar un informe de la reunion como archivo txt
     */
    public void hacerInforme(String nombre){
        Informe informe = new Informe(this,this.asistenciaList,this.retrasoList,this.listaNotas,nombre);
    }
}