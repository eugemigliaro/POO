package Taller2.ej2;

public class SubwayCard {
    private int balance;
    private SubwayCentral central;

    public SubwayCard(SubwayCentral central) {
        this.central = central;
        balance = 0;
    }

    public int getBalance() {
        return balance;
    }

    public void addBalance(int amount) {
        this.balance += amount;
    }

    public void removeBalance(int amount) {
        this.balance -= amount;
    }

    public boolean hasBalance(int amount) {
        return this.balance >= amount;
    }

    public void buyTicket() {
        if (this.hasBalance(this.central.getTicketPrice())) {
            this.removeBalance(this.central.getTicketPrice());
        }
    }
}
