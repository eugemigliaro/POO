package Taller5.P1C12024.ej3;

public class Counter implements Comparable<Counter> {
    private final String airLine;
    private final int id;
    private boolean isOccupied;

    public Counter(String airLine, int id) {
        this.airLine = airLine;
        this.id = id;
        this.isOccupied = false;
    }

    public String getAirLine() {
        return this.airLine;
    }

    public int getId() {
        return this.id;
    }

    public boolean getIsOccupied() {
        return this.isOccupied;
    }

    @Override
    public int compareTo(Counter other) {
        if(airLine.compareTo(other.getAirLine()) != 0) {
            return airLine.compareTo(other.getAirLine());
        }
        return Integer.compare(id, other.getId());
    }

    public void checkIn(){
        this.isOccupied = true;
    }

    @Override
    public String toString() {
        return "Counter " + id + " for " + airLine + (isOccupied ? " is checking in" : " is idle");
    }
}
