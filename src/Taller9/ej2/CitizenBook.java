package Taller9.ej2;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class CitizenBook {
    private Map<String, Set<Citizen>> citizens = new TreeMap<>();

    public void add(Citizen citizen) {
        citizens
                .computeIfAbsent(citizen.getLastName(), k -> new TreeSet<>())
                .add(citizen);
    }

    //IMPORTANTE: esta clase no está perfecta porque el orden natural de citizen chequea primero el nombre y luego el apellido,
    //la clase está implementada para que el orden empieze por el segundo nombre, pero necesita que el orden natural sea por el apellido

    public Set<Citizen> getByLastName(String lastName) {
        return citizens.getOrDefault(lastName, Set.of());
    }
}
