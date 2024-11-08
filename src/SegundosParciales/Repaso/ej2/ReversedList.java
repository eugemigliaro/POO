package SegundosParciales.Repaso.ej2;

import java.util.Iterator;
import java.util.List;

public interface ReversedList<T> extends List<T> {

    Iterator<T> defaultIterator();

    @Override
    Iterator<T> iterator();
}
