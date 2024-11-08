package SegundosParciales.Repaso.ej7;

import java.time.LocalDate;

public class Loan {
    private final User recipient;
    private final String bookName;
    private final LocalDate issueDate;

    public Loan(User recipient, String bookName, LocalDate issueDate) {
        this.recipient = recipient;
        this.bookName = bookName;
        this.issueDate = issueDate;
    }

    public boolean isOverdue(LocalDate now) {
        return now.isAfter(issueDate.plusDays(recipient.getLoanTime()));
    }

    public String getBookName() {
        return bookName;
    }

    @Override
    public String toString() {
        return recipient.toString() + " (" + bookName + " - " + issueDate + ")";
    }
}
