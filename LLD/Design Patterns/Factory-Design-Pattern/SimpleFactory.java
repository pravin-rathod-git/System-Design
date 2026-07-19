// ============================================================================
// Burger Interface
// ============================================================================

/**
 * Common interface for all burger types.
 * Every burger must provide its own implementation of the prepare() method.
 */
interface Burger {

    /**
     * Prepares the burger.
     */
    void prepare();
}

// ============================================================================
// Concrete Product - Basic Burger
// ============================================================================

/**
 * Represents a Basic Burger.
 */
class BasicBurger implements Burger {

    @Override
    public void prepare() {
        System.out.println("Preparing Basic Burger with bun, patty, and ketchup!");
    }
}

// ============================================================================
// Concrete Product - Standard Burger
// ============================================================================

/**
 * Represents a Standard Burger.
 */
class StandardBurger implements Burger {

    @Override
    public void prepare() {
        System.out.println("Preparing Standard Burger with bun, patty, cheese, and lettuce!");
    }
}

// ============================================================================
// Concrete Product - Premium Burger
// ============================================================================

/**
 * Represents a Premium Burger.
 */
class PremiumBurger implements Burger {

    @Override
    public void prepare() {
        System.out.println("Preparing Premium Burger with gourmet bun, premium patty, cheese, lettuce, and secret sauce!");
    }
}

// ============================================================================
// Factory Class
// ============================================================================

/**
 * Factory class responsible for creating Burger objects.
 *
 * The client requests a burger from this factory instead of creating
 * BasicBurger, StandardBurger, or PremiumBurger directly.
 */
class BurgerFactory {

    /**
     * Creates and returns the appropriate Burger object
     * based on the provided burger type.
     *
     * @param type Type of burger to create.
     * @return Burger object if the type is valid, otherwise null.
     */
    public Burger createBurger(String type) {

        // Return null if the provided type is null.
        if (type == null) {
            return null;
        }

        // Create and return a Basic Burger.
        if (type.equalsIgnoreCase("basic")) {
            return new BasicBurger();
        }

        // Create and return a Standard Burger.
        if (type.equalsIgnoreCase("standard")) {
            return new StandardBurger();
        }

        // Create and return a Premium Burger.
        if (type.equalsIgnoreCase("premium")) {
            return new PremiumBurger();
        }

        // Display a message if the burger type is not supported.
        System.out.println("Invalid burger type!");

        return null;
    }
}

// ============================================================================
// Client
// ============================================================================

/**
 * Demonstrates the Simple Factory Design Pattern.
 */
public class SimpleFactory {

    public static void main(String[] args) {

        // The type of burger requested by the customer.
        String type = "standard";

        // Create the factory object.
        BurgerFactory burgerFactory = new BurgerFactory();

        // Request a burger from the factory.
        Burger burger = burgerFactory.createBurger(type);

        // Prepare the burger only if a valid object is returned.
        if (burger != null) {
            burger.prepare();
        }
    }
}