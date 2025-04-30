package exo2;

    import java.time.LocalDate;
import java.util.Scanner;

    public class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            Customer customer = new Customer("C001", "Alice", "alice@mail.com", "Kigali, Rwanda", "0788000000");
            ShoppingCart cart = new ShoppingCart("CART1", customer);

            ElectronicsItem laptop = new ElectronicsItem("E001", "HP Laptop", "14-inch", 750.0, 10, 24);
            ClothingItem jacket = new ClothingItem("C001", "Leather Jacket", "Winter Wear", 120.0, 15, "L", true);
            GroceriesItem milk = new GroceriesItem("G001", "Fresh Milk", "1L Bottle", 1.2, 50, LocalDate.now().plusDays(3));

            // Add items
            laptop.addToCart(customer, cart, 1);
            jacket.addToCart(customer, cart, 2);
            milk.addToCart(customer, cart, 12);

            cart.displayCart();

            // Payment
            double total = cart.calculateTotal();
            System.out.println("Enter payment method (Credit Card / PayPal): ");
            String method = sc.nextLine();

            Payment payment = new Payment("P001", method, total);
            payment.displayReceipt();

            // Invoice
            System.out.println("--- Invoice ---");
            laptop.generateInvoice(customer);
            jacket.generateInvoice(customer);
            milk.generateInvoice(customer);

            sc.close();
        }
    }


