package Taller5.P1C12024.ej3;

/*Se desea modelar un sistema para la gestión de mostradores de check-in de un aeropuerto. El mismo debe contar con un método que agrega un mostrador al aeropuerto (respetando una numeración incremental que inicia en 0) indicando qué aerolínea lo utilizará. Todos los mostradores se inician libres (idle), esto es, no están siendo usados para check-in.
Para iniciar el check-in en un mostrador existen dos formas:
checkIn sobre un mostrador
counterCheckIn sobre un aeropuerto, donde se inicia el check-in en el primer mostrador (en orden de inserción) que cumpla una condición enviada por parámetro. Si no existen mostradores en el aeropuerto o ninguno cumple la condición la operación no tiene efecto.
Para simplificar el ejercicio, si se intenta realizar el check-in (en cualquiera de las dos formas) en un mostrador que ya estaba realizando check-in la operación no tiene efecto.
	Para consultar los mostradores existen dos formas:
airlineOrderCounters retorna los mostradores en orden alfabético por aerolínea y desempata ascendente por número
airlineDescdeningOrderCounters retorna los mostradores en orden descendente por aerolínea y desempata descendente por número

Completar el ..........G.........., implementar Airport, Counter y todo lo necesario para que, con el siguiente programa de prueba, se obtenga la salida indicada en los comentarios:*/

import java.util.function.Predicate;

public class Tester {
    public static void main(String[] args) {
        // Se instancia un aeropuerto
        AirPort airPort = new AirPort();


        // Se instancia el mostrador 0 para Air Canada e inicia libre
        Counter counter0 = airPort.addCounter("Air Canada");
        System.out.println(counter0); // Counter 0 for Air Canada is idle
        Counter counter1 = airPort.addCounter("American Airlines");
        System.out.println(counter1); // Counter 1 for American Airlines is idle
        Counter counter2 = airPort.addCounter("American Airlines");
        System.out.println(counter2); // Counter 2 for American Airlines is idle
        airPort.addCounter("Air Canada");
        airPort.addCounter("LATAM");


        // Se inicia el check-in en el mostrador 1
        counter1.checkIn();
        System.out.println(counter1); // Counter 1 for American Airlines is checking in


        // Se obtienen los mostradores en orden alfabético por aerolínea
        // y desempata ascendente por número
        for(Counter counter : airPort.airlineOrderCounters()) {
            System.out.println(counter);
        }
        // Counter 0 for Air Canada is idle
        // Counter 3 for Air Canada is idle
        // Counter 1 for American Airlines is checking in
        // Counter 2 for American Airlines is idle
        // Counter 4 for LATAM is idle


        // Se obtienen los mostradores en orden descendente por aerolínea
        // y desempata descendente por número
        for(Counter counter : airPort.airlineDescendingOrderCounters()) {
            System.out.println(counter);
        }
        // Counter 4 for LATAM is idle
        // Counter 2 for American Airlines is idle
        // Counter 1 for American Airlines is checking in
        // Counter 3 for Air Canada is idle
        // Counter 0 for Air Canada is idle


        // Se inicia el check-in en el primer mostrador (en orden de inserción)
        // que cumpla las siguientes condiciones:
        // - No inició check-in
        // - La aerolínea empieza con la letra "A"
        // Si ningún mostrador cumple las condiciones no hace nada
        Predicate<Counter> idleAndStartsWithA = new Predicate<Counter>() {
            @Override
            public boolean test(Counter counter) {
                return !counter.getIsOccupied() && counter.getAirLine().startsWith("A");
            }
        };
        airPort.counterCheckIn(idleAndStartsWithA);
        System.out.println(counter0); // Counter 0 for Air Canada is checking in
        System.out.println(counter1); // Counter 1 for American Airlines is checking in
        System.out.println(counter2); // Counter 2 for American Airlines is idle


        airPort.counterCheckIn(idleAndStartsWithA);
        System.out.println(counter0); // Counter 0 for Air Canada is checking in
        System.out.println(counter1); // Counter 1 for American Airlines is checking in
        System.out.println(counter2); // Counter 2 for American Airlines is checking in
    }

}
