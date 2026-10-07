package com.salesianostriana.dam.ejercicio.dto.reserva;

import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public record ReservaDTO(
        String codigo,
        String cliente,
        String habitacion,
        Integer numeroNoches,
        Double precioTotal
) {

    public static ReservaDTO of(Reserva reserva) {
        if (reserva == null) {
            return null;
        }

        return new ReservaDTO(
                reserva.getCodigo(),
                nombreCliente(reserva.getCliente()),
                descripcionHabitacion(reserva.getHabitacion()),
                reserva.getNumeroNoches(),
                precioTotal(reserva)
        );
    }

    private static String nombreCliente(Cliente cliente) {
        if (cliente == null) {
            return null;
        }
        return unir(" ", cliente.getNombre(), cliente.getApellidos());
    }

    private static String descripcionHabitacion(Habitacion habitacion) {
        if (habitacion == null) {
            return null;
        }
        // Ejemplo: "204 - Doble"
        return unir(" - ", habitacion.getNumero(), habitacion.getTipo());
    }

    private static Double precioTotal(Reserva reserva) {
        Habitacion habitacion = reserva.getHabitacion();

        if (habitacion == null
                || habitacion.getPrecioNoche() == null
                || reserva.getNumeroNoches() == null) {
            return null;
        }

        return reserva.getNumeroNoches() * habitacion.getPrecioNoche();
    }

    private static String unir(String separador, String... partes) {
        String resultado = Stream.of(partes)
                .filter(Objects::nonNull)
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .collect(Collectors.joining(separador));

        return resultado.isEmpty() ? null : resultado;
    }

}
