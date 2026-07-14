// Interface Segregation Principle (ISP)
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