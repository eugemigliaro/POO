package PrimerosParciales.P1C22022.ej3;

import java.time.LocalDate;

/* Se desea modelar un sistema para otorgar préstamos y registrar los pagos de sus cuotas.
* Se busca ofrecer tres tipos de préstamos con diferentes características. Todos los préstamos tendrán un monto,
* una fecha de emisión y una cantidad de cuotas a pagar. Los préstamos deben contar con el método pay para registrar el pago de una cuota.
* Si se quieren registrar más pagos que la cantidad de cuotas del préstamo o
* si la fecha de los pagos no son posteriores a la fecha de emisión del préstamo entonces se arroja un error.
*
* Los tres tipos de préstamos son los siguientes:
*   El que indica cantidad de cuotas pendientes.
*   El que indica la cantidad de cuotas pendientes y el número de la última cuota paga,
* verificando que las cuotas se pagan de forma consecutiva (sólo puedo pagar la cuota x si la última cuota paga es la x - 1).
*   El que indica la cantidad de cuotas pendientes, el número de la última cuota paga y después de qué fecha será aceptado el siguiente pago,
* verificando que la fecha de pago sea posterior a la fecha del último pago (si es que tiene).
*
* Además de los tres tipos de préstamos existen tres tipos de destinatarios:
*   Personal (Personal): El monto debe ser hasta $50000 y no más de 12 cuotas.
*   Automotor (Vehicle): El monto debe ser hasta $300000 y no más de 24 cuotas.
*   Hipotecario (Home): El monto debe ser hasta $1000000 y no más de 360 cuotas.
*
* Al momento de instanciar un préstamo (de cualquier tipo) se indica el tipo de destinatario del mismo.
* Si el monto o la cantidad de cuotas del mismo no cumplen con las restricciones indicadas se debe arrojar un error.
*
* Importante: Se deben permitir instanciar los tres tipos de préstamos con los tres tipos de destinatarios (soportando todas las combinaciones).
*
* Completar los .........., implementar Loan, LoanException y todo lo necesario para que,
* con el siguiente programa de prueba, se obtenga la salida indicada en los comentarios. */

