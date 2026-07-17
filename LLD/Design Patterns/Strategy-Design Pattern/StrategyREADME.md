Strategy Design Pattern

The Strategy Design Pattern is a Behavioral Design Pattern that allows you to define a family of algorithms, encapsulate each one into a separate class, and make them interchangeable at runtime.

Instead of writing multiple if-else or switch statements to perform different behaviors, you create separate strategy classes. The client simply chooses which strategy to use.

Real-Life Example

Imagine you are using Google Maps.

You want to travel from Pune to Mumbai.

Google Maps gives you different route options:

🚗 Car Route
🚶 Walking Route
🚲 Bicycle Route

The destination is the same, but the algorithm used to calculate the route changes.

Google Maps simply switches the routing strategy based on your selection.

This is exactly what the Strategy Pattern does.




Structure


                +-------------------+
                |     Strategy      |
                |-------------------|
                | execute()         |
                +---------+---------+
                          |
          -------------------------------
          |              |              |
          |              |              |
+----------------+ +----------------+ +----------------+
| Strategy A     | | Strategy B     | | Strategy C     |
|----------------| |----------------| |----------------|
| execute()      | | execute()      | | execute()      |
+----------------+ +----------------+ +----------------+

                 ^
                 |
          +---------------+
          |   Context     |
          |---------------|
          | Strategy      |
          | perform()     |
          +---------------+



          Components
1. Strategy Interface

Defines the common method that every strategy must implement.

interface PaymentStrategy {
    void pay(int amount);
}
2. Concrete Strategies

Each class contains a different algorithm.

Example:

Credit Card Payment
UPI Payment
PayPal Payment
Cash Payment

Each implements the same interface.

3. Context Class

Stores a reference to a strategy.

Instead of implementing the algorithm itself, it delegates the work to the selected strategy.

4. Client

Chooses which strategy should be used.

Example Flow
Client
   |
   | chooses
   |
CreditCardStrategy

Context
   |
   |
pay()
   |
CreditCardStrategy.pay()

--------------------------

Client changes strategy

UPIStrategy

Context
   |
pay()
   |
UPIStrategy.pay()

Notice that Context never changes. Only the strategy changes.