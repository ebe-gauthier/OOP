package exo1;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ElectronicsItem e = new ElectronicsItem("E101", "Laptop", 10, 1200, "TechSupplier", 24, 15);
        e.applyDiscount();
        e.generateStockReport();

        GroceryItem g = new GroceryItem("G101", "Milk", 50, 1.5, "FarmFresh", LocalDate.now().plusDays(2));
        g.generateStockReport();

        FurnitureItem f = new FurnitureItem("F101", "Chair", 20, 45.99, "WoodWorks", 10.5, true);
        f.generateStockReport();

        ClothingItem c = new ClothingItem("C101", "T-Shirt", 100, 15, "ClothMart", new String[]{"S", "M", "L"}, new String[]{"Red", "Blue"}, 10);
        c.generateStockReport();

        PerishableItem p = new PerishableItem("P101", "Banana", 30, 0.5, "TropicalFarms", LocalDate.now().minusDays(1));
        p.generateStockReport();

        sc.close();
    }
}