public class LoanTester {
    public static void main(String[] args) {
       System.out.println(LocalDate.of(2022,9,22)); // 2022-09-22
       System.out.println(LocalDate.of(2022,9,23).isAfter(LocalDate.of(2022,9,22))); // true

       // Se instancia un préstamo PERSONAL de $1000 de 3 cuotas con fecha 1/9/2022
       // que indica las cuotas pendientes
       // donde no se pueden hacer más de 3 pagos
       // y las fechas de los mismos deben ser posteriores a la fecha del préstamo
       Loan l1 = new Loan(LoanRecipient.PERSONAL, 1000, 3, LocalDate.of(2022, 9, 1));
       System.out.println(l1); // PERSONAL Loan of $1000. Remaining quota: 3.
       // Se paga la cuota 1 con fecha 1/10/2022
       l1.pay(1, LocalDate.of(2022, 10, 1)); // Paying quota 1 on date 2022-10-01.
       System.out.println(l1); // PERSONAL Loan of $1000. Remaining quota: 2.
       try {
           // Ocurre un error pues la fecha de pago no es posterior a la fecha del préstamo
           l1.pay(2, LocalDate.of(2000, 1, 1));
       } catch (LoanException ex) {
           System.out.println(ex.getMessage()); // Cannot pay.
       }
       // No se verifica que la cuota 5 sea menor a 3 o que la cuota 1 no se haya pagado.
       l1.pay(5, LocalDate.of(2022, 10, 1)); // Paying quota 5 on date 2022-10-01.
       l1.pay(1, LocalDate.of(2022, 10, 1)); // Paying quota 1 on date 2022-10-01.
       System.out.println(l1); // PERSONAL Loan of $1000. Remaining quota: 0.
       try {
           // Ocurre un error pues no hay más cuotas pendientes
           l1.pay(1, LocalDate.of(2022, 10, 1));
       } catch (LoanException ex) {
           System.out.println(ex.getMessage()); // Cannot pay.
       }

       // Se instancia un préstamo AUTOMOTOR de $2000 de 3 cuotas con fecha 1/9/2022
       // que indica las cuotas pendientes y el número de la última cuota paga
       // donde no se pueden hacer más de 3 pagos
       // y los mismos deben realizarse en orden consecutivo
       // y las fechas de los mismos deben ser posteriores a la fecha del préstamo
       Loan l2 = new LastPayedPaymentLoan(LoanRecipient.VEHICLE, 2000, 3, LocalDate.of(2022, 9, 1));
       System.out.println(l2); // VEHICLE Loan of $2000. Remaining quota: 3. Last quota: 0.
       l2.pay(1, LocalDate.of(2022, 10, 1)); // Paying quota 1 on date 2022-10-01.
       System.out.println(l2); // VEHICLE Loan of $2000. Remaining quota: 2. Last quota: 1.
       try {
           // Ocurre un error pues se intenta pagar la cuota 3 pero la última paga es la 1
           l2.pay(3, LocalDate.of(2022, 11, 1));
       } catch (LoanException ex) {
           System.out.println(ex.getMessage()); // Cannot pay.
       }
       l2.pay(2, LocalDate.of(2022, 9, 2)); // Paying quota 2 on date 2022-09-02.
       System.out.println(l2); // VEHICLE Loan of $2000. Remaining quota: 1. Last quota: 2.
       l2.pay(3, LocalDate.of(2022, 12, 31)); // Paying quota 3 on date 2022-12-31.
       System.out.println(l2); // VEHICLE Loan of $2000. Remaining quota: 0. Last quota: 3.

       // Se instancia un préstamo HIPOTECARIO de $3000 de 3 cuotas con fecha 1/9/2022
       // que indica las cuotas pendientes y el número de la última cuota paga
       // y después de que fecha será aceptado el siguiente pago
       // donde no se pueden hacer más de 3 pagos
       // y los mismos deben realizarse en orden consecutivo
       // y las fechas de los mismos deben ser posteriores a la fecha del préstamo
       // y también posteriores a la fecha del último pago
       Loan l3 = new AfterDateLoan(LoanRecipient.HOME, 3000, 3, LocalDate.of(2022, 9, 1));
       System.out.println(l3); 
  // HOME Loan of $3000. Remaining quota: 3. Last quota: 0. Next PayDate: After 2022-09-01.
       l3.pay(1, LocalDate.of(2022, 10, 1)); // Paying quota 1 on date 2022-10-01.
       System.out.println(l3); 
  // HOME Loan of $3000. Remaining quota: 2. Last quota: 1. Next PayDate: After 2022-10-01.
       try {
           // Ocurre un error pues la fecha de pago no es posterior a la del último pago
           l3.pay(2, LocalDate.of(2022, 9, 2));
       } catch (LoanException ex) {
           System.out.println(ex.getMessage()); // Cannot pay.
       }
       l3.pay(2, LocalDate.of(2022, 12, 27)); // Paying quota 2 on date 2022-12-27.
       l3.pay(3, LocalDate.of(2022, 12, 28)); // Paying quota 3 on date 2022-12-28.
       System.out.println(l3); 
  // HOME Loan of $3000. Remaining quota: 0. Last quota: 3. Next PayDate: After 2022-12-28.
       
       try {
           // Ocurre un error pues al instanciar un préstamo (de cualquier tipo)
           // el monto (75.000) supera el máximo (50.000) del destinatario (PERSONAL)
           new Loan(LoanRecipient.PERSONAL, 75000, 24, LocalDate.of(2022, 9, 1));
       } catch (LoanException ex) {
           System.out.println(ex.getMessage()); // Invalid Loan.
       }

       try {
           // Ocurre un error pues al instanciar un préstamo (de cualquier tipo)
           // la cantidad de cuotas (30) supera el máximo (24) del destinatario (VEHICLE)
           new Loan(LoanRecipient.VEHICLE, 2000, 30, LocalDate.of(2022, 9, 1));
       } catch (LoanException ex) {
           System.out.println(ex.getMessage()); // Invalid Loan. 
       }
   }
}
