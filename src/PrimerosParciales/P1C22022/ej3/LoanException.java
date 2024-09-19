package PrimerosParciales.P1C22022.ej3;

public class LoanException extends RuntimeException {
    private static final String MESSAGE = "Cannot pay.";

    public LoanException() {
        super(MESSAGE);
    }
}
