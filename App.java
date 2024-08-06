package coursework;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    private static final int EXIT = 0;
    private static ArrayList<Order> orderHistory = new ArrayList<>();
    private static OrderQueue orderQueue = new OrderQueue();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Product> products = initProducts();
        while (mainMenu(products) != EXIT) ;
        sc.close();
    }

    private static int mainMenu(ArrayList<Product> products) {
        System.out.println("\t**************************");
        System.out.println("\tWelcome to the online book store");
        System.out.println("\t1. Product List");
        System.out.println("\t2. My Orders");
        System.out.printf("\t%d. Exit\n", EXIT);
        System.out.print("\tPlease choose an option: ");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                printProducts(products);
                while (subMenuProducts(products) != EXIT) ;
                break;
            case 2:
                displayOrders();
                break;
            case EXIT:
                System.out.println("Exit");
                break;
            default:
                System.out.println("Invalid option");
                break;
        }
        return choice;
    }

    private static int subMenuProducts(ArrayList<Product> products) {
        System.out.println("\t1. Sort Products");
        System.out.println("\t2. Search Order");
        System.out.println("\t3. Place Order");
        System.out.printf("\t%d. Back to main menu\n", EXIT);
        System.out.print("\tPlease choose an option: ");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                sortMenu(products);
                break;
            case 2:
                searchOrder();
                break;
            case 3:
                placeOrder(products);
                break;
            default:
                break;
        }
        return choice;
    }

    private static void sortMenu(ArrayList<Product> products) {
        System.out.println("\t1. Sort by Name");
        System.out.println("\t2. Sort by Price");
        System.out.println("\t3. Sort by Author");
        System.out.printf("\t%d. Back\n", EXIT);
        System.out.print("\tPlease choose a sorting option: ");
        int sortChoice = sc.nextInt();
        switch (sortChoice) {
            case 1:
                SortUtil.sortByName(products);
                printProducts(products);
                break;
            case 2:
                SortUtil.sortByPrice(products);
                printProducts(products);
                break;
            case 3:
                SortUtil.sortByAuthor(products);
                printProducts(products);
                break;
            case EXIT:
                break;
            default:
                System.out.println("Invalid sorting option");
                break;
        }
    }

    private static void printProducts(ArrayList<Product> products) {
        for (Product product : products) {
            product.display();
        }
    }

    private static ArrayList<Product> initProducts() {
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product("Wuthering Heights", 1300, 5, "Emily Brontë"));
        products.add(new Product("Don Quixote", 1500, 3, "Miguel de Cervantes"));
        products.add(new Product("Broken Glass", 1000, 10, "Alain Mabanckou"));
        products.add(new Product("Middlemarch", 1100, 7, "George Eliot"));
        products.add(new Product("To Kill a Mockingbird", 1700, 6, "Harper Lee"));
        return products;
    }
    private static void placeOrder(ArrayList<Product> products) {
        System.out.print("Enter your name: ");
        String name = sc.next();
        sc.nextLine(); 
        System.out.print("Enter your shipping address: ");
        String address = sc.nextLine();

        Order order = new Order(name, address);
        printProducts(products);

        while (true) {
            System.out.print("Enter the product ID to add to your order (or 0 to finish): ");
            int productId = sc.nextInt();
            if (productId == 0) break;

            Product selectedProduct = null;
            for (Product product : products) {
                if (product.getId() == productId) {
                    selectedProduct = product;
                    break;
                }
            }

            if (selectedProduct != null) {
                order.addProduct(selectedProduct);
            } else {
                System.out.println("Invalid product ID. Please try again.");
            }
        }

        orderQueue.offer(order);
        orderHistory.add(order);
        System.out.println("Order placed successfully!");
    }

    private static void displayOrders() {
        if (orderQueue.isEmpty()) {
            System.out.println("No orders in the queue.");
            return;
        }

        System.out.println("Orders in the queue:");
        for (Order order : orderHistory) {
            order.displayOrder();
        }
    }

    private static void searchOrder() {
        System.out.print("Enter the order ID to search: ");
        int orderId = sc.nextInt();
        Order order = SearchUtil.linearSearch(orderHistory, orderId);

        if (order != null) {
            order.displayOrder();
        } else {
            System.out.println("Order not found.");
        }
    }
}
