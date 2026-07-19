// ============================================================================
// Product Family 1 - Burger
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
// Product Family 2 - Garlic Bread
// ============================================================================

/**
 * Common interface for all Garlic Bread types.
 */
interface GarlicBread {

    /**
     * Prepares the garlic bread.
     */
    void prepare();
}

// ============================================================================
// Regular Garlic Bread Implementations
// ============================================================================

/**
 * Represents a Basic Garlic Bread.
 */
class BasicGarlicBread implements GarlicBread {

    @Override
    public void prepare() {
        System.out.println("Preparing Basic Garlic Bread with butter and garlic!");
    }
}

/**
 * Represents a Cheese Garlic Bread.
 */
class CheeseGarlicBread implements GarlicBread {

    @Override
    public void prepare() {
        System.out.println("Preparing Cheese Garlic Bread with extra cheese and butter!");
    }
}

// ============================================================================
// Wheat Garlic Bread Implementations
// ============================================================================

/**
 * Represents a Basic Wheat Garlic Bread.
 */
class BasicWheatGarlicBread implements GarlicBread {

    @Override
    public void prepare() {
        System.out.println("Preparing Basic Wheat Garlic Bread with butter and garlic!");
    }
}

/**
 * Represents a Cheese Wheat Garlic Bread.
 */
class CheeseWheatGarlicBread implements GarlicBread {

    @Override
    public void prepare() {
        System.out.println("Preparing Cheese Wheat Garlic Bread with extra cheese and butter!");
    }
}

// ============================================================================
// Abstract Factory
// ============================================================================

/**
 * Defines methods for creating a family of related food items.
 */
interface MealFactory {

    /**
     * Creates a Burger.
     *
     * @param type Type of burger.
     * @return Burger object.
     */
    Burger createBurger(String type);

    /**
     * Creates Garlic Bread.
     *
     * @param type Type of garlic bread.
     * @return GarlicBread object.
     */
    GarlicBread createGarlicBread(String type);
}

// ============================================================================
// Concrete Factory - Singh Burger
// ============================================================================

/**
 * Creates the regular meal family.
 */
class SinghBurger implements MealFactory {

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

    @Override
    public GarlicBread createGarlicBread(String type) {

        if (type.equalsIgnoreCase("basic")) {
            return new BasicGarlicBread();
        }

        if (type.equalsIgnoreCase("cheese")) {
            return new CheeseGarlicBread();
        }

        System.out.println("Invalid Garlic Bread type!");
        return null;
    }
}

// ============================================================================
// Concrete Factory - King Burger
// ============================================================================

/**
 * Creates the wheat meal family.
 */
class KingBurger implements MealFactory {

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

    @Override
    public GarlicBread createGarlicBread(String type) {

        if (type.equalsIgnoreCase("basic")) {
            return new BasicWheatGarlicBread();
        }

        if (type.equalsIgnoreCase("cheese")) {
            return new CheeseWheatGarlicBread();
        }

        System.out.println("Invalid Garlic Bread type!");
        return null;
    }
}

// ============================================================================
// Client
// ============================================================================

/**
 * Demonstrates the Abstract Factory Design Pattern.
 */
public class AbstractFactory {

    public static void main(String[] args) {

        // Select the required meal family.
        MealFactory mealFactory = new SinghBurger();

        // Request the required products from the selected factory.
        Burger burger = mealFactory.createBurger("basic");
        GarlicBread garlicBread = mealFactory.createGarlicBread("cheese");

        // Prepare the ordered meal.
        if (burger != null) {
            burger.prepare();
        }

        if (garlicBread != null) {
            garlicBread.prepare();
        }
    }
}