package com.salesianostriana.dam.ejercicio.dto.libro.controller;

import com.salesianostriana.dam.ejercicio.dto.libro.EjemplosLibro;
import com.salesianostriana.dam.ejercicio.dto.libro.LibroDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/libro")
public class LibroController {

    @GetMapping
    public ResponseEntity<List<LibroDTO>> getAll() {
        return ResponseEntity.ok(
                EjemplosLibro.libros().stream()
                        .map(LibroDTO::of)
                        .toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LibroDTO> getById(@PathVariable Long id) {
        return EjemplosLibro.libros().stream()
                .filter(l -> l.getId().equals(id))
                .findFirst()
                .map(LibroDTO::of)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
