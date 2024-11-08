package SegundosParciales.Repaso.ej1;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

public interface SimpleList<T> extends List<T> {
    <R> Map<R, T> toMap(Function<T, R> function);
}
