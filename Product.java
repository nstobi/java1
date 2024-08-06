package coursework;

public class Product {
    private int id;
    private String name;
    private double price;
    private int quantity;
    private String author;

    private static int idCounter = 0;

    public Product(String name, double price, int quantity, String author) {
        this.id = ++idCounter;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getAuthor() {
        return author;
    }

    public void display() {
        System.out.printf("ID: %-4d | Name: %-30s | Price: %-7.2f | Quantity: %-4d | Author: %-20s\n", id, name, price, quantity, author);
    }
}
