package exo1;

public class Product {
    private String productId;
    private String productName;
    private String brand;
    private String supplier;
    private int stockQuantity;

    public Product(String id, String name, String brand, String supplier, int stockQuantity) {
        this.productId = id;
        this.productName = name;
        this.brand = brand;
        this.supplier = supplier;
        this.stockQuantity = Math.max(0, stockQuantity);
    }

    public void displayInfo() {
        System.out.printf("Product: %s | Brand: %s | Supplier: %s | Quantity: %d\n",
                productName, brand, supplier, stockQuantity);
    }
}

