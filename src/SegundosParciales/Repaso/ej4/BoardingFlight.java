package SegundosParciales.Repaso.ej4;

import java.util.*;

public class BoardingFlight {
    private final Set<PassengerInfo> passengers;

    public BoardingFlight(Comparator<PassengerInfo> passengerComparator){
        this.passengers = new TreeSet<>(passengerComparator);
    }

    public void addForBoarding(String name, int row, PassengerCategory category) {
        passengers.add(new PassengerInfo(name, row, category));
    }

    public Iterator<String> boardingCallIterator() {
        return new Iterator<String>() {
            Iterator<PassengerInfo> passengerIterator = passengers.iterator();
            @Override
            public boolean hasNext() {
                return passengerIterator.hasNext();
            }

            @Override
            public String next() {
                if(!hasNext()) {
                    throw new NoSuchElementException();
                }
                return passengerIterator.next().getName();
            }
        };
    }
}
