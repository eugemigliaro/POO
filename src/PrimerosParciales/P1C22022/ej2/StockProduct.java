package PrimerosParciales.P1C22022.ej2;

/* Se desea conocer información sobre el stock de los productos de un almacén.
Ya cuenta con la implementación de la clase StockProduct (que no puede modificarse)
que modela a un producto del almacén (a partir de su nombre),
acompañado del stock actual del mismo (que es un valor entero no negativo).

Se desea modelar un inventario de los productos del almacén que permita agregar productos con sus stock actuales,
poder decrementar en uno el stock a partir de su nombre y definir una condición de alerta de bajo stock para todos los productos del inventario.
De esta forma se pueden consultar todos los productos agregados al inventario teniendo en cuenta si el stock actual cumple o no con esa condición.
Al crear un inventario, la condición de alerta de bajo stock consiste en tener 1 o menos unidades.
Implementar StockInventory, StockResult y todo lo necesario para que, con el siguiente programa de prueba, se obtenga la salida indicada en los comentarios:
*/

public class StockProduct {
    private final String product;
    private int stock;

    public StockProduct(String product, int stock){
        if(stock < 0){
            throw new java.lang.IllegalArgumentException("Stock cannot be negative.");
        }
        this.product = product;
        this.stock = stock;
    }

    public String getProduct(){
        return product;
    }

    public int getStock(){
        return stock;
    }

    public void reduceStock(){
        if(getStock() == 0){
            throw new java.lang.IllegalStateException("No stock to reduce.");
        }
        stock--;
    }

    @Override
    public String toString(){
        return String.format("Product %s has %s units", getProduct(), getStock());
    }
}
