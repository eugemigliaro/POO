package PrimerosParciales.P1C12022.ej2;

import java.util.Comparator;

/*public class Dictionary<T extends Comparable<T>> implements Iterable<DictionaryEntry<T>> {
    private DictionaryEntry<T>[] entries;
    private int size;
    private int dim;
    private final static int BLOCK = 10;

    public Dictionary(){
        entries = (DictionaryEntry<T>[]) new Comparable[BLOCK];
        size = 0;
        dim = BLOCK;
    }

    public void addEntry(T word, String definition){
        if(size == dim){
            DictionaryEntry<T>[] newEntries = (DictionaryEntry<T>[]) new Comparable[dim + BLOCK];
            System.arraycopy(entries, 0, newEntries, 0, dim);
            entries = newEntries;
            dim += BLOCK;
        }
        entries[size] = new DictionaryEntry<T>(word, definition);
        size++;
    }

    public Dictionary<T> getOrderedCopy(Comparator<DictionaryEntry<T>> comparator){
        DictionaryEntry<T>[] copy = (DictionaryEntry<T>[]) new Comparable[size];
        System.arraycopy(entries, 0, copy, 0, size);
        java.util.Arrays.sort(copy, 0, size, comparator);

        Dictionary<T> ans = new Dictionary<>();

    }
}*/
