// ==========================================================
// Strategy Design Pattern Example
//
// Scenario:
// A payment application supports multiple payment methods.
// Instead of using large if-else statements, each payment
// method is implemented as a separate strategy.
// ==========================================================


// ----------------------------------------------------------
// Step 1: Strategy Interface
// ----------------------------------------------------------

// This interface defines the common behavior for all
// payment strategies.
interface PaymentStrategy {

    // Every payment method must implement this method.
    void pay(int amount);
}


// ----------------------------------------------------------
// Step 2: Concrete Strategy - Credit Card Payment
// ----------------------------------------------------------

class CreditCardPayment implements PaymentStrategy {

    @Override
    public void pay(int amount) {
        System.out.println("Paid ₹" + amount + " using Credit Card.");
    }
}


// ----------------------------------------------------------
// Step 3: Concrete Strategy - UPI Payment
// ----------------------------------------------------------

class UPIPayment implements PaymentStrategy {

    @Override
    public void pay(int amount) {
        System.out.println("Paid ₹" + amount + " using UPI.");
    }
}


// ----------------------------------------------------------
// Step 4: Concrete Strategy - PayPal Payment
// ----------------------------------------------------------

class PayPalPayment implements PaymentStrategy {

    @Override
    public void pay(int amount) {
        System.out.println("Paid ₹" + amount + " using PayPal.");
    }
}


// ----------------------------------------------------------
// Step 5: Context Class
// ----------------------------------------------------------

// The context stores a reference to the selected strategy.
// It delegates the payment task to the current strategy.
class PaymentContext {

    // Reference to the current payment strategy.
    private PaymentStrategy paymentStrategy;

    // Constructor to initialize the strategy.
    public PaymentContext(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    // Allows changing the strategy at runtime.
    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    // Delegates the payment operation to the selected strategy.
    public void makePayment(int amount) {
        paymentStrategy.pay(amount);
    }
}


// ----------------------------------------------------------
// Step 6: Client
// ----------------------------------------------------------

public class StrategyPatternDemo {

    public static void main(String[] args) {

        // Create the context with Credit Card payment strategy.
        PaymentContext paymentContext =
                new PaymentContext(new CreditCardPayment());

        paymentContext.makePayment(5000);

        // Change the strategy to UPI at runtime.
        paymentContext.setPaymentStrategy(new UPIPayment());

        paymentContext.makePayment(2500);

        // Change the strategy to PayPal.
        paymentContext.setPaymentStrategy(new PayPalPayment());

        paymentContext.makePayment(1000);
    }
}