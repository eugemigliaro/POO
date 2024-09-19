package PrimerosParciales.P1C12022.ej1;

public class InvalidMonthException extends RuntimeException {
    private static final String MESSAGE = "Invalid month.";

    public InvalidMonthException() {
        super(MESSAGE);
    }
}
