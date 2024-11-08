package SegundosParciales.Repaso.ej2;

import java.util.*;

public class ReversedListImpl<T> extends ArrayList<T> implements ReversedList<T>{

    @Override
    public Iterator<T> defaultIterator(){
        return super.iterator();
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int current = size() - 1;

            @Override
            public boolean hasNext() {
                return current >= 0;
            }

            @Override
            public T next() {
                return get(current--);
            }
        };
    }


}
