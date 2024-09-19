package PrimerosParciales.P1C22022.ej2;

import java.util.function.Predicate;

public class StockResult extends StockProduct{
    private Predicate<Integer> minimumStock;

    public StockResult(String product, int stock, Predicate<Integer> minimumStock){
        super(product, stock);
        this.minimumStock = minimumStock;
    }

    public void setMinimumStock(Predicate<Integer> minimumStock){
        this.minimumStock = minimumStock;
    }

    @Override
    public String toString(){
        return super.toString() + " <> " + (minimumStock.test(getStock()) ? "Low Stock!" : "Stack OK");
    }
}
