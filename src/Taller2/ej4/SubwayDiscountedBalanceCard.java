package Taller2.ej4;
import Taller2.ej3.*;

public class SubwayDiscountedBalanceCard extends SubwayBalanceCard{
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
        return super.getTicketPrice() - super.getTicketPrice() * getDiscount() / 100;
    }

    @Override
    public boolean canTravel(){
        return super.getBalance() >= getTicketPrice();
    }

    @Override
    public boolean travel(){
        if(canTravel()){
            removeBalance(getTicketPrice());
            return true;
        }
        return false;
    }
}