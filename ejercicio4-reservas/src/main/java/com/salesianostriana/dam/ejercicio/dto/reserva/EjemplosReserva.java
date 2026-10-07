package com.salesianostriana.dam.ejercicio.dto.reserva;

import java.util.List;

/** Datos de prueba compartidos por MainReserva y ReservaController. */
public final class EjemplosReserva {

    private EjemplosReserva() {
    }

    public static List<Reserva> reservas() {

        Cliente cliente = Cliente.builder()
                .id(1L).nombre("Lucía").apellidos("Fernández Ruiz")
                .email("lucia@mail.com").telefono("600123456").build();

        Habitacion doble = Habitacion.builder()
                .id(1L).numero("204").tipo("Doble").precioNoche(85.50).planta(2).build();

        Habitacion sinPrecio = Habitacion.builder()
                .id(2L).numero("101").tipo("Individual").planta(1).build();

        return List.of(
                // Reserva completa
                Reserva.builder().id(1L).codigo("RES-001").numeroNoches(3)
                        .cliente(cliente).habitacion(doble).build(),
                // Sin cliente
                Reserva.builder().id(2L).codigo("RES-002").numeroNoches(2)
                        .habitacion(doble).build(),
                // Sin habitación
                Reserva.builder().id(3L).codigo("RES-003").numeroNoches(4)
                        .cliente(cliente).build(),
                // Sin número de noches
                Reserva.builder().id(4L).codigo("RES-004")
                        .cliente(cliente).habitacion(doble).build(),
                // Habitación sin precio por noche
                Reserva.builder().id(5L).codigo("RES-005").numeroNoches(2)
                        .cliente(cliente).habitacion(sinPrecio).build()
        );
    }

}
