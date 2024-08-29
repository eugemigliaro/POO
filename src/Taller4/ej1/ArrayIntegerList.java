package Taller4.ej1;

public class ArrayIntegerList implements List<Integer> {
    private Integer[] array;
    private int size;

    public ArrayIntegerList() {
        size = 0;
        array = new Integer[size];
    }
    @Override
    public void add(Integer element) {
        if (size == array.length) {
            Integer[] newArray = new Integer[size + 1];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
        }
        array[size] = element;
        size++;
    }
    @Override
    public int get(Integer element) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }
    @Override
    public boolean remove(int position) {
        if (position < 0 || position >= size) {
            return false;
        }
        System.arraycopy(array, position + 1, array, position, size - position - 1);
        size--;
        return true;
    }
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
