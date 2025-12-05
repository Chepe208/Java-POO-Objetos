package com.example;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class NeveraTest {

    @Test
    void testConstructorPorDefecto() {
        Nevera nevera = new Nevera();
        
        assertNotNull(nevera);
        assertEquals("Genérica", nevera.getMarca());
        assertEquals("Estándar", nevera.getModelo());
        assertEquals(350.0, nevera.getCapacidadLitros(), 0.01);
        assertTrue(nevera.isTieneCongelador());
        assertEquals("A+", nevera.getClasificacionEnergetica());
        assertEquals(new BigDecimal("599.99"), nevera.getPrecio());
        assertEquals("Blanco", nevera.getColor());
        assertEquals(24, nevera.getGarantiaMeses());
    }

    @Test
    void testConstructorConParametros() {
        LocalDate fecha = LocalDate.of(2023, 5, 10);
        Nevera nevera = new Nevera(
            "Samsung", 
            "RT38", 
            380.5, 
            true,
            "A++", 
            new BigDecimal("899.99"), 
            fecha,
            36, 
            "Acero Inoxidable"
        );

        assertEquals("Samsung", nevera.getMarca());
        assertEquals("RT38", nevera.getModelo());
        assertEquals(380.5, nevera.getCapacidadLitros(), 0.01);
        assertTrue(nevera.isTieneCongelador());
        assertEquals("A++", nevera.getClasificacionEnergetica());
        assertEquals(new BigDecimal("899.99"), nevera.getPrecio());
        assertEquals(fecha, nevera.getFechaFabricacion());
        assertEquals(36, nevera.getGarantiaMeses());
        assertEquals("Acero Inoxidable", nevera.getColor());
    }

    @Test
    void testSettersValidos() {
        Nevera nevera = new Nevera();
        
        nevera.setMarca("LG");
        nevera.setModelo("GN-B422");
        nevera.setCapacidadLitros(420.0);
        nevera.setClasificacionEnergetica("A+++");
        nevera.setColor("Plateado");
        nevera.setGarantiaMeses(48);
        
        assertEquals("LG", nevera.getMarca());
        assertEquals("GN-B422", nevera.getModelo());
        assertEquals(420.0, nevera.getCapacidadLitros(), 0.01);
        assertEquals("A+++", nevera.getClasificacionEnergetica());
        assertEquals("Plateado", nevera.getColor());
        assertEquals(48, nevera.getGarantiaMeses());
    }

    @Test
    void testValidacionesBasicas() {
        Nevera nevera = new Nevera();
        
        // Test de validación de marca vacía
        Exception exMarca = assertThrows(IllegalArgumentException.class, () -> {
            nevera.setMarca("");
        });
        assertTrue(exMarca.getMessage().contains("marca"));
        
        // Test de validación de capacidad negativa
        Exception exCapacidad = assertThrows(IllegalArgumentException.class, () -> {
            nevera.setCapacidadLitros(-5.0);
        });
        assertTrue(exCapacidad.getMessage().contains("capacidad"));
        
        // Test de validación de garantía
        Exception exGarantia = assertThrows(IllegalArgumentException.class, () -> {
            nevera.setGarantiaMeses(10);
        });
        assertTrue(exGarantia.getMessage().contains("garantía"));
    }

    @Test
    void testMetodosEspeciales() {
        Nevera nevera = new Nevera();
        
        // Test de setTieneCongelador
        nevera.setTieneCongelador(false);
        assertFalse(nevera.isTieneCongelador());
        
        nevera.setTieneCongelador(true);
        assertTrue(nevera.isTieneCongelador());
    }

    @Test
    void testToString() {
        Nevera nevera = new Nevera();
        String resultado = nevera.toString();
        
        assertNotNull(resultado);
        assertTrue(resultado.contains("Nevera"));
        assertTrue(resultado.contains("Marca: Genérica"));
        assertTrue(resultado.contains("Capacidad: 350.0 L"));
    }

    @Test
    void testRedondeoCapacidad() {
        Nevera nevera = new Nevera();
        nevera.setCapacidadLitros(123.456);
        
        // Debe redondear a 1 decimal
        assertEquals(123.5, nevera.getCapacidadLitros(), 0.01);
    }
}