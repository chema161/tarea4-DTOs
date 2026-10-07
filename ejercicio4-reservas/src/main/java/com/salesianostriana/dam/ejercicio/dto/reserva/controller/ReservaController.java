package com.salesianostriana.dam.ejercicio.dto.reserva.controller;

import com.salesianostriana.dam.ejercicio.dto.reserva.EjemplosReserva;
import com.salesianostriana.dam.ejercicio.dto.reserva.ReservaDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/reserva")
public class ReservaController {

    @GetMapping
    public ResponseEntity<List<ReservaDTO>> getAll() {
        return ResponseEntity.ok(
                EjemplosReserva.reservas().stream()
                        .map(ReservaDTO::of)
                        .toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservaDTO> getById(@PathVariable Long id) {
        return EjemplosReserva.reservas().stream()
                .filter(r -> r.getId().equals(id))
                .findFirst()
                .map(ReservaDTO::of)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
