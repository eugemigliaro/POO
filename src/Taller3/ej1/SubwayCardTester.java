package Taller3.ej1;
import Taller2.ej3.*;
import Taller2.ej4.SubwayDiscountedBalanceCard;

public class SubwayCardTester {

    public static void main(String[] args) {
        SubwayCentral sc = new SubwayCentral(25);

        SubwayTripsCard fsc = new SubwayTripsCard(sc, 2);
        fsc.travel();
        fsc.travel();
        fsc.travel(); // Imprime un mensaje de error

        SubwayBalanceCard rsc = new SubwayBalanceCard(sc);
        rsc.addBalance(50);
        rsc.travel();
        sc.setTicketPrice(30);
        rsc.travel(); // Imprime un mensaje de error

        SubwayDiscountedBalanceCard drsc = new SubwayDiscountedBalanceCard(sc, 50);
        drsc.addBalance(30);
        drsc.travel();
        drsc.travel();
        drsc.travel(); // Imprime un mensaje de error
    }
}