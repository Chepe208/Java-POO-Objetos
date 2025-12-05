package com.example;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== ACTIVIDAD PRÁCTICA: DEL MUNDO REAL A OBJETOS JAVA ===\n");
        System.out.println("Repositorio: POO-Objetos-Cotidianos\n");
        
        System.out.println("1. PRUEBAS DE LA CLASE LIBRO");
        System.out.println("=".repeat(50));
        
        // Libro con constructor vacío
        Libro libro1 = new Libro();
        System.out.println("Libro 1 (constructor vacío):");
        System.out.println(libro1);
        System.out.println();
        
        // Libro con constructor con parámetros
        Libro libro2 = new Libro(
            "El Quijote de la Mancha",
            "Miguel de Cervantes",
            "978-84-376-0494-7",
            863,
            29.99,
            true,
            LocalDate.of(1605, 1, 16),
            "Ficción"
        );
        System.out.println("Libro 2 (constructor con parámetros):");
        System.out.println(libro2);
        System.out.println();
        
        // Prueba de setters con validaciones
        System.out.println("Prueba de validaciones en Libro:");
        try {
            libro1.setPrecio(-10);
        } catch (IllegalArgumentException e) {
            System.out.println("✓ Validación precio negativo: " + e.getMessage());
        }
        
        try {
            libro1.setPaginas(10000);
        } catch (IllegalArgumentException e) {
            System.out.println("✓ Validación páginas excesivas: " + e.getMessage());
        }
        
        System.out.println();
        
        // ===== PRUEBAS DE LA CLASE NEVERA =====
        System.out.println("2. PRUEBAS DE LA CLASE NEVERA");
        System.out.println("=".repeat(50));
        
        // Nevera con constructor vacío
        Nevera nevera1 = new Nevera();
        System.out.println("Nevera 1 (constructor vacío):");
        System.out.println(nevera1);
        System.out.println();
        
        // Nevera con constructor con parámetros
        Nevera nevera2 = new Nevera(
            "LG",
            "GN-B522SLC",
            522.5,
            true,
            "A++",
            new BigDecimal("1299.99"),
            LocalDate.of(2023, 5, 15),
            36,
            "Acero Inoxidable"
        );
        System.out.println("Nevera 2 (constructor con parámetros):");
        System.out.println(nevera2);
        System.out.println();
        
        // Prueba de setters con validaciones
        System.out.println("Prueba de validaciones en Nevera:");
        try {
            nevera1.setCapacidadLitros(1500);
        } catch (IllegalArgumentException e) {
            System.out.println("✓ Validación capacidad excesiva: " + e.getMessage());
        }
        
        try {
            nevera1.setClasificacionEnergetica("Z");
        } catch (IllegalArgumentException e) {
            System.out.println("✓ Validación clasificación inválida: " + e.getMessage());
        }
        
        System.out.println();
        
        // ===== PRUEBAS DE LA CLASE CARRO =====
        System.out.println("3. PRUEBAS DE LA CLASE CARRO");
        System.out.println("=".repeat(50));
        
        // Carro con constructor vacío
        Carro carro1 = new Carro();
        System.out.println("Carro 1 (constructor vacío):");
        System.out.println(carro1);
        System.out.println("¿Es nuevo? " + (carro1.esNuevo() ? "Sí" : "No"));
        System.out.println();
        
        // Carro con constructor con parámetros
        Carro carro2 = new Carro(
            "Toyota",
            "Corolla",
            2022,
            "ABC-123",
            18500.5,
            "Híbrido",
            new BigDecimal("24500.00"),
            true,
            LocalDate.of(2022, 3, 10),
            "Blanco"
        );
        System.out.println("Carro 2 (constructor con parámetros):");
        System.out.println(carro2);
        System.out.println("¿Es nuevo? " + (carro2.esNuevo() ? "Sí" : "No"));
        System.out.println();
        
        // Prueba de setters con validaciones
        System.out.println("Prueba de validaciones en Carro:");
        try {
            carro1.setAño(1800);
        } catch (IllegalArgumentException e) {
            System.out.println("✓ Validación año muy antiguo: " + e.getMessage());
        }
        
        try {
            carro1.setPlaca("123");
        } catch (IllegalArgumentException e) {
            System.out.println("✓ Validación placa inválida: " + e.getMessage());
        }
        
        System.out.println();
        
        // ===== DEMOSTRACIÓN DE ENCAPSULAMIENTO =====
        System.out.println("4. DEMOSTRACIÓN DE ENCAPSULAMIENTO");
        System.out.println("=".repeat(50));
        
        System.out.println("Acceso controlado a atributos:");
        System.out.println("- Título del libro2: " + libro2.getTitulo());
        System.out.println("- Marca de la nevera2: " + nevera2.getMarca());
        System.out.println("- Modelo del carro2: " + carro2.getModelo());
        
        System.out.println("\nModificación controlada:");
        System.out.println("Precio original del carro2: $" + carro2.getPrecio());
        carro2.setPrecio(new BigDecimal("23000.00"));
        System.out.println("Precio modificado del carro2: $" + carro2.getPrecio());
        
        System.out.println();
        
        // ===== RESUMEN =====
        System.out.println("5. RESUMEN DE OBJETOS CREADOS");
        System.out.println("=".repeat(50));
        System.out.println("✓ Libros creados: 2");
        System.out.println("✓ Neveras creadas: 2");
        System.out.println("✓ Carros creados: 2");
        System.out.println("✓ Total objetos: 6");
        System.out.println("\n=== ACTIVIDAD COMPLETADA EXITOSAMENTE ===");
    }
}