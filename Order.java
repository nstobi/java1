package coursework;

import java.util.ArrayList;

public class Order {
    private static int idCounter = 1;
    private int orderId;
    private String customerName;
    private String shippingAddress;
    private ArrayList<Product> products;

    public Order(String customerName, String shippingAddress) {
        this.orderId = idCounter++;
        this.customerName = customerName;
        this.shippingAddress = shippingAddress;
        this.products = new ArrayList<>();
    }

    public int getOrderId() {
        return orderId;
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public void displayOrder() {
        System.out.printf("Order ID: %d\nCustomer: %s\nAddress: %s\n", orderId, customerName, shippingAddress);
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            product.display();
        }
    }
    
}
