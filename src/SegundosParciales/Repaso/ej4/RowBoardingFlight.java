package SegundosParciales.Repaso.ej4;

import java.util.Comparator;

public class RowBoardingFlight extends BoardingFlight {
    private static class RowComparator implements Comparator<PassengerInfo> {
        @Override
        public int compare(PassengerInfo o1, PassengerInfo o2) {
            int cmp = Integer.compare(o1.getRow(), o2.getRow());
            if (cmp != 0) {
                return cmp;
            }
            return o1.getName().compareTo(o2.getName());
        }
    }

    public RowBoardingFlight() {
        super(new RowComparator());
    }
}
