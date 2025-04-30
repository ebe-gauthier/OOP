package exo1;

public class ElectronicsItem extends StockItem{
    private int warrantyMonths;
    private double discountPercentage;

    public ElectronicsItem(String itemId, String itemName, int quantity, double price, String supplier, int warrantyMonths, double discountPercentage) {
        super(itemId, itemName, quantity, price, "Electronics", supplier);
        this.warrantyMonths = Math.max(0, warrantyMonths);
        this.discountPercentage = Math.min(discountPercentage, 50); // Max 50%
    }

    public void applyDiscount() {
        if (discountPercentage > 0) {
            pricePerUnit -= (pricePerUnit * discountPercentage / 100);
        }
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
        System.out.println("Electronics Item Report:");
        System.out.printf("Name: %s | Stock: %d | Value: $%.2f | Warranty: %d months | Discount: %.2f%%\n",
                itemName, quantityInStock, calculateStockValue(), warrantyMonths, discountPercentage);
    }

    @Override
    public boolean validateStock() {
        return quantityInStock > 0;
}
}
