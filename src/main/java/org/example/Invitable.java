package org.example;
import java.util.List;

/**
 * Esta interfaz representa entidades que pueden ser invitadas a algo.
 */
public interface Invitable {
    /**
     * Invita a la entidad.
     * @return Una lista que contiene a la entidad invitada.
     */
    List<Invitable> invitar();
}
