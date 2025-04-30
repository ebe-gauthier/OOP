package exo1;

public abstract class StockItem {
    protected String itemId;
    protected String itemName;
    protected int quantityInStock;
    protected double pricePerUnit;
    protected String category;
    protected String supplier;

    public StockItem(String itemId, String itemName, int quantityInStock, double pricePerUnit, String category, String supplier) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.quantityInStock = Math.max(0, quantityInStock); // validation
        this.pricePerUnit = Math.max(0.01, pricePerUnit); // price must be > 0
        this.category = category;
        this.supplier = supplier;
    }

    public abstract void updateStock(int quantity);

    public abstract double calculateStockValue();

    public abstract void generateStockReport();

    public abstract boolean validateStock();
}


