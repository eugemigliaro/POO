package Taller1.ej3;

import Taller1.ej2.Counter;

public class MultipleCounterTester {
    public static void main(String[] args) {
        Counter mc = new MultipleCounter(2);
        System.out.println(mc.getValue());
// Imprime 0
        mc.increment(); // Aumenta en 2
        System.out.println(mc.getValue());
// Imprime 2
        mc.decrement(); // Disminuye en 2
        System.out.println(mc.getValue()); // Imprime 0
    }
}