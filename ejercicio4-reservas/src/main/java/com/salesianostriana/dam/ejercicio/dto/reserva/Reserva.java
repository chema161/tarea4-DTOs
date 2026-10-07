package com.salesianostriana.dam.ejercicio.dto.reserva;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reserva {

    private Long id;
    private String codigo;
    private Integer numeroNoches;
    private Cliente cliente;
    private Habitacion habitacion;

}
