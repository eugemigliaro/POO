package PrimerosParciales.P1C22022.ej3;

import java.time.LocalDate;

public class AfterDateLoan extends LastPayedPaymentLoan {
    private LocalDate lastPaymentDate;

    public AfterDateLoan(LoanRecipient recipient, double amount, int payments, LocalDate issueDate) {
        super(recipient, amount, payments, issueDate);

        this.lastPaymentDate = issueDate;
    }

    @Override
    public String toString() {
        return super.toString() + " Next PayDate: After " + lastPaymentDate;
    }

    @Override
    public boolean canPay(int paymentNumber, LocalDate paymentDate) {
        return super.canPay(paymentNumber, paymentDate) && paymentDate.isAfter(lastPaymentDate);
    }

    @Override
    public void pay(int paymentNumber, LocalDate paymentDate) {
        if(!canPay(paymentNumber, paymentDate)) {
            throw new LoanException();
        }

        super.pay(paymentNumber, paymentDate);
        this.lastPaymentDate = paymentDate;
    }
}