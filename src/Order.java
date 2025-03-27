public class Order {
    private int id;
    private Customer customer;
    private Product[] product;
    private int[] quantities;
    private String orderDate;
    private String status;

    public Order(int id, Customer customer, Product[] products, int[] quantities, String orderDate, String status) {
        this.id = id;
        this.customer = customer;
        this.product = products;
        this.quantities = quantities;
        this.orderDate = orderDate;
        this.status = status;
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
        return product;
    }

    public void setProducts(Product[] products) {
        this.product = products;
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
        for (int i = 0; i < product.length; i++) {
            total = total + product[i].getPrice() * quantities[i];
        }
        return total;
    }

    public double applyDiscount() {
        double total = calculateTotalValue();
        if (customer.isLoyalCustomer()) {
            total *= 0.9;
        }
        return total;
    }
    public void displayDetails() {
        System.out.println("ID: " + id);
        System.out.println("Customer: " + customer.getFirstName());
        System.out.println("Quantity: " + quantities[0]);
        System.out.println("Order Date: " + orderDate);
        System.out.println("Status: " + status);
        System.out.println("Total Value: " + applyDiscount());
    }
}