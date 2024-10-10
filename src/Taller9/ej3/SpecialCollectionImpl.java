package Taller9.ej3;

import java.util.*;
import java.util.function.Predicate;

public class SpecialCollectionImpl<T extends Comparable<? super T>> extends TreeSet<T> implements SpecialCollection<T> {
    private Deque<T> deleted = new LinkedList<T>();

    public SpecialCollectionImpl() {
        super(Comparator.reverseOrder());
    }

    @Override
    public void deleteFirst(Predicate<T> condition){
        if(this.isEmpty()){
            throw new NoSuchElementException();
        }

        T first = this.first();
        if(condition.test(first)){
            this.deleted.push(first);
            this.remove(first);
        }
    }

    @Override
    public void undoDeleteFirst(){
        if(this.deleted.isEmpty()){
            throw new NothingToUndoException();
        }

        this.add(this.deleted.pop());
    }
}
