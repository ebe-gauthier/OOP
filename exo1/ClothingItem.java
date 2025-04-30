package exo1;

public class ClothingItem extends StockItem {
    private String[] sizes;
    private String[] colors;
    private double discount;

    public ClothingItem(String itemId, String itemName, int quantity, double price, String supplier, String[] sizes, String[] colors, double discount) {
        super(itemId, itemName, quantity, price, "Clothing", supplier);
        this.sizes = sizes;
        this.colors = colors;
        this.discount = Math.min(discount, 50);
    }

    @Override
    public void updateStock(int quantity) {
        this.quantityInStock += quantity;
    }

    @Override
    public double calculateStockValue() {
        double effectivePrice = pricePerUnit - (pricePerUnit * discount / 100);
        return quantityInStock * effectivePrice;
    }

    @Override
    public void generateStockReport() {
        System.out.println("Clothing Item Report:");
        System.out.printf("Name: %s | Stock: %d | Value: $%.2f | Sizes: %s | Colors: %s\n",
                itemName, quantityInStock, calculateStockValue(), String.join(",", sizes), String.join(",", colors));
    }

    @Override
    public boolean validateStock() {
        return quantityInStock > 0 && sizes.length > 0 && colors.length > 0;
    }
}

