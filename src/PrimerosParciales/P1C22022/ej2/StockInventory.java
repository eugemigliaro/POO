package PrimerosParciales.P1C22022.ej2;

import java.util.Iterator;
import java.util.function.Predicate;

public class StockInventory implements Iterable<StockResult> {
    private StockResult[] products;
    private int dim;
    private int size;
    private static final int BLOCK_SIZE = 10;
    private Predicate<Integer> minimumStock;

    public StockInventory() {
        products = new StockResult[BLOCK_SIZE];
        dim = BLOCK_SIZE;
        size = 0;
        minimumStock = (stock) -> stock <= 1;
    }

    public void add(String product, int stock) {
        if (size == dim) {
            StockResult[] newArray = new StockResult[dim + BLOCK_SIZE];
            System.arraycopy(products, 0, newArray, 0, dim);
            this.products = newArray;
            this.dim += BLOCK_SIZE;
        }
        products[size] = new StockResult(product, stock, this.minimumStock);
        size++;
    }

    public void reduceStock(String product) {

        for(int i = 0; i < size; i++){
            if(products[i].getProduct().equals(product)){
                products[i].reduceStock();
                return;
            }
        }

        throw new java.lang.IllegalStateException("No product found with name " + product);
    }

    public void setMinimumStock(Predicate<Integer> newMinimumStock){
        this.minimumStock = newMinimumStock;
        for(int i = 0; i < size; i++){
            products[i].setMinimumStock(newMinimumStock);
        }
    }

    public Iterator<StockResult> iterator(){

        Iterator<StockResult> it = new Iterator<>() {
            private int pos = 0;
            private Predicate<Integer> currentMinimumStock = minimumStock;

            @Override
            public boolean hasNext(){
                return pos < size;
            }

            @Override
            public StockResult next(){
                if(!hasNext()){
                    throw new java.util.NoSuchElementException();
                }
                StockResult currentProduct = products[pos++];
                currentProduct.setMinimumStock(currentMinimumStock);
                return currentProduct;
            }
        };

        return it;
    }
}
