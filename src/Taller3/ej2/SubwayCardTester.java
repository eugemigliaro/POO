package Taller3.ej2;

public class SubwayCardTester {

    public static void main(String[] args) {
        SubwayCentral sc = new SubwayCentral(25);

        SubwayTripsCard fsc = new SubwayTripsCard(sc, 2);
        try{
            fsc.travel();
        }catch(CannotRideException ex){
            System.err.println(ex.getMessage());
        }
        try{
            fsc.travel();
        }catch(CannotRideException ex){
            System.err.println(ex.getMessage());
        }
        try{
            fsc.travel(); // Imprime un mensaje de error
        }catch(CannotRideException ex){
            System.err.println(ex.getMessage());
        }

        SubwayBalanceCard rsc = new SubwayBalanceCard(sc);
        rsc.addBalance(50);
        try{
            rsc.travel();
        }catch(CannotRideException ex){
            System.err.println(ex.getMessage());
        }
        sc.setTicketPrice(30);
        try{
            rsc.travel();// Imprime un mensaje de error
        }catch(CannotRideException ex){
            System.err.println(ex.getMessage());
        }

        SubwayDiscountedBalanceCard drsc = new SubwayDiscountedBalanceCard(sc, 50);
        drsc.addBalance(30);
        try{
            drsc.travel();
        }catch(CannotRideException ex){
            System.err.println(ex.getMessage());
        }
        try{
            drsc.travel();
        }catch(CannotRideException ex){
            System.err.println(ex.getMessage());
        }
        try{
            drsc.travel(); // Imprime un mensaje de error
        }catch(CannotRideException ex){
            System.err.println(ex.getMessage());
        }
    }
}