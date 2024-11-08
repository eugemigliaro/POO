package SegundosParciales.Repaso.ej5;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class DoubleKeyHashMap<K1,K2,V> implements DoubleKeyMapTester.DoubleKeyMap<K1, K2, V> {

    private Map<Pair<K1, K2>, V> map;

    private static class Pair<K1, K2> {
        private final K1 firstKey;
        private final K2 secondKey;

        public Pair(K1 firstKey, K2 secondKey) {
            this.firstKey = firstKey;
            this.secondKey = secondKey;
        }

        public K1 getFirstKey() {
            return firstKey;
        }

        public K2 getSecondKey() {
            return secondKey;
        }

        @Override
        public boolean equals(Object o){
            if (this == o) return true;
            if (o == null || !(o instanceof Pair pair)) return false;
            return firstKey.equals(pair.firstKey) && secondKey.equals(pair.secondKey);
        }

        @Override
        public int hashCode() {
            return Objects.hash(firstKey, secondKey);
        }
    }

    public DoubleKeyHashMap() {
        map = new HashMap<>();
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean containsKey(K1 firstKey, K2 secondKey) {
        return map.containsKey(new Pair<>(firstKey, secondKey));
    }

    @Override
    public boolean containsValue(V value) {
        return map.containsValue(value);
    }

    @Override
    public V get(K1 firstKey, K2 secondKey) {
        return map.get(new Pair<>(firstKey, secondKey));
    }

    @Override
    public void put(K1 firstKey, K2 secondKey, V value) {
        map.put(new Pair<>(firstKey, secondKey), value);
    }
}
