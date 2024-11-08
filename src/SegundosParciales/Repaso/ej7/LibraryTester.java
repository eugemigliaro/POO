package SegundosParciales.Repaso.ej7;

import java.time.LocalDate;

/*Se desea implementar un conjunto de clases que permitan administrar el préstamo de libros
de la biblioteca de una universidad a sus alumnos y docentes.
Ya se cuenta con la clase BookInfo implementada, la cual relaciona el nombre del libro con el
stock actual.

Las reglas de la biblioteca son las siguientes:
Se puede prestar únicamente un libro por persona.
Si es alumno, el préstamo del libro es por 2 días.
Si es profesor, el tiempo del préstamo del libro dependerá de su cargo:
Responsable: 12 días
Jefe de Trabajos Prácticos: 11 días
Ayudante: 10 días.
Implementar todo lo necesario y completar los .......... para que, con el siguiente programa
de prueba, se obtenga la siguiente salida:

true
Due loans at 2018-12-04
Student 2 (Book 3 - 2018-12-01)
Student 1 (Book 1 - 2018-12-01)

Due loans at 2018-12-10

Due loans at 2018-12-15
Professor 3 (Book 3 - 2018-12-04)

Due loans at 2018-12-16
Professor 3 (Book 3 - 2018-12-04)
Professor 2 (Book 3 - 2018-12-04)

Due loans at 2018-12-17
Professor 3 (Book 3 - 2018-12-04)
Professor 2 (Book 3 - 2018-12-04)
Professor 1 (Book 1 - 2018-12-04)
Book not found.
*/

public class LibraryTester {
    public static void main(String[] args) {
        // Ejemplo de uso para determinar si una fecha está después que otra fecha
        System.out.println(LocalDate.of(2018,12,3).isAfter(LocalDate.of(2018,12,1)));

        Library library = new Library().addBook("Book 1", 1)
                .addBook("Book 2", 1)
                .addBook("Book 3", 3);

        // El estudiante Student 1 pide el libro Book 1

        User s1 = new User("Student 1", UserType.ALUMNO);
        library.borrowBook(s1, "Book 1", LocalDate.of(2018, 12, 1));
        // El estudiante Student 2 pide el libro Book 3

        User s2 = new User("Student 2", UserType.ALUMNO);
        library.borrowBook(s2, "Book 3", LocalDate.of(2018, 12, 1));
        // El estudiante Student 3 pide el libro Book 3

        User s3 = new User("Student 3", UserType.ALUMNO);
        library.borrowBook(s3, "Book 3", LocalDate.of(2018, 12, 2));

        // Lista los préstamos vencidos para la fecha recibida
        library.printDueLoansBooks(LocalDate.of(2018, 12, 4));
        library.returnBook(s1); // El estudiante Student 1 devuelve el libro que pidió
        library.returnBook(s2); // El estudiante Student 2 devuelve el libro que pidió
        library.returnBook(s3); // El estudiante Student 3 devuelve el libro que pidió

        // El profesor Professor 1 es Responsable y pide el libro Book 1

        User p1 = new User("Professor 1", UserType.RESPONSABLE);
        library.borrowBook(p1, "Book 1", LocalDate.of(2018, 12, 4));
        // El profesor Professor 2 es Jefe de Trabajos Prácticos y pide el libro Book 3

        User p2 = new User("Professor 2", UserType.JEFE);
        library.borrowBook(p2, "Book 3", LocalDate.of(2018, 12, 4));
        // El profesor Professor 3 es Ayudante y pide el libro Book 3

        User p3 = new User("Professor 3", UserType.AYUDANTE);
        library.borrowBook(p3, "Book 3", LocalDate.of(2018, 12, 4));

        library.printDueLoansBooks(LocalDate.of(2018, 12, 10));
        library.printDueLoansBooks(LocalDate.of(2018, 12, 15));
        library.printDueLoansBooks(LocalDate.of(2018, 12, 16));
        library.printDueLoansBooks(LocalDate.of(2018, 12, 17));

        try {
            library.borrowBook(s1, "Other Book", LocalDate.of(2018,12,3));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
