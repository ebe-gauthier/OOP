package exo2;

public class ElectronicsItem extends ShoppingItem {
    private int warrantyMonths;

    public ElectronicsItem(String id, String name, String desc, double price, int stock, int warrantyMonths) {
        super(id, name, desc, price, stock);
        this.warrantyMonths = warrantyMonths;
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
            System.out.println("Insufficient stock for " + itemName);
        }
    }

    @Override
    public void generateInvoice(Customer customer) {
        System.out.println("Invoice for: " + customer.getCustomerName());
        System.out.printf("Item: %s | Warranty: %d months | Price: %.2f\n", itemName, warrantyMonths, price);
    }

    @Override
    public boolean validateItem() {
        return stockAvailable > 0;
    }
}

