package org.example;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.List;

/**
 * Clase que simula un informe.
 */
class Informe {
    /** Iniciación de variables necesarias para la escritura */
    FileWriter informe = null;
    PrintWriter escritor = null;

    /**
     * Método constructor que crea un informe detallado de una reunion.
     * @param reunion       Reunion de la que se creara el informe.
     * @param Asistentes    Lista de personas que asistieron a la reunion.
     * @param Retrasos      Lista de personas que se atrasaron al llegar.
     * @param Notas         Lista de notas antes y durante de la reunion.
     */
    public Informe(Reunion reunion, List<Asistencia> Asistentes, List<Asistencia> Retrasos, List<Nota> Notas,String nombre){
        try {
            this.informe = new FileWriter(nombre+".txt");
            this.escritor = new PrintWriter(informe);

            escritor.println("----Datos de Reunion----");
            escritor.println(reunion.toString());
            escritor.println("\n");

            escritor.println("----Datos Asistentes----");
            for (int i=0 ; i<Asistentes.size() ; i++ ) {
                escritor.println(Asistentes.get(i).toString());
            }
            escritor.println("\n");

            escritor.println("----Datos Retrasos----");
            for (int i=0 ; i<Retrasos.size() ; i++ ) {
                escritor.println(Retrasos.get(i).toString());
            }
            escritor.println("\n");

            escritor.println("----Notas----");
            for (int i=0 ; i<Notas.size() ; i++ ) {
                escritor.println((i+1) + ".- " + Notas.get(i).leer());
            }

        } catch (Exception e) {
            System.out.println("Error:"+e.getMessage());
        } finally {
            escritor.close();
        }
    }
}
