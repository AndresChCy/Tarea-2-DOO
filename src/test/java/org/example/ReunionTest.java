package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReunionTest {
    private Reunion reunion;
    private Empleado empleado;
    @BeforeEach
    void setUp() {
        empleado = new Empleado();
        List<Empleado> ar = new ArrayList<Empleado>();
        ar.add(empleado);
        reunion = new ReunionVirtual(new Date(), Instant.now(), Duration.ZERO, ar  );
    }

    @Test
    @DisplayName("Test llego a tiempo")
    void TestLlegoBien() {
        reunion.llego(empleado);
        List<Asistencia> asistentes= reunion.obtenerAsistencas();
        assertEquals(asistentes.size(),1);
        }
    @Test
    @DisplayName("Test llego tarde")
    void TestLlegoTarde(){
        reunion.Iniciar();
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        reunion.llego(empleado);
        List<Asistencia> atrasados = reunion.obtenerRetrasos();
        assertEquals(atrasados.size(),1);
    }
}
