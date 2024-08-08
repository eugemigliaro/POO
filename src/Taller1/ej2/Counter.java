package Taller1.ej2;

public class Counter{
    private int value;
    public Counter(){
        value = 0;
    }
    public int getValue(){
        return this.value;
    }
    public void increment(){
        this.value++;
    }
    public void decrement(){
        this.value--;
    }
    public void reset(){
        this.value = 0;
    }
}