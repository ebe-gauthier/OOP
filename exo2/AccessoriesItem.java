package exo2;

public class AccessoriesItem extends ShoppingItem {
    private String[] reviews;

    public AccessoriesItem(String id, String name, String desc, double price, int stock, String[] reviews) {
        super(id, name, desc, price, stock);
        this.reviews = reviews;
    }

    @Override
    public void updateStock(int quantity) {
        stockAvailable -= quantity;
    }

    @Override
    public void addToCart(Customer customer, ShoppingCart cart, int quantity) {
        if (quantity <= stockAvailable) {
            cart.addItem(this, quantity);
            updateStock(quantity);
        } else {
            System.out.println("Not enough accessories available.");
        }
    }

    @Override
    public void generateInvoice(Customer customer) {
        System.out.printf("Accessory: %s | Price: %.2f\n", itemName, price);
        System.out.println("Customer Reviews:");
        for (String r : reviews) System.out.println("- " + r);
    }

    @Override
    public boolean validateItem() {
        return stockAvailable > 0;
    }
}
