package exo2;

import java.time.LocalDate;

public class Payment {
    private String paymentId;
    private String paymentMethod;
    private double amountPaid;
    private LocalDate transactionDate;

    public Payment(String id, String method, double amount) {
        if (!(method.equals("Credit Card") || method.equals("PayPal"))) throw new IllegalArgumentException("Invalid payment method.");
        this.paymentId = id;
        this.paymentMethod = method;
        this.amountPaid = amount;
        this.transactionDate = LocalDate.now();
    }

    public void displayReceipt() {
        System.out.printf("Payment ID: %s | Method: %s | Amount: %.2f | Date: %s\n", paymentId, paymentMethod, amountPaid, transactionDate);
    }
}

