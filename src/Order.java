public class Order {
    private int id;
    private Customer customer;
    private Product[] products;
    private int[] quantities;
    private String orderDate;
    private String status;

    public Order(int id, Customer customer, Product[] products, int[] quantities, String orderDate, String status) {
        this.id = id;
        this.customer = customer;
        this.products = products;
        this.quantities = quantities;
        this.orderDate = orderDate;
        this.status = "In Progress";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Product[] getProducts() {
        return products;
    }

    public void setProducts(Product[] products) {
        this.products = products;
    }

    public int[] getQuantities() {
        return quantities;
    }

    public void setQuantities(int[] quantities) {
        this.quantities = quantities;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double calculateTotalValue() {
        double total = 0;
        for (int i = 0; i < products.length; i++) {
            total += products[i].getPrice() * quantities[i];
        }
        return total;
    }
    public void applyDiscount() {
        if (customer.isLoyalCustomer()) {
            double discount = calculateTotalValue() * 0.10;
        }
    }

public void displayDetails() {
    System.out.println("Order ID: " + id);
    System.out.println("Customer: " + customer.getFirstName() + " " + customer.getLastName());
    System.out.println("Order Date: " + orderDate);
    System.out.println("Status: " + status);
    System.out.println("Products:");
    for (int i = 0; i < products.length; i++) {
        System.out.println("- " + products[i].getName() + " (Quantity: " + quantities[i] + ")");
    }
    System.out.println("Total Value: " + calculateTotalValue());
  }
}