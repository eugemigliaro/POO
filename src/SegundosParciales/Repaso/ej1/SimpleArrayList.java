package SegundosParciales.Repaso.ej1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class SimpleArrayList<T> extends ArrayList<T> implements SimpleList<T>{
    @Override
    public <R> Map<R, T> toMap(Function<T, R> function) {
        Map<R, T> ans = new HashMap<>();

        for(T element : this){
            ans.putIfAbsent(function.apply(element), element);
        }

        return ans;
    }
}
