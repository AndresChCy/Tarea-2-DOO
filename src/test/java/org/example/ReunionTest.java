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
    private Reunion Reunion;
    private Empleado Empleado;
    private Empleado Empleado2;
    @BeforeEach
    void setUp() {
        Empleado = new Empleado("ID_1", "Apellido1 Apellido2", "Nombre1", "correo1@correo.cl", new Departamento("NombreDepa1"));
        Empleado2 = new Empleado("ID_1", "Apellido1 Apellido2", "Nombre1", "correo1@correo.cl", new Departamento("NombreDepa2"));
        List<Empleado> invitados = new ArrayList<Empleado>();
        invitados.add(Empleado);
        Reunion = new ReunionVirtual(Empleado2, new Date(), Instant.now(), Duration.ZERO, invitados, "enlace");
    }

    @Test
    @DisplayName("Test de excepcion al iniciar más de una vez.")
    void iniciarException() {
        assertDoesNotThrow(() -> Reunion.Iniciar());
        RuntimeException exception = assertThrows(RuntimeException.class, () -> Reunion.Iniciar());
        assertEquals("No se puede iniciar la Reunion dos veces.", exception.getMessage());
    }

    @Test
    @DisplayName("Test de excepcion al finalizar más de una vez.")
    void finalizarException() {
        assertDoesNotThrow(() -> Reunion.Iniciar());
        assertDoesNotThrow(() -> Reunion.Finalizar());
        RuntimeException exception = assertThrows(RuntimeException.class, () -> Reunion.Finalizar());
        assertEquals("No se puede finalizar la Reunion dos veces.", exception.getMessage());
    }

    @Test
    @DisplayName("Test de excepcion al finalizar sin haber iniciado.")
    void finalizarNoIniciar() {
        RuntimeException exception = assertThrows(RuntimeException.class, () -> Reunion.Finalizar());
        assertEquals("No se ha iniciado la Reunion.", exception.getMessage());
    }

    @Test
    @DisplayName("Test de calcular tiempo real sin iniciar.")
    void calcularTiempoNoIniciar() {
        assertEquals(0, Reunion.calcularTiempoReal());
    }

    @Test
    @DisplayName("Test de calcular tiempo real iniciando y finalizando reunion.")
    void calcularTiempoIniciarFinalizar() throws InterruptedException {
        Reunion.Iniciar();
        Thread.sleep(10000);
        Reunion.Finalizar();
        assertTrue(Reunion.calcularTiempoReal()>=10.0f || 10.02f>=Reunion.calcularTiempoReal());
    }

    @Test
    @DisplayName("Test de calcular tiempo real sin finalizar.")
    void calcularTiempoIniciarNoFinalizar() throws InterruptedException {
        Reunion.Iniciar();
        Thread.sleep(5000);
        assertTrue(Reunion.calcularTiempoReal()>=5.0f || 5.02f>=Reunion.calcularTiempoReal());
    }
}
