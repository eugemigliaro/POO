package Taller6.ej4;

import java.util.Comparator;
import java.util.Iterator;

public interface List<T> extends Iterable<T> {
    /*Crear la interfaz List<T> que ofrece los métodos para manipular colecciones de elementos.
    Debe permitir agregar un elemento, obtener la posición de un elemento si es que existe,
    remover un elemento de cierta posición y saber si la lista está vacía.
    Agregar el método default removeElement que remueve un elemento de la lista.
    ¿Cómo podría implementarlo utilizando únicamente los métodos que ya provee la interfaz?*/

    void add(T element);
    int get(T element);
    boolean remove(int position);
    boolean isEmpty();
    default boolean removeElement(T element){
        int position = get(element);
        if(position == -1){
            return false;
        }
        return remove(position);
    }

    Iterator<T> customIterator(Comparator<T> comparator);
}
