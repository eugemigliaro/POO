package Taller4.ej3;

import Taller4.ej1.List;

public class ArrayList<T> implements List<T> {
    private T[] array;
    private int size;

    public ArrayList(){
        size = 0;
        array = (T[]) new Object[size];
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
}
