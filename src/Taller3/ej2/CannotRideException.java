package Taller3.ej2;

public class CannotRideException extends Exception {

    private static final String message = "Cannot ride.";

    public CannotRideException(){
        super(message);
    }
}
