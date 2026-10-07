package com.salesianostriana.dam.ejercicio.dto.serie.controller;

import com.salesianostriana.dam.ejercicio.dto.serie.EjemplosSerie;
import com.salesianostriana.dam.ejercicio.dto.serie.SerieDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/serie")
public class SerieController {

    @GetMapping
    public ResponseEntity<List<SerieDTO>> getAll() {
        return ResponseEntity.ok(
                EjemplosSerie.series().stream()
                        .map(SerieDTO::of)
                        .toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SerieDTO> getById(@PathVariable Long id) {
        return EjemplosSerie.series().stream()
                .filter(s -> s.getId().equals(id))
                .findFirst()
                .map(SerieDTO::of)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
