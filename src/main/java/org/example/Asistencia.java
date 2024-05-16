package org.example;

public class Asistencia {
    private Empleado empleado ;
    public Asistencia(Empleado empleado){
        this.empleado = empleado ;
    }

    /**
     * Metodo para obtener los datos del empleado asistente
     * @return un String con los datos del empleado
     */
    @Override
    public String toString(){
        return empleado.toString();
    }
}
