package exo2;

import java.time.LocalDate;

public class GroceriesItem extends ShoppingItem {
    private LocalDate expirationDate;

    public GroceriesItem(String id, String name, String desc, double price, int stock, LocalDate expirationDate) {
        super(id, name, desc, price, stock);
        this.expirationDate = expirationDate;
    }

    @Override
    public void updateStock(int quantity) {
        stockAvailable -= quantity;
    }

    @Override
    public void addToCart(Customer customer, ShoppingCart cart, int quantity) {
        if (quantity <= stockAvailable && !expirationDate.isBefore(LocalDate.now())) {
            if (quantity >= 10) price *= 0.95; // 5% bulk discount
            cart.addItem(this, quantity);
            updateStock(quantity);
        } else {
            System.out.println("Invalid or expired grocery item.");
        }
    }

    @Override
    public void generateInvoice(Customer customer) {
        System.out.println("Invoice for: " + customer.getCustomerName());
        System.out.printf("Grocery Item: %s | Expiry: %s | Price: %.2f\n", itemName, expirationDate, price);
    }

    @Override
    public boolean validateItem() {
        return !expirationDate.isBefore(LocalDate.now());
    }
}
