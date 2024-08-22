package Taller2.ej2;

public class Tester {
    public static void main(String[] args) {
        SubwayCentral sc = new SubwayCentral(1000);
        SubwayCard card1 = new SubwayCard(sc);
        SubwayCard card2 = new SubwayCard(sc);

        card1.addBalance(10000);
        System.out.println("Card1 balance: " + card1.getBalance());
        card2.addBalance(20000);
        System.out.println("Card2 balance: " + card2.getBalance());

        card1.buyTicket();
        System.out.println("Card1 balance: " + card1.getBalance());
        card2.buyTicket();
        System.out.println("Card2 balance: " + card2.getBalance());

        sc.setTicketPrice(500);
        card1.buyTicket();
        System.out.println("Card1 balance: " + card1.getBalance());
        card2.buyTicket();
        System.out.println("Card2 balance: " + card2.getBalance());
    }
}
