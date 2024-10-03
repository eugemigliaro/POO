package Taller8.ej1;

import java.util.List;
import java.util.function.Function;

public interface SimpleList<T> extends List<T> {

    public SimpleList<T> map(Function<T, T> function);
}
