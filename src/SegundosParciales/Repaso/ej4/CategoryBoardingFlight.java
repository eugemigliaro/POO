package SegundosParciales.Repaso.ej4;

import java.util.Comparator;

public class CategoryBoardingFlight extends BoardingFlight {
    private static class CategoryComparator implements Comparator<PassengerInfo> {
        @Override
        public int compare(PassengerInfo o1, PassengerInfo o2) {
            int cmp = o1.getCategory().compareTo(o2.getCategory());
            if (cmp != 0) {
                return cmp;
            }
            return o1.getName().compareTo(o2.getName());
        }
    }

    public CategoryBoardingFlight() {
        super(new CategoryComparator());
    }
}
