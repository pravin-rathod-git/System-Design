// ============================================================================
// Product Interface - Button
// ============================================================================

/**
 * Common interface for all Button implementations.
 */
interface Button {
    void render();
}

// ============================================================================
// Product Interface - Checkbox
// ============================================================================

/**
 * Common interface for all Checkbox implementations.
 */
interface Checkbox {
    void render();
}

// ============================================================================
// Product Interface - TextField
// ============================================================================

/**
 * Common interface for all TextField implementations.
 */
interface TextField {
    void render();
}

// ============================================================================
// Windows Products
// ============================================================================

/**
 * Windows implementation of Button.
 */
class WindowsButton implements Button {

    @Override
    public void render() {
        System.out.println("Rendering Windows Button");
    }
}

/**
 * Windows implementation of Checkbox.
 */
class WindowsCheckbox implements Checkbox {

    @Override
    public void render() {
        System.out.println("Rendering Windows Checkbox");
    }
}

/**
 * Windows implementation of TextField.
 */
class WindowsTextField implements TextField {

    @Override
    public void render() {
        System.out.println("Rendering Windows TextField");
    }
}

// ============================================================================
// Mac Products
// ============================================================================

/**
 * macOS implementation of Button.
 */
class MacButton implements Button {

    @Override
    public void render() {
        System.out.println("Rendering Mac Button");
    }
}

/**
 * macOS implementation of Checkbox.
 */
class MacCheckbox implements Checkbox {

    @Override
    public void render() {
        System.out.println("Rendering Mac Checkbox");
    }
}

/**
 * macOS implementation of TextField.
 */
class MacTextField implements TextField {

    @Override
    public void render() {
        System.out.println("Rendering Mac TextField");
    }
}

// ============================================================================
// Abstract Factory
// ============================================================================

/**
 * Factory interface responsible for creating
 * a family of related UI components.
 */
interface GUIFactory {

    Button createButton();

    Checkbox createCheckbox();

    TextField createTextField();
}

// ============================================================================
// Windows Factory
// ============================================================================

/**
 * Creates Windows UI components.
 */
class WindowsFactory implements GUIFactory {

    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }

    @Override
    public TextField createTextField() {
        return new WindowsTextField();
    }
}

// ============================================================================
// Mac Factory
// ============================================================================

/**
 * Creates macOS UI components.
 */
class MacFactory implements GUIFactory {

    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacCheckbox();
    }

    @Override
    public TextField createTextField() {
        return new MacTextField();
    }
}

// ============================================================================
// Client
// ============================================================================

/**
 * Demonstrates the Abstract Factory Design Pattern.
 */
public class AbstractFactoryExample {

    public static void main(String[] args) {

        // Choose the required factory.
        GUIFactory factory = new WindowsFactory();

        // Create related UI components.
        Button button = factory.createButton();
        Checkbox checkbox = factory.createCheckbox();
        TextField textField = factory.createTextField();

        // Render the components.
        button.render();
        checkbox.render();
        textField.render();

        System.out.println();

        // Switch to macOS by changing only the factory.
        factory = new MacFactory();

        button = factory.createButton();
        checkbox = factory.createCheckbox();
        textField = factory.createTextField();

        button.render();
        checkbox.render();
        textField.render();
    }
}