package exo1;

public class FurnitureItem extends StockItem {
    private double weight;
    private boolean isPacked;

    public FurnitureItem(String itemId, String itemName, int quantity, double price, String supplier, double weight, boolean isPacked) {
        super(itemId, itemName, quantity, price, "Furniture", supplier);
        this.weight = weight;
        this.isPacked = isPacked;
    }

    @Override
    public void updateStock(int quantity) {
        this.quantityInStock += quantity;
    }

    @Override
    public double calculateStockValue() {
        return quantityInStock * pricePerUnit;
    }

    @Override
    public void generateStockReport() {
        System.out.println("Furniture Item Report:");
        System.out.printf("Name: %s | Stock: %d | Value: $%.2f | Weight: %.2fkg | Packed: %b\n",
                itemName, quantityInStock, calculateStockValue(), weight, isPacked);
    }

    @Override
    public boolean validateStock() {
        return isPacked;
    }
}

