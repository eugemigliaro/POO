package Taller8.ej2;

import java.util.ArrayList;
import java.util.function.Function;

public class SimpleArrayList<T> extends ArrayList<T> implements SimpleList<T> {

    @Override
    public <R> SimpleList<R> map(Function<T, R> function) {
        SimpleArrayList<R> ans = new SimpleArrayList<>();

        for(T element : this){
            ans.add(function.apply(element));
        }

        return ans;
    }
}
