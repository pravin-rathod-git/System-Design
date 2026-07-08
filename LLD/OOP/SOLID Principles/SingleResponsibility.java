import java.util.*;

// Represents a single product
class Product {

    // Product name
    public String name;

    // Product price
    public double price;

    // Constructor to initialize product details
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

// Responsible only for managing shopping cart operations
class ShoppingCart {

    // List to store all products in the cart
    private List<Product> products = new ArrayList<>();

    // Adds a product to the cart
    public void addProduct(Product p) {
        products.add(p);
    }

    // Returns all products present in the cart
    public List<Product> getProducts() {
        return products;
    }

    // Calculates the total price of all products
    public double calculateTotal() {

        double total = 0;

        // Iterate through each product and add its price
        for (Product p : products) {
            total += p.price;
        }

        return total;
    }
}

// Responsible only for printing the shopping cart invoice
class ShoppingCartPrinter {

    // Reference to the shopping cart
    private ShoppingCart cart;

    // Constructor
    public ShoppingCartPrinter(ShoppingCart cart) {
        this.cart = cart;
    }

    // Prints all products and total amount
    public void printInvoice() {

        System.out.println("Shopping Cart Invoice:");

        // Display each product with its price
        for (Product p : cart.getProducts()) {
            System.out.println(p.name + " - Rs " + p.price);
        }

        // Display total cart value
        System.out.println("Total: Rs " + cart.calculateTotal());
    }
}

// Responsible only for storing the shopping cart
class ShoppingCartStorage {

    // Reference to the shopping cart
    private ShoppingCart cart;

    // Constructor
    public ShoppingCartStorage(ShoppingCart cart) {
        this.cart = cart;
    }

    // Simulates saving the cart to a database
    public void saveToDatabase() {
        System.out.println("Saving shopping cart to database...");
    }
}

// Driver class
public class SingleResponsibility {

    public static void main(String[] args) {

        // Create a new shopping cart
        ShoppingCart cart = new ShoppingCart();

        // Add products to the cart
        cart.addProduct(new Product("Laptop", 50000));
        cart.addProduct(new Product("Mouse", 2000));

        // Print the shopping cart invoice
        ShoppingCartPrinter printer = new ShoppingCartPrinter(cart);
        printer.printInvoice();

        // Save the shopping cart to the database
        ShoppingCartStorage db = new ShoppingCartStorage(cart);
        db.saveToDatabase();
    }
}