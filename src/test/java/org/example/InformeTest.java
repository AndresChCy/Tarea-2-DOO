package org.example;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InformeTest {
    private Empleado Empleado;
    private Empleado Empleado2;
    private Reunion Reunion;
    @BeforeEach
    void setUp() {
        Empleado = new Empleado("ID_1", "Apellido1 Apellido2", "Nombre1", "correo1@correo.cl", new Departamento("NombreDepa1"));
        Empleado2 = new Empleado("ID_2", "Apellido3 Apellido4", "Nombre2", "correo2@correo.cl", new Departamento("NombreDepa2"));
        List<Empleado> invitados = new ArrayList<Empleado>();
        invitados.add(Empleado);
        invitados.add(Empleado2);
        Reunion = new ReunionVirtual(Empleado2, new Date(), Instant.now(), Duration.ZERO, invitados, "enlace");
        Reunion.nuevaNota("Primera nota, primera reunion oficial del mandanato.");
    }

    @Test
    @DisplayName("Test de crear informe.")
    void crearInforme() throws InterruptedException {
        Reunion.llego(Empleado2);
        Reunion.Iniciar();
        Thread.sleep(1000);
        Reunion.nuevaNota("Segunda nota, el empleado no se ha presentado todavía.");
        Reunion.llego(Empleado);
        Reunion.nuevaNota("Tercera nota, falsa alarma, ya llegó.");
        Thread.sleep(10000);
        Reunion.Finalizar();
        Informe informe = new Informe(Reunion, Reunion.obtenerAsistencas(), Reunion.obtenerRetrasos(), Reunion.getListaNotas());
    }
}