package PrimerosParciales.P1C12022.ej1;

/* Se desea modelar un sistema para que los clientes se suscriban a un plan de millas de forma de,
a partir de un pago mensual, obtener una cierta cantidad de millas cada mes.
 Existen varios planes donde cada uno tiene definido un costo mensual y la cantidad de millas que se otorgan cada mes.
 Algunos planes cuentan además con una promoción que permite sumar una cantidad extra de millas sólo durante los primeros meses.

 Los detalles de los planes son los siguientes:
 Plan               Millas por mes              Costo por mes               Promoción Millas Extras
 Club 1000          1000                        $950                        No tiene
 Club 2000          2000                        $1750                       1000 millas extras los primeros 2 meses
 Club 5000          5000                        $4400                       2500 millas extras los primeros 5 meses
 Club 10000         10000                       $14400                      10000 millas extras los primeros 6 meses

 La clase MilesClient debe permitir, para cada cliente, obtener los extractos de cada mes donde se indican
 cuántas millas obtuvo el cliente en un mes (incluyendo las millas extras si corresponde) y cuánto pagó ese mes.
 Al instanciar Miles Client se indica por parámetro el nombre del cliente, la cantidad de meses a los que se suscribió y el plan elegido.
 En caso de querer consultar el extracto de un mes más allá de la cantidad de meses definida en el constructor se arroja un error.

 Completar los ...................., implementar MilesClient y todo lo necesario para que,
 con el siguiente programa de prueba, se obtenga la salida en los comentarios. */

import java.util.Iterator;

public class MilesClientTester {
    public static void main(String[] args) {
       // El cliente "Chuck" se suscribe por 4 meses al plan Club 2000
       MilesClient chuck = new MilesClient("Chuck", 4, Plan.CLUB2000);
       // Se imprime el extracto de cada mes del cliente "Chuck"
       // para todos los meses suscriptos
       // Por el plan elegido los 2 primeros meses tendrá millas bonus
       for (String monthLine : chuck) {
           System.out.println(monthLine);
       }
       System.out.println("##########");

       // El cliente "Sarah" se suscribe por 2 meses al plan Club 1000
       MilesClient sarah = new MilesClient("Sarah", 2, Plan.CLUB1000);
       // Se imprime el extracto de cada mes del cliente "Sarah"
       // para todos los meses suscriptos
       Iterator<String> sarahIt = sarah.iterator();
       for(int i = 0; i < 2; i++) {
           System.out.println(sarahIt.next());
       }
       System.out.println("##########");
       // El extracto del tercer mes de "Sarah" arroja un error
       // pues se suscribió por 2 meses
       try {
           sarahIt.next();
       } catch (Exception ex) {
           System.out.println("Invalid Month");
       }
       System.out.println("##########");

       // El cliente "Morgan" se suscribe por 6 meses al plan Club 5000
       MilesClient morgan = new MilesClient("Morgan", 6, Plan.CLUB5000);
       // Se imprime el extracto de cada mes del cliente "Morgan"
       // para los 4 primeros meses
       // Por el plan elegido los 5 primeros meses tendrá millas bonus
       Iterator<String> morganIt = morgan.iterator();
       for(int i = 0; i < 4; i++) {
           System.out.println(morganIt.next());
       }
       System.out.println("##########");

       // Se imprimen el extracto del primer mes del cliente "Chuck"
       Iterator<String> chuckIt = chuck.iterator();
       System.out.println(chuckIt.next());
       System.out.println("##########");

       // Se imprime el extracto de cada mes del cliente "Morgan"
       // para los meses 5 y 6
       // Por el plan elegido los 5 primeros meses tendrá millas bonus
       for(int i = 5; i < 7; i++) {
           System.out.println(morganIt.next());
       }
       System.out.println("##########");
   }
}

/* 
Client Chuck: Month 1 earned 3000 miles for $1750.00
Client Chuck: Month 2 earned 3000 miles for $1750.00
Client Chuck: Month 3 earned 2000 miles for $1750.00
Client Chuck: Month 4 earned 2000 miles for $1750.00
##########
Client Sarah: Month 1 earned 1000 miles for $950.00
Client Sarah: Month 2 earned 1000 miles for $950.00
##########
Invalid Month
##########
Client Morgan: Month 1 earned 7500 miles for $4400.00
Client Morgan: Month 2 earned 7500 miles for $4400.00
Client Morgan: Month 3 earned 7500 miles for $4400.00
Client Morgan: Month 4 earned 7500 miles for $4400.00
##########
Client Chuck: Month 1 earned 3000 miles for $1750.00
##########
Client Morgan: Month 5 earned 7500 miles for $4400.00
Client Morgan: Month 6 earned 5000 miles for $4400.00
##########
*/
