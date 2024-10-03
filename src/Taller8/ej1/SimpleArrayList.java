package Taller8.ej1;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/*Se desea crear una colección
que ofrezca el método map.

Este método devuelve una nueva colección aplicando una función a cada uno de los elementos de la colección.*/

public class SimpleArrayList<T> extends ArrayList<T> implements SimpleList<T> {

    @Override
    public SimpleList<T> map(Function<T, T> function){
        SimpleArrayList<T> simpleList = new SimpleArrayList<>();
        for(T element : this){
            simpleList.add(function.apply(element));
        }
        return simpleList;
    }
}
