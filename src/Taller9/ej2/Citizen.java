package Taller9.ej2;

public class Citizen implements Comparable<Citizen>{
    private final String firstName;
    private final String lastName;
    private final long dni;

    public Citizen(Long dni, String firstName, String lastName) {
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

    @Override
    public int compareTo(Citizen other) {
        int cmp = this.getFirstName().compareTo(other.getFirstName());
        if (cmp == 0){
            cmp = this.getLastName().compareTo(other.getLastName());
            if(cmp == 0){
                cmp = Long.compare(this.getDni(), other.getDni());
            }
        }

        return cmp;
    }
}
