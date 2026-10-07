package com.salesianostriana.dam.ejercicio.dto.serie;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public record SerieDTO(
        String titulo,
        Integer temporadas,
        String creador,
        String categoria,
        String imagenPrincipal
) {

    public static SerieDTO of(Serie serie) {
        if (serie == null) {
            return null;
        }

        return new SerieDTO(
                serie.getTitulo(),
                serie.getNumeroTemporadas(),
                nombreCompleto(serie.getCreador()),
                serie.getCategoria() != null ? serie.getCategoria().getNombre() : null,
                primeraImagen(serie.getImagenes())
        );
    }

    private static String nombreCompleto(Creador creador) {
        if (creador == null) {
            return null;
        }

        String completo = Stream.of(creador.getNombre(), creador.getApellidos())
                .filter(Objects::nonNull)
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .collect(Collectors.joining(" "));

        return completo.isEmpty() ? null : completo;
    }

    private static String primeraImagen(List<String> imagenes) {
        if (imagenes == null || imagenes.isEmpty()) {
            return null;
        }
        return imagenes.get(0);
    }

}
