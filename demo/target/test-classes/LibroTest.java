package com.example;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class LibroTest {

    @Test
    void testConstructorVacio() {
        Libro libro = new Libro();
        assertEquals("Sin título", libro.getTitulo());
        assertEquals("Autor desconocido", libro.getAutor());
        assertEquals(200, libro.getPaginas());
        assertTrue(libro.isDisponible());
    }

    @Test
    void testConstructorCompleto() {
        Libro libro = new Libro(
            "1984", "George Orwell", "978-0-452-28423-4",
            328, 18.75, true, LocalDate.of(1949, 6, 8), "Ficción"
        );
        
        assertEquals("1984", libro.getTitulo());
        assertEquals("George Orwell", libro.getAutor());
        assertEquals("978-0-452-28423-4", libro.getIsbn());
        assertEquals(328, libro.getPaginas());
        assertEquals(18.75, libro.getPrecio(), 0.001);
        assertEquals("Ficción", libro.getGenero());
    }

    @Test
    void testSettersValidos() {
        Libro libro = new Libro();
        libro.setTitulo("Rayuela");
        libro.setAutor("Julio Cortázar");
        libro.setPaginas(500);
        libro.setPrecio(22.99);
        libro.setGenero("Ficción");
        
        assertEquals("Rayuela", libro.getTitulo());
        assertEquals("Julio Cortázar", libro.getAutor());
        assertEquals(500, libro.getPaginas());
        assertEquals(22.99, libro.getPrecio(), 0.001);
        assertEquals("Ficción", libro.getGenero());
    }

    @Test
    void testValidaciones() {
        Libro libro = new Libro();
        
        // Título vacío
        assertThrows(IllegalArgumentException.class, () -> libro.setTitulo(""));
        
        // ISBN inválido
        assertThrows(IllegalArgumentException.class, () -> libro.setIsbn("123"));
        
        // Precio negativo
        assertThrows(IllegalArgumentException.class, () -> libro.setPrecio(-5));
        
        // Género inválido
        assertThrows(IllegalArgumentException.class, () -> libro.setGenero("Acción"));
        
        // Páginas = 0
        assertThrows(IllegalArgumentException.class, () -> libro.setPaginas(0));
    }

    @Test
    void testGeneroNormalizacion() {
        Libro libro = new Libro();
        libro.setGenero("FICCIÓN");
        assertEquals("Ficción", libro.getGenero());
        
        libro.setGenero("ciencia ficción");
        assertEquals("Ciencia Ficción", libro.getGenero());
    }

    @Test
    void testToString() {
        Libro libro = new Libro("El túnel", "Sabato", "978-0-306-40615-7",
            150, 14.99, false, LocalDate.of(1948, 1, 1), "Ficción");
        
        String str = libro.toString();
        assertTrue(str.contains("El túnel"));
        assertTrue(str.contains("Sabato"));
        assertTrue(str.contains("14.99"));
    }
}