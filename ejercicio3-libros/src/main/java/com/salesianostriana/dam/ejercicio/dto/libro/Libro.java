package com.salesianostriana.dam.ejercicio.dto.libro;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Libro {

    private Long id;
    private String titulo;
    private String isbn;
    private Integer anioPublicacion;
    private Integer numeroPaginas;
    private Autor autor;

}
