package PrimerosParciales.P1C22022.ej3;

public enum LoanRecipient {

    PERSONAL(50000, 12),
    VEHICLE(300000, 24),
    HOME(1000000, 360);

    private final double maxAmount;
    private final int maxPayments;

    LoanRecipient(double maxAmount, int maxPayments) {
        this.maxAmount = maxAmount;
        this.maxPayments = maxPayments;
    }

    public boolean canGetLoan(double amount, int payments){
        return amount <= maxAmount && payments <= maxPayments;
    }
}
