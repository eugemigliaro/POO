package PrimerosParciales.P1C22022.ej3;

import java.time.LocalDate;

public class LastPayedPaymentLoan extends Loan{
    private int lastPaymentNumber;

    public LastPayedPaymentLoan(LoanRecipient recipient, double amount, int payments, LocalDate issueDate){
        super(recipient, amount, payments, issueDate);

        this.lastPaymentNumber = 0;
    }

    @Override
    public String toString(){
        return super.toString() + " Last quota: " + lastPaymentNumber + ".";
    }

    @Override
    public boolean canPay(int PaymentNumber, LocalDate paymentDate){
        return super.canPay(PaymentNumber, paymentDate) && PaymentNumber == lastPaymentNumber + 1;
    }

    @Override
    public void pay(int PaymentNumber, LocalDate paymentDate){
        if(!canPay(PaymentNumber, paymentDate)){
            throw new LoanException();
        }

        super.pay(PaymentNumber, paymentDate);
        lastPaymentNumber = PaymentNumber;
    }
}
