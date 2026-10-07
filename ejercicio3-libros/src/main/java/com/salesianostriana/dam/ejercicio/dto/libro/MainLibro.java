package com.salesianostriana.dam.ejercicio.dto.libro;

public class MainLibro {

    public static void main(String[] args) {
        EjemplosLibro.libros().forEach(l -> System.out.println(LibroDTO.of(l)));

        System.out.println(LibroDTO.of(null));
    }

}
