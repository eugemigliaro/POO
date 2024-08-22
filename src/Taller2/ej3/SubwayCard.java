package Taller2.ej3;

abstract public class SubwayCard {
    private SubwayCentral central;

    public SubwayCard(SubwayCentral central) {
        this.central = central;
    }

    public int getTicketPrice(){
        return central.getTicketPrice();
    }

    abstract public boolean canTravel();
    abstract public boolean travel();
}
