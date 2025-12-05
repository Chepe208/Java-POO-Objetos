package com.example;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class CarroTest {

    @Test
    void testCreacionBasica() {
        // Test del constructor por defecto
        Carro carroDefault = new Carro();
        assertNotNull(carroDefault);
        assertEquals("Genérica", carroDefault.getMarca());
        assertTrue(carroDefault.isAutomatico());
    }

    @Test
    void testCreacionConParametros() {
        // Test del constructor con parámetros
        Carro carro = new Carro(
            "Toyota", 
            "Corolla", 
            2022, 
            "ABC-123", 
            5000.0, 
            "Gasolina", 
            new BigDecimal("25000.00"), 
            true, 
            LocalDate.of(2022, 1, 15), 
            "Rojo"
        );

        assertEquals("Toyota", carro.getMarca());
        assertEquals("Corolla", carro.getModelo());
        assertEquals(2022, carro.getAño());
        assertEquals("ABC-123", carro.getPlaca());
        assertEquals(5000.0, carro.getKilometraje(), 0.1);
        assertEquals("Gasolina", carro.getTipoCombustible());
        assertEquals(new BigDecimal("25000.00"), carro.getPrecio());
        assertTrue(carro.isAutomatico());
        assertEquals(LocalDate.of(2022, 1, 15), carro.getFechaMatriculacion());
        assertEquals("Rojo", carro.getColor());
    }

    @Test
    void testSettersYGetters() {
        // Test básico de setters y getters
        Carro carro = new Carro();
        
        carro.setMarca("Honda");
        carro.setModelo("Civic");
        carro.setAño(2023);
        carro.setPlaca("XYZ-789");
        
        assertEquals("Honda", carro.getMarca());
        assertEquals("Civic", carro.getModelo());
        assertEquals(2023, carro.getAño());
        assertEquals("XYZ-789", carro.getPlaca());
    }

    @Test
    void testMetodosAdicionales() {
        // Test de los métodos adicionales
        Carro carroNuevo = new Carro();
        carroNuevo.setKilometraje(500.0);
        carroNuevo.setAño(2024);
        
        assertTrue(carroNuevo.esNuevo());
        assertEquals(LocalDate.now().getYear() - 2024, carroNuevo.getAntiguedad());
    }

    @Test
    void testValidacionBasica() {
        // Test de una validación
        Carro carro = new Carro();
        
        // Debe lanzar excepción con marca vacía
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            carro.setMarca("");
        });
        
        assertTrue(exception.getMessage().contains("marca"));
    }

    @Test
    void testToString() {
        // Test básico del método toString
        Carro carro = new Carro();
        String resultado = carro.toString();
        
        assertNotNull(resultado);
        assertTrue(resultado.contains("Carro"));
        assertTrue(resultado.contains("Marca"));
    }
}