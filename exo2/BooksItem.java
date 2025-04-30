package exo2;

public class BooksItem extends ShoppingItem {
    private String isbn;

    public BooksItem(String id, String name, String desc, double price, int stock, String isbn) {
        super(id, name, desc, price, stock);
        this.isbn = isbn;
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
            System.out.println("Not enough copies available.");
        }
    }

    @Override
    public void generateInvoice(Customer customer) {
        System.out.printf("Book: %s | ISBN: %s | Price: %.2f\n", itemName, isbn, price);
    }

    @Override
    public boolean validateItem() {
        return stockAvailable > 0 && isbn != null;
    }
}
