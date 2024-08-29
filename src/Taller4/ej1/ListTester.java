package Taller4.ej1;

public class ListTester {

    public static void main(String[] args) {
        List<Integer> integerList = new ArrayIntegerList();
        System.out.println(integerList.isEmpty()); // true
        integerList.add(1);
        integerList.add(4);
        integerList.add(3);
        integerList.add(5);
        System.out.println(integerList.get(3)); // 2
        System.out.println(integerList.remove(2)); // true
        System.out.println(integerList.get(3)); // -1
        System.out.println(integerList.removeElement(1));
    }
}
