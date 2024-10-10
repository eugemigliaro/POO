package Taller9.ej1;

/*Crear la clase Citizen que modela a un ciudadano con las propiedades: DNI, nombre y apellido.
Implementar un programa que utilice las colecciones de Java para almacenar instancias de Citizen y luego accederlas por:
DNI
Nombre
Nombre y Apellido
¿Y si se desea que la colección donde se busca por DNI esté ordenada por este campo?
*/

import java.util.*;

public class CitizenTester {
    public static void main(String[] args) {
        Citizen c1 = new Citizen("John", "Doe", 12345678);
        Citizen c2 = new Citizen("Jane", "Doe", 12345679);
        Citizen c3 = new Citizen("Jane", "Doe", 12345679);
        Citizen c4 = new Citizen("John", "Doe", 12345678);

        Map<Long, Citizen> dniMap = new HashMap<>();

        dniMap.put(c1.getDni(), c1);
        dniMap.put(c2.getDni(), c2);
        dniMap.put(c3.getDni(), c3);
        dniMap.put(c4.getDni(), c4);

        System.out.println(dniMap);

        Map<String, List<Citizen>> firstNameMap = new HashMap<>(); // <key, value// >

        firstNameMap.put(c1.getFirstName(), new ArrayList<Citizen>());
        firstNameMap.get(c1.getFirstName()).add(c1);
        firstNameMap.get(c1.getFirstName()).add(c4);

        firstNameMap.put(c2.getFirstName(), new ArrayList<Citizen>());
        firstNameMap.get(c2.getFirstName()).add(c2);
        firstNameMap.get(c2.getFirstName()).add(c3);

        System.out.println(firstNameMap);

        Map<String, Map<String, List<Citizen>>> fullNameMap = new HashMap<>(); // <key, value// >

        fullNameMap.put(c1.getFirstName(), new HashMap<>());
        fullNameMap.get(c1.getFirstName()).put(c1.getLastName(), new ArrayList<Citizen>());
        fullNameMap.get(c1.getFirstName()).get(c1.getLastName()).add(c1);
        fullNameMap.get(c1.getFirstName()).get(c1.getLastName()).add(c4);

        fullNameMap.put(c2.getFirstName(), new HashMap<>());
        fullNameMap.get(c2.getFirstName()).put(c2.getLastName(), new ArrayList<Citizen>());
        fullNameMap.get(c2.getFirstName()).get(c2.getLastName()).add(c2);
        fullNameMap.get(c2.getFirstName()).get(c2.getLastName()).add(c3);

        System.out.println(fullNameMap);

        // ¿Y si se desea que la colección donde se busca por DNI esté ordenada por este campo?
        //creo que acá tengo que usar una colección TreeMap

        Map<Long, Citizen> orderedDniMap = new TreeMap<Long, Citizen>();

        orderedDniMap.put(c1.getDni(), c1);
        orderedDniMap.put(c2.getDni(), c2);
        orderedDniMap.put(c3.getDni(), c3);
        orderedDniMap.put(c4.getDni(), c4);

        System.out.println(orderedDniMap);
    }
}
