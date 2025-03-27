import java.util.ArrayList;

public class ComputerStore {
    private ArrayList<Product> products = new ArrayList<>();
    private ArrayList<Customer> customers = new ArrayList<>();
    private ArrayList<Order> orders = new ArrayList<>();
    private int productCount;
    private int customerCount;
    private int orderCount;

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public void addCustomer(Customer customer) {
        this.customers.add(customer);
    }

    public Order createOrder(Customer customer, Product[] products, int[] quantities) {
        Order newOrder = new Order(orders.size() + 1, customer, products, quantities, "2025-03-21", "New");
        orders.add(newOrder);
        return newOrder;
    }

    public void updateStockAfterOrder(Order order) {
        Product[] product = order.getProducts();
        int[] quantities = order.getQuantities();
        for (int i = 0; i < product.length; i++) {
            product[i].setStockQuantity(product[i].getStockQuantity()-quantities[i]);
        }
    }

    public void changeOrderStatus(int orderId, String newStatus) {
        for (Order order : orders) {
            if (order.getId() == orderId) {
                order.setStatus(newStatus);
                return;
            }
        }
        System.out.println("Order not found.");
    }


    public void displayProductsInCategory(String category) {
        for (Product product : products) {
            if (product.getCategory().equals(category)) {
                System.out.println(product);
            }
        }
    }

    public void displayCustomerOrders(int customerId) {
        for (Order order : orders) {
            if (order.getCustomer().getId() == customerId) {
                order.displayDetails();
            }
        }
    }
}