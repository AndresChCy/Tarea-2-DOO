package org.example;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

class Informe {
    FileWriter informe = null;
    PrintWriter escritor = null;

    public Informe(){}
    public void generarInforme() {
        try {
            informe = new FileWriter("C:informe.txt"); //Modificar para cambiar la dirección de creacion del archivo.
            escritor = new PrintWriter(informe);

            escritor.println("FechaYHora");
            escritor.println("HoraInicio,HoraFinal,Duracion");
            escritor.println("TipoReunion");
            escritor.println("Enlace/Sala");
            escritor.println("ListaParticipantes");
            escritor.println("NotasDeLaReunion");

        } catch (Exception e) {
            System.out.println("Error:"+e.getMessage());
        } finally {
            escritor.close();
        }
    }
}
