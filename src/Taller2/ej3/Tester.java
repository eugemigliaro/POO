package Taller2.ej3;

public class Tester {
    public static void main(String[] args) {
        SubwayCentral sc = new SubwayCentral(1000);

        SubwayBalanceCard card1 = new SubwayBalanceCard(sc);

        card1.addBalance(10000);
        System.out.println("Card1 balance: " + card1.getBalance());
        card1.removeBalance(5000);
        System.out.println("Card1 balance: " + card1.getBalance());

        sc.setTicketPrice(500);
        card1.travel();
        System.out.println("Card1 balance: " + card1.getBalance());
        card1.travel();
        System.out.println("Card1 balance: " + card1.getBalance());

        SubwayTripsCard card2 = new SubwayTripsCard(sc, 5);

        System.out.printf("Card2 trips left: %d\n", card2.getTrips());

        card2.travel();
        System.out.printf("Card2 trips left: %d\n", card2.getTrips());

        card2.travel();
        System.out.printf("Card2 trips left: %d\n", card2.getTrips());
    }
}
