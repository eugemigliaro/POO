package SegundosParciales.Repaso.ej3;

import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class FilteredKeyMapIterator<K, V> implements Iterator<K> {
    private final Iterator<Map.Entry<K,V>> keyIterator;
    private final Predicate<K> keyPredicate;
    private Map.Entry<K, V> entry;

    public FilteredKeyMapIterator(Map<K, V> map, Predicate<K> keyPredicate) {
        this.keyIterator = map.entrySet().iterator();
        this.keyPredicate = keyPredicate;
    }

    public boolean hasNext() {
        return keyIterator.hasNext();
    }

    public K next() {
        if(!hasNext()) {
            throw new NoSuchElementException();
        }

        entry = keyIterator.next();
        while(!keyPredicate.test(entry.getKey())) {
            if(!keyIterator.hasNext()) {
                throw new NoSuchElementException();
            }
            entry = keyIterator.next();
        }

        return entry.getKey();
    }

    public V getValue() {
        if (entry == null) {
            throw new NoSuchElementException();
        }
        return entry.getValue();
    }
}
