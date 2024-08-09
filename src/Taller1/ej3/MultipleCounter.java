package Taller1.ej3;

import Taller1.ej2.Counter;

public class MultipleCounter extends Counter{
    private int delta;
    public MultipleCounter(int delta){
        super();
        this.delta = delta;
    }

    public void increment(){
        for(int i = 0; i < delta; i++){
            super.increment();
        }
    }

    public void decrement(){
        for(int i = 0; i < delta; i++){
            super.decrement();
        }
    }
}