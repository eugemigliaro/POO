package Taller9.ej3;

import java.util.Set;
import java.util.SortedSet;
import java.util.function.Predicate;

public interface SpecialCollection<T extends Comparable<? super T>> extends SortedSet<T> {
    void deleteFirst(Predicate<T> condition);
    default void deleteFirst(){
        deleteFirst(first -> true);
    }
    void undoDeleteFirst();
}
