package SegundosParciales.Repaso.ej7;

public class BookNotFoundException extends RuntimeException {
    private static final String MESSAGE = "Book not found.";

    public BookNotFoundException() {
        super(MESSAGE);
    }
}
