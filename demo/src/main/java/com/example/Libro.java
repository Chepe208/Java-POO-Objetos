package com.example;

import java.time.LocalDate;
import java.time.Year;

public class Libro {
    // Atributos privados (7 atributos)
    private String titulo;
    private String autor;
    private String isbn;
    private int paginas;
    private double precio;
    private boolean disponible;
    private LocalDate fechaPublicacion;
    private String genero; // Nuevo atributo adicional
    
    // Constructor vacío/por defecto
    public Libro() {
        this.titulo = "Sin título";
        this.autor = "Autor desconocido";
        this.isbn = "978-0-00-000000-0";
        this.paginas = 200;
        this.precio = 15.99;
        this.disponible = true;
        this.fechaPublicacion = LocalDate.now().minusYears(2);
        this.genero = "Ficción";
    }
    
    // Constructor con parámetros usando setters
    public Libro(String titulo, String autor, String isbn, int paginas, double precio, boolean disponible, LocalDate fechaPublicacion, String genero) {
        setTitulo(titulo);
        setAutor(autor);
        setIsbn(isbn);
        setPaginas(paginas);
        setPrecio(precio);
        setDisponible(disponible);
        setFechaPublicacion(fechaPublicacion);
        setGenero(genero);
    }
    
    // Getters y Setters con validaciones
    public String getTitulo() {
        return titulo;
    }
    
    public void setTitulo(String titulo) {
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("El título no puede estar vacío");
        }
        if (titulo.length() > 200) {
            throw new IllegalArgumentException("El título no puede exceder 200 caracteres");
        }
        this.titulo = titulo.trim();
    }
    
    public String getAutor() {
        return autor;
    }
    
    public void setAutor(String autor) {
        if (autor == null || autor.trim().isEmpty()) {
            throw new IllegalArgumentException("El autor no puede estar vacío");
        }
        if (autor.length() > 100) {
            throw new IllegalArgumentException("El nombre del autor no puede exceder 100 caracteres");
        }
        this.autor = autor.trim();
    }
    
    public String getIsbn() {
        return isbn;
    }
    
    public void setIsbn(String isbn) {
        if (isbn == null || isbn.trim().isEmpty()) {
            throw new IllegalArgumentException("El ISBN no puede estar vacío");
        }
        // Validación formato ISBN-13
        String isbnLimpio = isbn.replaceAll("-", "");
        if (!isbnLimpio.matches("\\d{13}")) {
            throw new IllegalArgumentException("ISBN inválido. Debe tener 13 dígitos");
        }
        this.isbn = isbn.trim();
    }
    
    public int getPaginas() {
        return paginas;
    }
    
    public void setPaginas(int paginas) {
        if (paginas <= 0) {
            throw new IllegalArgumentException("El número de páginas debe ser mayor a 0");
        }
        if (paginas > 5000) {
            throw new IllegalArgumentException("El número de páginas no puede exceder 5000");
        }
        this.paginas = paginas;
    }
    
    public double getPrecio() {
        return precio;
    }
    
    public void setPrecio(double precio) {
        if (precio <= 0) {
            throw new IllegalArgumentException("El precio debe ser mayor a 0");
        }
        if (precio > 10000) {
            throw new IllegalArgumentException("El precio no puede exceder $10,000");
        }
        this.precio = Math.round(precio * 100.0) / 100.0; // 2 decimales
    }
    
    public boolean isDisponible() {
        return disponible;
    }
    
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
    
    public LocalDate getFechaPublicacion() {
        return fechaPublicacion;
    }
    
    public void setFechaPublicacion(LocalDate fechaPublicacion) {
        if (fechaPublicacion == null) {
            throw new IllegalArgumentException("La fecha de publicación no puede ser nula");
        }
        if (fechaPublicacion.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("La fecha de publicación no puede ser futura");
        }
        if (fechaPublicacion.getYear() < 1455) {
            throw new IllegalArgumentException("La fecha no puede ser anterior a 1455");
        }
        this.fechaPublicacion = fechaPublicacion;
    }
    
    public String getGenero() {
        return genero;
    }
    
    public void setGenero(String genero) {
        if (genero == null || genero.trim().isEmpty()) {
            throw new IllegalArgumentException("El género no puede estar vacío");
        }
        String[] generosValidos = {"Ficción", "No Ficción", "Ciencia Ficción", "Fantasía", "Misterio", "Romance", "Biografía", "Historia", "Infantil"};
        boolean valido = false;
        for (String g : generosValidos) {
            if (g.equalsIgnoreCase(genero.trim())) {
                this.genero = g;
                valido = true;
                break;
            }
        }
        if (!valido) {
            throw new IllegalArgumentException("Género no válido. Use: " + String.join(", ", generosValidos));
        }
    }
    
    @Override
    public String toString() {
        return String.format("Libro [Título: %s, Autor: %s, ISBN: %s, Páginas: %d, " + "Precio: $%.2f, Disponible: %s, Fecha Publicación: %s, Género: %s]", titulo, autor, isbn, paginas, precio, disponible ? "Sí" : "No", fechaPublicacion, genero);
    }
}
