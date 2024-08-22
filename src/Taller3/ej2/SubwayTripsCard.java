package Taller3.ej2;

public class SubwayTripsCard extends SubwayCard {
    private int trips;
    public SubwayTripsCard(SubwayCentral central, int trips) {
        super(central);
        this.trips = trips;
    }

    public boolean canTravel(){
        return trips > 0;
    }

    public void travel() throws CannotRideException{
        if(canTravel()){
            trips--;
            return;
        }

        throw new CannotRideException();
    }

    public int getTrips(){
        return trips;
    }
}
