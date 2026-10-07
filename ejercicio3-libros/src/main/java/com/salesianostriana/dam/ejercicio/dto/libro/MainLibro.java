package com.salesianostriana.dam.ejercicio.dto.libro;

public class MainLibro {

    public static void main(String[] args) {
        EjemplosLibro.libros().forEach(l -> System.out.println(LibroDTO.of(l)));

        // Libro null
        System.out.println(LibroDTO.of(null));
    }

}
