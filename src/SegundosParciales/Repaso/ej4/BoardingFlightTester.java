package SegundosParciales.Repaso.ej4;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/*Se desea implementar un sistema para cargar los pasajeros de un vuelo para obtener luego
el orden de llamada para el embarque. Un pasajero cuenta con su nombre (que no se repite en el
vuelo), una fila de asiento y una categoría de membresía de la aerolínea.

Existen dos formas de embarque:
Por fila de asiento: Donde embarcan primero los pasajeros de las filas menores (orden
ascendente en función de la fila del asiento).
Por categoría del pasajero: Donde embarcan primero los pasajeros de categorías superiores
(orden ascendente en función de la categoría del pasajero donde la categoría superior
EMERALD tiene el valor más bajo y la categoría inferior ECONOMY tiene el valor más alto).

Implementar todo lo necesario para que, con el siguiente programa de prueba, se obtenga la
siguiente salida:
[EMERALD, SAPPHIRE, RUBY, ECONOMY]
[EMERALD, SAPPHIRE, RUBY, ECONOMY]
-----
Passenger 2
Passenger 4
Passenger 3
Passenger 1
No more elements
-----
Passenger 4
Passenger 2
Passenger 1
Passenger 3
No more elements
*/

public class BoardingFlightTester {
    public static void main(String[] args) {
        PassengerCategory[] categories = PassengerCategory.values();
        System.out.println(Arrays.toString(categories));
        Arrays.sort(categories);
        System.out.println(Arrays.toString(categories));
        System.out.println("-----");
        BoardingFlight rowBoardingFlight = new RowBoardingFlight();
        rowBoardingFlight.addForBoarding("Passenger 3", 10, PassengerCategory.ECONOMY);
        rowBoardingFlight.addForBoarding("Passenger 2", 5, PassengerCategory.RUBY);
        rowBoardingFlight.addForBoarding("Passenger 1", 15, PassengerCategory.ECONOMY);
        rowBoardingFlight.addForBoarding("Passenger 4", 5, PassengerCategory.EMERALD);
        Iterator<String> rowIterator = rowBoardingFlight.boardingCallIterator();
        while(rowIterator.hasNext()) {
            System.out.println(rowIterator.next());
        }
        try {
            rowIterator.next();
        } catch (NoSuchElementException ex) {
            System.out.println("No more elements");
        }
        System.out.println("-----");
        BoardingFlight categoryBoardingFlight = new CategoryBoardingFlight();
        categoryBoardingFlight.addForBoarding("Passenger 3", 10, PassengerCategory.ECONOMY);
        categoryBoardingFlight.addForBoarding("Passenger 2", 5, PassengerCategory.RUBY);
        categoryBoardingFlight.addForBoarding("Passenger 1", 15, PassengerCategory.ECONOMY);
        categoryBoardingFlight.addForBoarding("Passenger 4", 5, PassengerCategory.EMERALD);
        Iterator<String> categoryIterator = categoryBoardingFlight.boardingCallIterator();
        while(categoryIterator.hasNext()) {
            System.out.println(categoryIterator.next());
        }
        try {
            categoryIterator.next();
        } catch (NoSuchElementException ex) {
            System.out.println("No more elements");
        }
    }

}
