package Taller2.ej3;

public class SubwayBalanceCard extends SubwayCard{
    private int balance;

    public SubwayBalanceCard(SubwayCentral central){
        super(central);
        balance = 0;
    }

    public int getBalance(){
        return balance;
    }
    public void addBalance(int amount){
        this.balance += amount;
    }
    public void removeBalance(int amount){
        this.balance -= amount;
    }
    public boolean canTravel(){
        return balance >= getTicketPrice();
    }
    public boolean travel(){
        if(canTravel()){
            removeBalance(getTicketPrice());
            return true;
        }
        return false;
    }
}
