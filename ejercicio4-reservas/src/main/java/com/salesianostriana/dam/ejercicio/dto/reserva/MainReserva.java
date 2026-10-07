package com.salesianostriana.dam.ejercicio.dto.reserva;

public class MainReserva {

    public static void main(String[] args) {
        EjemplosReserva.reservas().forEach(r -> System.out.println(ReservaDTO.of(r)));

        System.out.println(ReservaDTO.of(null));
    }

}
