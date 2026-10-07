package com.salesianostriana.dam.ejercicio.dto.serie;

import java.util.ArrayList;
import java.util.List;

/** Datos de prueba compartidos por MainSerie y SerieController. */
public final class EjemplosSerie {

    private EjemplosSerie() {
    }

    public static List<Serie> series() {

        Creador gilligan = Creador.builder()
                .id(1L).nombre("Vince").apellidos("Gilligan").pais("Estados Unidos").build();

        Categoria drama = Categoria.builder()
                .id(1L).nombre("Drama").descripcion("Series de temática dramática").build();

        return List.of(
                // Serie con todos sus datos
                Serie.builder().id(1L).titulo("Breaking Bad").sinopsis("Un profesor de química...")
                        .numeroTemporadas(5).creador(gilligan).categoria(drama)
                        .imagenes(List.of("https://img.example.com/bb1.jpg",
                                          "https://img.example.com/bb2.jpg"))
                        .build(),
                // Sin categoría
                Serie.builder().id(2L).titulo("Better Call Saul").sinopsis("Un abogado...")
                        .numeroTemporadas(6).creador(gilligan)
                        .imagenes(List.of("https://img.example.com/bcs1.jpg"))
                        .build(),
                // Sin imágenes (lista null)
                Serie.builder().id(3L).titulo("Serie sin imágenes").sinopsis("Sinopsis")
                        .numeroTemporadas(1).creador(gilligan).categoria(drama)
                        .build(),
                // Lista de imágenes vacía y sin creador
                Serie.builder().id(4L).titulo("Serie con lista vacía").sinopsis("Sinopsis")
                        .numeroTemporadas(2).categoria(drama)
                        .imagenes(new ArrayList<>())
                        .build()
        );
    }

}
