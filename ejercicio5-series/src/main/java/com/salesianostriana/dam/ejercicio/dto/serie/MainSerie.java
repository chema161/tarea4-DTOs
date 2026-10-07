package com.salesianostriana.dam.ejercicio.dto.serie;

public class MainSerie {

    public static void main(String[] args) {
        EjemplosSerie.series().forEach(s -> System.out.println(SerieDTO.of(s)));

        // Serie null
        System.out.println(SerieDTO.of(null));
    }

}
