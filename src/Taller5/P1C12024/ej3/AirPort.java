package Taller5.P1C12024.ej3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Predicate;

public class AirPort {
    private Counter[] counters = new Counter[INITIAL_DIM];
    private static final int INITIAL_DIM = 10;
    private int dim;

    public AirPort(){
        dim = 0;
    }

    public Counter[] getCounters(){
        return counters;
    }

    public Counter addCounter(String airLine){
        if(dim == counters.length){
            Counter[] newCounters = new Counter[counters.length + 10];
            System.arraycopy(getCounters(), 0, newCounters, 0, dim);
            counters = newCounters;
        }
        Counter counter = new Counter(airLine, dim);
        counters[dim] = counter;
        dim++;
        return counter;
    }

    public Counter[] airlineOrderCounters(){
        Counter[] newCounters = new Counter[dim];
        System.arraycopy(getCounters(), 0, newCounters, 0, dim);
        Arrays.sort(newCounters);
        return newCounters;
    }

    public Counter[] airlineDescendingOrderCounters(){
        Counter[] newCounters = new Counter[dim];
        System.arraycopy(getCounters(), 0, newCounters, 0, dim);
        Arrays.sort(newCounters, Comparator.reverseOrder());
        return newCounters;
    }

    public void counterCheckIn(Predicate<Counter> predicate){
        for(int i = 0; i < dim; i++){
            Counter counter = counters[i];
            if(predicate.test(counter)){
                counter.checkIn();
            }
        }
    }
}
