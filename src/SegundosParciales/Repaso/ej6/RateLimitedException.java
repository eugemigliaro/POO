package SegundosParciales.Repaso.ej6;

public class RateLimitedException extends RuntimeException {

    private static final String MESSAGE = "Exceeded limit.";
    public RateLimitedException() {
        super(MESSAGE);
    }
}
