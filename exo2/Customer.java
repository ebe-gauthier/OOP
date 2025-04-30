package exo2;

public class Customer {
    private String customerId;
    private String customerName;
    private String email;
    private String address;
    private String phone;

    public Customer(String id, String name, String email, String address, String phone) {
        if (!email.contains("@")) throw new IllegalArgumentException("Invalid email.");
        if (address.isEmpty()) throw new IllegalArgumentException("Address required.");
        this.customerId = id;
        this.customerName = name;
        this.email = email;
        this.address = address;
        this.phone = phone;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getAddress() {
        return address;
    }
}

