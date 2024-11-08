package SegundosParciales.Repaso.ej1;

/*
 * Se desea crear una colección que ofrezca el método toMap. Este método
 * recibe una función que indica cómo se debe construir la clave que
 * acompañará a cada valor de la colección en un nuevo mapa que retorna el
 * método. En caso de que se obtengan dos o más claves iguales, en el mapa no
 * quedará una cantidad de entradas igual a los elementos de la colección y no
 * se debe validar.
 *
 * Implementar todo lo necesario para que, con el siguiente programa de prueba,
 * se obtenga la salida indicada en los comentarios.
 */

import java.util.Map;

public class SimpleListTester {
    public static void main(String[] args) {
        SimpleList<Integer> simpleList = new SimpleArrayList<>();

        simpleList.add(1);
        simpleList.add(3);
        simpleList.add(5);
        simpleList.add(7);

        System.out.println(simpleList.size()); // 4

        System.out.println(simpleList.contains(0)); // false

        Map<Integer, Integer> first = simpleList.toMap(element -> element * 2);

        System.out.println(first.get(2)); // 1
        System.out.println(first.get(6)); // 3
        System.out.println(first.get(10)); // 5
        System.out.println(first.get(14)); // 7

        Map<String, Integer> second = simpleList.toMap(element -> String.format("<%d>", element));

        System.out.println(second.get("<1>")); // 1
        System.out.println(second.get("<3>")); // 3
        System.out.println(second.get("<5>")); // 5
        System.out.println(second.get("<7>")); // 7

        Map<Integer, Integer> third = simpleList.toMap(element -> element % 2);

        System.out.println(third.get(0)); // null
        System.out.println(third.get(1)); // Podría ser 1, 3, 5 ó 7
    }

}
