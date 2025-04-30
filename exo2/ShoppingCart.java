package exo2;

import java.util.*;

public class ShoppingCart {
    private String cartId;
    private Map<ShoppingItem, Integer> cartItems = new HashMap<>();
    private Customer customer;

    public ShoppingCart(String id, Customer customer) {
        this.cartId = id;
        this.customer = customer;
    }

    public void addItem(ShoppingItem item, int quantity) {
        cartItems.put(item, cartItems.getOrDefault(item, 0) + quantity);
    }

    public double calculateTotal() {
        double total = 0;
        for (Map.Entry<ShoppingItem, Integer> entry : cartItems.entrySet()) {
            total += entry.getKey().price * entry.getValue();
        }
        return total;
    }

    public void displayCart() {
        System.out.println("Cart for " + customer.getCustomerName());
        for (Map.Entry<ShoppingItem, Integer> entry : cartItems.entrySet()) {
            System.out.printf("%s x%d = %.2f\n", entry.getKey().itemName, entry.getValue(), entry.getKey().price * entry.getValue());
        }
        System.out.printf("Total: %.2f\n", calculateTotal());
    }
}
