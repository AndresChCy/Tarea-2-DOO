package org.example;

/**
 * Esta clase representa una nota que contiene cierto contenido.
 */
public class Nota{
    private String contenido;
    /**
     * Constructor de la clase Nota.
     *
     * @param contenido El contenido de la nota.
     */
    public Nota(String contenido) {
        this.contenido = contenido;
    }
    /**
     * Lee el contenido de la nota.
     *
     * @return El contenido de la nota.
     */
    public String leer() {
        return contenido + "\n";
    }
}
