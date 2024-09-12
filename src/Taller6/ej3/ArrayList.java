package Taller6.ej3;

import Taller6.ej2.List;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

/*Retomando la implementación de ArrayList del ejercicio anterior, se desea que la colección
sea iterable con cierto orden que se indica al instanciar una ArrayList.

Los elementos en la colección seguirán estando ordenados según el momento de inserción.
Solo se iterarán por los elementos que existían en la colección al momento de instanciar el iterador.*/

public class ArrayList<T extends Comparable<? super T>> implements List<T> {
    private T[] array;
    private int size;

    public ArrayList(){
        size = 0;
        array = (T[]) new Comparable[size];
    }

    @Override
    public void add(T element){
        if(size == array.length){
            T[] newArray = (T[]) new Object[size + 1];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
        }
        array[size] = element;
        size++;
    }

    @Override
    public int get(T element){
        for(int i = 0; i < size; i++){
            if(array[i].equals(element)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean remove(int position){
        if(position < 0 || position >= size){
            return false;
        }
        System.arraycopy(array, position + 1, array, position, size - position - 1);
        size--;
        return true;
    }

    @Override
    public boolean isEmpty(){
        return size == 0;
    }

    @Override
    public Iterator<T> iterator() {
        T[] sortedArray = Arrays.copyOf(array, size);
        Arrays.sort(sortedArray);

        return new Iterator<T>() {
            private int pos = 0;

            @Override
            public boolean hasNext() {
                return pos < size;
            }
            @Override
            public T next() {
                if(!hasNext()){
                    throw new NoSuchElementException();
                }
                return sortedArray[pos++];
            }
        };
    }
}
