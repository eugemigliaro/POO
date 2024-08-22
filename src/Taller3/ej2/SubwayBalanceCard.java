package Taller3.ej2;

public class SubwayBalanceCard extends SubwayCard {
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
    public void travel() throws CannotRideException{
        if(canTravel()){
            removeBalance(getTicketPrice());
            return;
        }
        throw new CannotRideException();
    }
}
