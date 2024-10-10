package Taller9.ej1;

public class Citizen {
    private final String firstName;
    private final String lastName;
    private final long dni;

    public Citizen(String firstName, String lastName, int dni) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dni = dni;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public long getDni() {
        return dni;
    }
}
