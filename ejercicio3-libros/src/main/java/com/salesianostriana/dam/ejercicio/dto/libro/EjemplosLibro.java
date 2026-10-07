package com.salesianostriana.dam.ejercicio.dto.libro;

import java.util.List;

/** Datos de prueba compartidos por MainLibro y LibroController. */
public final class EjemplosLibro {

    private EjemplosLibro() {
    }

    public static List<Libro> libros() {

        Autor garciaMarquez = Autor.builder()
                .id(1L).nombre("Gabriel").apellido1("García").apellido2("Márquez")
                .nacionalidad("Colombiana").build();

        Autor orwell = Autor.builder()
                .id(2L).nombre("George").apellido1("Orwell")
                .nacionalidad("Británica").build();

        Autor incompleto = Autor.builder()
                .id(3L).apellido1("Anónimo").apellido2("   ")
                .nacionalidad("Desconocida").build();

        return List.of(
                Libro.builder().id(1L).titulo("Cien años de soledad").isbn("978-0307474728")
                        .anioPublicacion(1967).numeroPaginas(471).autor(garciaMarquez).build(),
                Libro.builder().id(2L).titulo("1984").isbn("978-0451524935")
                        .anioPublicacion(1949).numeroPaginas(328).autor(orwell).build(),

                Libro.builder().id(3L).titulo("Libro sin autor").isbn("978-0000000000")
                        .anioPublicacion(2020).numeroPaginas(100).build(),
                Libro.builder().id(4L).titulo("Autor incompleto").isbn("978-1111111111")
                        .anioPublicacion(2001).numeroPaginas(200).autor(incompleto).build()
        );
    }

}
