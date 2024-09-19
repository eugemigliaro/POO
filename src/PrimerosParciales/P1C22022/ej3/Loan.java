package PrimerosParciales.P1C22022.ej3;

import java.time.LocalDate;

public class Loan {
    private final LoanRecipient recipient;
    private final double amount;
    private final int payments;
    private final LocalDate issueDate;

    private int remainingPayments;

    public Loan(LoanRecipient recipient, double amount, int payments, LocalDate issueDate){
        this.recipient = recipient;
        this.amount = amount;
        this.payments = payments;
        this.issueDate = issueDate;

        this.remainingPayments = payments;

        if(!recipient.canGetLoan(amount, payments)){
            throw new LoanException();
        }
    }

    public int getRemainingPayments(){
        return remainingPayments;
    }

    public LocalDate getIssueDate(){
        return issueDate;
    }

    @Override
    public String toString(){
        return String.format("%s Loan of $%.2f. Remaining quota: %d.", recipient.toString(), amount, remainingPayments);
    }

    public boolean canPay(int PaymentNumber, LocalDate paymentDate){
        return remainingPayments > 0 && paymentDate.isAfter(issueDate);
    }

    public void pay(int PaymentNumber, LocalDate paymentDate){
        if(!canPay(PaymentNumber, paymentDate)){
            throw new LoanException();
        }

        System.out.println("Paying quota " + PaymentNumber + " at " + paymentDate);

        remainingPayments--;
    }
}
