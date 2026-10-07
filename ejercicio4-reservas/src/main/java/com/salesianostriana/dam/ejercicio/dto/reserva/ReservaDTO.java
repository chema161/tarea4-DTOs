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

    /**
     * Transforma una Reserva en un ReservaDTO de forma segura.
     *
     * Valores que se devuelven cuando falta información:
     * - Reserva null                          -> devuelve null.
     * - Sin cliente (o sin nombre y apellidos) -> cliente = null.
     * - Sin habitación (o sin número y tipo)   -> habitacion = null.
     * - numeroNoches sin informar              -> numeroNoches = null y precioTotal = null.
     * - precioNoche sin informar, o sin
     *   habitación                             -> precioTotal = null.
     *
     * Se usa null en precioTotal (y no 0.0) porque un 0 parecería un precio real,
     * cuando en realidad no se ha podido calcular.
     */
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

    /** Une las partes no nulas ni vacías con el separador; devuelve null si no queda ninguna. */
    private static String unir(String separador, String... partes) {
        String resultado = Stream.of(partes)
                .filter(Objects::nonNull)
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .collect(Collectors.joining(separador));

        return resultado.isEmpty() ? null : resultado;
    }

}
