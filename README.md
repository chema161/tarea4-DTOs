# tarea4-DTOs

Ejercicios de transformación a DTO (AD/PSP - 2º DAM, UD1. API REST con Spring Boot).

Cada ejercicio es un proyecto Maven independiente (Spring Boot 4.1.1, Java 21, Lombok):

| Carpeta | Ejercicio | DTO |
|---|---|---|
| `ejercicio3-libros` | Libros y autores | `LibroDTO` |
| `ejercicio4-reservas` | Reservas de hotel | `ReservaDTO` |
| `ejercicio5-series` | Series de una plataforma de streaming | `SerieDTO` |

Cada proyecto incluye su `Main…` para probar la transformación por consola y un controlador
con su `src/main/resources/test.http` para probarla por HTTP (puerto 8080; arranca los proyectos de uno en uno).

En todos los DTO, el método estático `of(...)` devuelve `null` si recibe `null` y construye los nombres
completos omitiendo las partes que no estén informadas (nunca aparece el texto "null").
En `ReservaDTO`, `precioTotal` es `null` cuando no se puede calcular.
