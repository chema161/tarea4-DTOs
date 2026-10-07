package com.salesianostriana.dam.ejercicio.dto.libro;

import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public record LibroDTO(
        String titulo,
        String isbn,
        String autor,
        Integer anioPublicacion
) {

    public static LibroDTO of(Libro libro) {
        if (libro == null) {
            return null;
        }

        return new LibroDTO(
                libro.getTitulo(),
                libro.getIsbn(),
                nombreCompleto(libro.getAutor()),
                libro.getAnioPublicacion()
        );
    }

    private static String nombreCompleto(Autor autor) {
        if (autor == null) {
            return null;
        }

        String completo = Stream.of(autor.getNombre(), autor.getApellido1(), autor.getApellido2())
                .filter(Objects::nonNull)
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .collect(Collectors.joining(" "));

        return completo.isEmpty() ? null : completo;
    }

}
