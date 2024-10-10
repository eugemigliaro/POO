package Taller9.ej3;

public class NothingToUndoException extends RuntimeException {

    private static final String MESSAGE = "Nothing to undo.";
    public NothingToUndoException() {
        super(MESSAGE);
    }
}
