package SegundosParciales.Repaso.ej7;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Library {
    private Map<String, BookInfo> books = new HashMap<>();
    private Map<User, Loan> loans = new HashMap<>();

    public Library addBook(String name, int stock){
        books.put(name, new BookInfo(name, stock));
        return this;
    }

    public void borrowBook(User user, String bookName, LocalDate loanDate){
       if(!books.containsKey(bookName)){
           throw new BookNotFoundException();
       }

       books.get(bookName).borrowBook();
       loans.put(user, new Loan(user, bookName, loanDate));
    }

    public void returnBook(User user){
        Loan loan = loans.get(user);
        if(loan == null){
            throw new IllegalArgumentException();
        }
        loans.remove(user);
        books.get(loan.getBookName()).returnBook();
    }

    public void printDueLoansBooks(LocalDate now){
        for(Loan loan : loans.values()){
            if(loan.isOverdue(now)){
                System.out.println(loan);
            }
        }
    }
}
