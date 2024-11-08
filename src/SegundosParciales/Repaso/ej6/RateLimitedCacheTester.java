package SegundosParciales.Repaso.ej6;

/* Se cuenta con la interfaz Cache que modela una forma de consultar y establecer valores asociados
a claves de forma similar a un mapa, pero informando qué usuario realizó determinada operación
en la fecha indicada. A motivos de simplificar su uso, ambos identificadores usuario y fecha son instancias de String.
* Además ya se cuenta con la implementación BaseCache
* Se desea contar con una nueva implementación de la interfaz Cache que permita limitar el número
de operaciones de lectura y escritura que cada usuario puede realizar por día según las siguientes dos políticas:
Política ilimitada: no hay ninguna limitación diaria para ambas operaciones.
Política limitada: Se permite un máximo de 2 (dos) lecturas y 1 (una) escritura, por día y por usuario.
	Superado el límite por un usuario en un determinado día, si el usuario intenta realizar nuevamente la misma
operación en el mismo día se debe arrojar la excepción RateLimitedException. Una vez llegado al límite, debe
ser posible realizar operaciones en otras fechas  y/o para otros usuarios y/o la otra operación para el mismo
usuario en el mismo día (si es que aún le queda cuota).
	Implementar todo lo necesario para que, con el siguiente programa de prueba, se obtenga la siguiente salida:
0
Testing puts with a limited quota (maximum 1 per date)
Alice put value 1 for key 1 on 11/11/2019
Cannot put 1->"2" on  11/11/2019
-----
Alice retrieved value 1 for key 1 on 11/11/2019
1
-----
Testing reads with a limited quota (maximum 2 per date)
Alice put value 2 for key 2 on 12/11/2019
-----
Alice retrieved value 1 for key 1 on 12/11/2019
1
-----
Alice retrieved value 2 for key 2 on 12/11/2019
2
-----
Cannot read 1 on 12/11/2019
Testing puts with a unlimited
Bob put value 3 for key 3 on 11/11/2019
Bob put value 4 for key 3 on 11/11/2019
Testing reads with a unlimited
-----
Bob retrieved value 4 for key 3 on 11/11/2019
4
-----
Bob retrieved value 4 for key 3 on 11/11/2019
4
-----
Bob retrieved value 4 for key 3 on 11/11/2019
4
-----
3
*/

import java.util.HashMap;
import java.util.Map;

public class RateLimitedCacheTester {

    private static final String USER1 = "Alice";
    private static final String USER2 = "Bob";
    private static final String DATE1 = "11/11/2019";
    private static final String DATE2 = "12/11/2019";

    public static void main(String[] args) {
        RateLimitedCache<Integer, String> cache = new RateLimitedCache<>();

        System.out.println(cache.size());

        cache.register(USER1, QuotaType.LIMITED);

        System.out.println("Testing puts with a limited quota (maximum 1 per date)");
        cache.put(USER1, DATE1, 1, "1");
        try {
            cache.put(USER1, DATE1, 1, "2");
        } catch (RateLimitedException e) {
            System.out.println("Cannot put 1->\"2\" on  " + DATE1);
        }
        System.out.println("-----");
        System.out.println(cache.get(USER1, DATE1, 1));
        System.out.println("-----");

        System.out.println("Testing reads with a limited quota (maximum 2 per date)");
        cache.put(USER1, DATE2, 2, "2");
        System.out.println("-----");
        System.out.println(cache.get(USER1, DATE2, 1));
        System.out.println("-----");
        System.out.println(cache.get(USER1, DATE2, 2));
        System.out.println("-----");
        try {
            System.out.println(cache.get(USER1, DATE2, 3));
        } catch (RateLimitedException e) {
            System.out.println("Cannot read 1 on " + DATE2);
        }

        cache.register(USER2, QuotaType.UNLIMITED);

        System.out.println("Testing puts with a unlimited");
        cache.put(USER2, DATE1, 3, "3");
        cache.put(USER2, DATE1, 3, "4");

        System.out.println("Testing reads with a unlimited");
        System.out.println("-----");
        System.out.println(cache.get(USER2, DATE1, 3));
        System.out.println("-----");
        System.out.println(cache.get(USER2, DATE1, 3));
        System.out.println("-----");
        System.out.println(cache.get(USER2, DATE1, 3));
        System.out.println("-----");

        System.out.println(cache.size());
    }

}
