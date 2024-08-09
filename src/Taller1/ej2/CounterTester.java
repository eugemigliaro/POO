package Taller1.ej2;

public class CounterTester{
    public static void main(String[] args) {
        Counter c = new Counter();
        System.out.printf("Initial counter value: %d%n", c.getValue());
        c.increment();
        System.out.printf("Incremented counter value: %d%n", c.getValue());
        c.reset();
        c.decrement();
        System.out.printf("Decremented counter value: %d%n", c.getValue());
        c.reset();
        System.out.printf("Reset counter value: %d%n", c.getValue());
        c = new Counter();
        System.out.printf("New counter value: %d%n", c.getValue());
    }
}