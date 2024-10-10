package Taller9.ej2;

public class CitizenBookTester {
    public static void main(String[] args) {
        Citizen sherlock = new Citizen((long)123, "Sherlock", "Holmes");
        Citizen john = new Citizen((long)456, "Dr. John", "Watson");
        Citizen mycroft = new Citizen((long)789, "Mycroft", "Holmes");

        CitizenBook cb = new CitizenBook();

        cb.add(sherlock);
        cb.add(john);
        cb.add(mycroft);

        // Todos los Holmes, ordenado alfabéticamente por nombre
        for(Citizen c : cb.getByLastName("Holmes")) {
            System.out.println(c);
        }

        System.out.println(cb.getByLastName("Lestrade").isEmpty()); // true
    }
}
