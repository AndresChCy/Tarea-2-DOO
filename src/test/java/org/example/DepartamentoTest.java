package org.example;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

public class DepartamentoTest {
    private Departamento departamento;

    @BeforeEach
    void setUp() {
        departamento = new Departamento("Departamento1");
        // Inscribimos empleados al departamento
        departamento.inscribirEmpleado("ID_1", "Apellido1 Apellido2", "Nombre1", "correo1@correo.cl");
        departamento.inscribirEmpleado("ID_2", "Apellido3 Apellido4", "Nombre2", "correo2@correo.cl");
        departamento.inscribirEmpleado("ID_3", "Apellido5 Apellido6", "Nombre3", "correo3@correo.cl");
        departamento.inscribirEmpleado("ID_4", "Apellido7 Apellido8", "Nombre4", "correo4@correo.cl");
    }

    @Test
    @DisplayName("Prueba del método inscribirEmpleado() de Departamento")
    void testInscribirEmpleado() {
        // Verificar que se inscribieron correctamente los empleados
        assertEquals(4, departamento.obtenerCantidadEmpleados());
    }

    @Test
    @DisplayName("Prueba del método toString() de Departamento")
    void testToString() {
        // Verificar la representación en cadena del departamento
        String expected = "Departamento: Departamento1\n" +
                "Empleados:\n" +
                "- Nombre1 Apellido1 Apellido2\n" +
                "- Nombre2 Apellido3 Apellido4\n" +
                "- Nombre3 Apellido5 Apellido6\n" +
                "- Nombre4 Apellido7 Apellido8\n";
        assertEquals(expected, departamento.toString());
    }
}
