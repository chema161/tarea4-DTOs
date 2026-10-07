package com.salesianostriana.dam.ejercicio.dto.serie;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Serie {

    private Long id;
    private String titulo;
    private String sinopsis;
    private Integer numeroTemporadas;
    private Creador creador;
    private Categoria categoria;
    private List<String> imagenes;

}
