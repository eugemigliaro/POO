package SegundosParciales.Repaso.ej2;

/*Se desea contar con la clase ReversedListImpl para contar con una lista cuyo
 * iterador retorne los elementos en el orden inverso al que se encuentran
 * almacenados. Asimismo, se debe ofrecer un método alternativo para iterar por
 * los elementos en el orden habitual.
 * Implementar todo lo necesario para que, con el siguiente programa, se obtenga
 * la siguiente salida:
 *             1 2 3 4
 *             4 3 2 1
*/

import java.util.Iterator;

public class ReversedListTester {
    public static void main(String[] args) {
        ReversedList<Integer> list = new ReversedListImpl<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        Iterator<Integer> defaultIterator = list.defaultIterator();
        while(defaultIterator.hasNext()) {
            System.out.print(defaultIterator.next() + " ");
        }
        System.out.println();
        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }
}
