package Taller4.ej5;

import Taller4.ej4.PhoneNumber;

import java.util.Comparator;

public class DescendingPhoneNumberComparator implements Comparator<PhoneNumber> {
    public int compare(PhoneNumber o1, PhoneNumber o2) {
        return o2.compareTo(o1);
    }
}