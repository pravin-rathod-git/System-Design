/*
 * Open-Closed Principle (OCP)
 * -----------------------------------------
 * Definition:
 * Software entities (classes, modules, functions, etc.)
 * should be OPEN for extension but CLOSED for modification.
 *
 * This means:
 * 1. We should be able to add new functionality without
 *    modifying existing, tested code.
 * 2. We achieve this using interfaces, inheritance,
 *    or composition.
 */

// -------------------------------------------
// Step 1: Create a common interface
// -------------------------------------------
interface Payment {

    // Every payment method must implement this method
    void pay();
}

// -------------------------------------------
// Step 2: Credit Card Payment
// -------------------------------------------
class CreditCardPayment implements Payment {

    @Override
    public void pay() {
        System.out.println("Processing Credit Card Payment...");
    }
}

// -------------------------------------------
// Step 3: UPI Payment
// -------------------------------------------
class UpiPayment implements Payment {

    @Override
    public void pay() {
        System.out.println("Processing UPI Payment...");
    }
}

// -------------------------------------------
// Step 4: PayPal Payment
// -------------------------------------------
class PaypalPayment implements Payment {

    @Override
    public void pay() {
        System.out.println("Processing PayPal Payment...");
    }
}

// -------------------------------------------
// Step 5: New Feature - Crypto Payment
// Notice:
// We only create a new class.
// Existing classes remain unchanged.
// -------------------------------------------
class CryptoPayment implements Payment {

    @Override
    public void pay() {
        System.out.println("Processing Crypto Payment...");
    }
}

// -------------------------------------------
// Step 6: Payment Processor
// This class is CLOSED for modification.
// We never change this class when adding
// new payment methods.
// -------------------------------------------
class PaymentProcessor {

    public void processPayment(Payment payment) {
        payment.pay();
    }
}

// -------------------------------------------
// Main Class
// -------------------------------------------
public class OpenClosedPrinciple {

    public static void main(String[] args) {

        // Create Payment Processor
        PaymentProcessor processor = new PaymentProcessor();

        // Different payment methods
        Payment creditCard = new CreditCardPayment();
        Payment upi = new UpiPayment();
        Payment paypal = new PaypalPayment();
        Payment crypto = new CryptoPayment();

        // Process all payments
        processor.processPayment(creditCard);
        processor.processPayment(upi);
        processor.processPayment(paypal);
        processor.processPayment(crypto);
    }
}