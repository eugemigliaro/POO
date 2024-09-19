package PrimerosParciales.P1C12022.ej1;

public enum Plan {
    CLUB1000(1000, 950, 0, 0),
    CLUB2000(2000, 1750, 1000, 2),
    CLUB5000(5000, 4400, 2500, 5),
    CLUB10000(10000, 14400, 10000, 6);

    private final int milesPerMonth;
    private final double pricePerMonth;
    private final int bonusMiles;
    private final int bonusMonths;

    Plan(int milesPerMonth, double pricePerMonth, int bonusMiles, int bonusMonths) {
        this.milesPerMonth = milesPerMonth;
        this.pricePerMonth = pricePerMonth;
        this.bonusMiles = bonusMiles;
        this.bonusMonths = bonusMonths;
    }

    public int getMilesPerMonth(int month){
        return milesPerMonth + (month < bonusMonths ? bonusMiles : 0);
    }

    public double getPricePerMonth(){
        return pricePerMonth;
    }
}
