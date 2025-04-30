package exo2;

public class ClothingItem extends ShoppingItem {
    private String size;
    private boolean seasonalDiscount;

    public ClothingItem(String id, String name, String desc, double price, int stock, String size, boolean seasonalDiscount) {
        super(id, name, desc, price, stock);
        this.size = size;
        this.seasonalDiscount = seasonalDiscount;
    }

    @Override
    public void updateStock(int quantity) {
        stockAvailable -= quantity;
    }

    @Override
    public void addToCart(Customer customer, ShoppingCart cart, int quantity) {
        if (quantity <= stockAvailable) {
            if (seasonalDiscount) price *= 0.90; // 10% off
            cart.addItem(this, quantity);
            updateStock(quantity);
        } else {
            System.out.println("Insufficient stock for clothing item.");
        }
    }

    @Override
    public void generateInvoice(Customer customer) {
        System.out.println("Invoice for: " + customer.getCustomerName());
        System.out.printf("Item: %s | Size: %s | Price: %.2f\n", itemName, size, price);
    }

    @Override
    public boolean validateItem() {
        return stockAvailable > 0 && size != null;
    }
}

