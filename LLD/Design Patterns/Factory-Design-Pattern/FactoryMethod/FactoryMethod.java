// ============================================================================
// Product Interface
// ============================================================================

/**
 * Common interface for all burger types.
 */
interface Burger {

    /**
     * Prepares the burger.
     */
    void prepare();
}

// ============================================================================
// Regular Burger Implementations
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

/**
 * Represents a Standard Burger.
 */
class StandardBurger implements Burger {

    @Override
    public void prepare() {
        System.out.println("Preparing Standard Burger with bun, patty, cheese, and lettuce!");
    }
}

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
// Wheat Burger Implementations
// ============================================================================

/**
 * Represents a Basic Wheat Burger.
 */
class BasicWheatBurger implements Burger {

    @Override
    public void prepare() {
        System.out.println("Preparing Basic Wheat Burger with bun, patty, and ketchup!");
    }
}

/**
 * Represents a Standard Wheat Burger.
 */
class StandardWheatBurger implements Burger {

    @Override
    public void prepare() {
        System.out.println("Preparing Standard Wheat Burger with bun, patty, cheese, and lettuce!");
    }
}

/**
 * Represents a Premium Wheat Burger.
 */
class PremiumWheatBurger implements Burger {

    @Override
    public void prepare() {
        System.out.println("Preparing Premium Wheat Burger with gourmet bun, premium patty, cheese, lettuce, and secret sauce!");
    }
}

// ============================================================================
// Factory Interface
// ============================================================================

/**
 * Defines the method that every concrete burger factory must implement.
 */
interface BurgerFactory {

    /**
     * Creates and returns a Burger object.
     *
     * @param type Type of burger to create.
     * @return Burger object if the type is valid, otherwise null.
     */
    Burger createBurger(String type);
}

// ============================================================================
// Concrete Factory - Singh Burger
// ============================================================================

/**
 * Factory responsible for creating regular burgers.
 */
class SinghBurger implements BurgerFactory {

    @Override
    public Burger createBurger(String type) {

        if (type.equalsIgnoreCase("basic")) {
            return new BasicBurger();
        }

        if (type.equalsIgnoreCase("standard")) {
            return new StandardBurger();
        }

        if (type.equalsIgnoreCase("premium")) {
            return new PremiumBurger();
        }

        System.out.println("Invalid burger type!");
        return null;
    }
}

// ============================================================================
// Concrete Factory - King Burger
// ============================================================================

/**
 * Factory responsible for creating wheat burgers.
 */
class KingBurger implements BurgerFactory {

    @Override
    public Burger createBurger(String type) {

        if (type.equalsIgnoreCase("basic")) {
            return new BasicWheatBurger();
        }

        if (type.equalsIgnoreCase("standard")) {
            return new StandardWheatBurger();
        }

        if (type.equalsIgnoreCase("premium")) {
            return new PremiumWheatBurger();
        }

        System.out.println("Invalid burger type!");
        return null;
    }
}

// ============================================================================
// Client
// ============================================================================

/**
 * Demonstrates the Factory Method Design Pattern.
 */
public class FactoryMethod {

    public static void main(String[] args) {

        // Select the factory from which burgers will be created.
        BurgerFactory burgerFactory = new SinghBurger();

        // Request a burger from the selected factory.
        Burger burger = burgerFactory.createBurger("basic");

        // Prepare the burger if a valid object is returned.
        if (burger != null) {
            burger.prepare();
        }
    }
}