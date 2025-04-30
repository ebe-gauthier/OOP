package exo1;

import java.time.LocalDate;

public class PerishableItem extends StockItem {
    private LocalDate expirationDate;

    public PerishableItem(String itemId, String itemName, int quantity, double price, String supplier, LocalDate expirationDate) {
        super(itemId, itemName, quantity, price, "Perishable", supplier);
        this.expirationDate = expirationDate;
    }

    public boolean needsDisposal() {
        return expirationDate.isBefore(LocalDate.now());
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
        System.out.println("Perishable Item Report:");
        System.out.printf("Name: %s | Stock: %d | Value: $%.2f | Expired: %b\n",
                itemName, quantityInStock, calculateStockValue(), needsDisposal());
    }

    @Override
    public boolean validateStock() {
        return !needsDisposal();
    }
}
