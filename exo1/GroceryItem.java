package exo1;

import java.time.LocalDate;

public class GroceryItem extends StockItem {
    private LocalDate expirationDate;

    public GroceryItem(String itemId, String itemName, int quantity, double price, String supplier, LocalDate expirationDate) {
        super(itemId, itemName, quantity, price, "Groceries", supplier);
        this.expirationDate = expirationDate;
    }

    public boolean isNearExpiration() {
        return expirationDate.isBefore(LocalDate.now().plusDays(5));
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
        System.out.println("Grocery Item Report:");
        System.out.printf("Name: %s | Stock: %d | Value: $%.2f | Expiration: %s | Near Expiry: %b\n",
                itemName, quantityInStock, calculateStockValue(), expirationDate, isNearExpiration());
    }

    @Override
    public boolean validateStock() {
        return !expirationDate.isBefore(LocalDate.now());
    }
}

