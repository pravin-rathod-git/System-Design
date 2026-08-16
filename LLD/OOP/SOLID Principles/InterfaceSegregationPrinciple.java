// Interface Segregation Principle (ISP)
/*Interface Segregation Principle (ISP)

The Interface Segregation Principle (ISP) is the “I” in SOLID. It states that:

A class should not be forced to implement interfaces that it does not use.

In simple terms, instead of creating one large interface containing many unrelated methods, we should create smaller, more specific interfaces that contain only the methods required by their implementing classes.

Key Idea

Interfaces should be:

Small and focused
Specific to a particular responsibility
Easy for implementing classes to use
Free from unnecessary methods*/
// "Clients should not be forced to depend on interfaces they do not use."

// Small interface for printing
interface Printable {
    void print();
}

// Small interface for scanning
interface Scannable {
    void scan();
}

// Small interface for faxing
interface Faxable {
    void fax();
}

// Basic Printer supports only printing
class BasicPrinter implements Printable {

    @Override
    public void print() {
        System.out.println("Basic Printer: Printing document...");
    }
}

// Advanced Printer supports all features
class AdvancedPrinter implements Printable, Scannable, Faxable {

    @Override
    public void print() {
        System.out.println("Advanced Printer: Printing document...");
    }

    @Override
    public void scan() {
        System.out.println("Advanced Printer: Scanning document...");
    }

    @Override
    public void fax() {
        System.out.println("Advanced Printer: Faxing document...");
    }
}

// Main class
public class InterfaceSegregationPrinciple {

    public static void main(String[] args) {

        // Basic Printer
        Printable basicPrinter = new BasicPrinter();
        basicPrinter.print();

        System.out.println();

        // Advanced Printer
        AdvancedPrinter advancedPrinter = new AdvancedPrinter();
        advancedPrinter.print();
        advancedPrinter.scan();
        advancedPrinter.fax();
    }
}
