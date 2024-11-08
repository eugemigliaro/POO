package SegundosParciales.Repaso.ej4;

public class PassengerInfo {
    private final String name;
    private final int row;
    private final PassengerCategory category;

    public PassengerInfo(String name, int row, PassengerCategory category) {
        this.name = name;
        this.row = row;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public int getRow() {
        return row;
    }

    public PassengerCategory getCategory() {
        return category;
    }
}
