package Taller2.ej3;

public class SubwayTripsCard extends SubwayCard {
    private int trips;
    public SubwayTripsCard(SubwayCentral central, int trips) {
        super(central);
        this.trips = trips;
    }

    public boolean canTravel() {
        return trips > 0;
    }

    public boolean travel(){
        if(canTravel()){
            trips--;
            return true;
        }
        System.out.println("No hay viajes disponibles");
        return false;
    }

    public int getTrips(){
        return trips;
    }
}
