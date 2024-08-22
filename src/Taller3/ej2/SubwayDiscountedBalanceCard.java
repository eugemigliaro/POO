package Taller3.ej2;

public class SubwayDiscountedBalanceCard extends SubwayBalanceCard {
    private final int discount;

    public SubwayDiscountedBalanceCard(SubwayCentral central, int discount) {
        super(central);
        this.discount = discount;
    }

    public int getDiscount(){
        return discount;
    }

    @Override
    public int getTicketPrice(){
        return super.getTicketPrice() * (100 - getDiscount()) / 100;
    }
}