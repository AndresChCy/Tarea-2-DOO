package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Esta interfaz representa entidades que pueden ser invitadas a algo.
 */
public interface Invitable {
    /**
     * Método para invitar a la entidad.
     */
    List<Invitable> invitar();

}
