package Taller8.ej2;

import java.util.List;
import java.util.function.Function;

public interface SimpleList<T> extends List<T> {
    public <R> SimpleList<R> map(Function<T, R> function);
}