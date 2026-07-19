# 🎯 Strategy Design Pattern

The **Strategy Design Pattern** is a **Behavioral Design Pattern** that allows you to define a family of algorithms, encapsulate each algorithm in a separate class, and make them interchangeable at runtime.

Instead of writing multiple `if-else` or `switch` statements to perform different behaviors, you create separate strategy classes. The client simply chooses which strategy to use.

---

# 📚 Table of Contents

* What is the Strategy Design Pattern?
* Why Do We Need It?
* Real-Life Analogy
* Structure
* Components
* How It Works
* Advantages
* Disadvantages
* When to Use
* SOLID Principles
* Java API Examples
* Repository Structure

---

# 📖 What is the Strategy Design Pattern?

The Strategy Pattern allows an object to change its behavior by changing the strategy object it uses.

Instead of embedding multiple algorithms inside a single class, each algorithm is placed in its own strategy class.

The context class delegates the work to the selected strategy instead of implementing the algorithm itself.

---

# ❓ Why Do We Need It?

Imagine you're implementing multiple payment methods.

Without the Strategy Pattern:

```java
if(paymentType.equals("CreditCard")){
    // Credit Card Logic
}
else if(paymentType.equals("UPI")){
    // UPI Logic
}
else if(paymentType.equals("PayPal")){
    // PayPal Logic
}
else if(paymentType.equals("Cash")){
    // Cash Logic
}
```

As more payment methods are added, this code becomes:

* Difficult to maintain
* Difficult to extend
* Hard to test
* Violates the Open/Closed Principle

Using the Strategy Pattern, each payment method becomes its own class.

---

# 🗺️ Real-Life Analogy

Imagine you are using Google Maps.

You want to travel from **Pune** to **Mumbai**.

Google Maps provides multiple route options.

* 🚗 Car Route
* 🚶 Walking Route
* 🚲 Bicycle Route

The destination remains the same, but the algorithm used to calculate the route changes.

Google Maps simply switches the routing strategy based on your selection.

This is exactly how the Strategy Pattern works.

---

# 🏗️ Structure

```text
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
```

---

# 🧩 Components

## 1. Strategy Interface

Defines the common behavior that every strategy must implement.

Example:

```java
interface PaymentStrategy {
    void pay(int amount);
}
```

---

## 2. Concrete Strategies

Each strategy class contains a different implementation of the same behavior.

Examples:

* Credit Card Payment
* UPI Payment
* PayPal Payment
* Cash Payment

Each class implements the `PaymentStrategy` interface.

---

## 3. Context Class

The Context stores a reference to a strategy object.

Instead of implementing the algorithm itself, it delegates the work to the selected strategy.

The Context remains the same even if the strategy changes.

---

## 4. Client

The client decides which strategy should be used.

Changing the strategy changes the application's behavior without modifying the Context.

---

# ⚙️ How It Works

### Step 1

The client selects a strategy.

```text
Client
   │
   ▼
CreditCardStrategy
```

---

### Step 2

The selected strategy is passed to the Context.

```text
Context
   │
   ▼
PaymentStrategy
```

---

### Step 3

The Context delegates the work.

```text
Context
   │
pay()
   │
CreditCardStrategy.pay()
```

---

### Step 4

The client changes the strategy.

```text
Client
   │
   ▼
UPIStrategy
```

---

### Step 5

The Context remains unchanged.

```text
Context
   │
pay()
   │
UPIStrategy.pay()
```

Only the strategy changes.

The Context never changes.

---

# 📊 Example Workflow

```text
Client

   │

Select Strategy

   │

Payment Context

   │

Delegates Request

   │

------------------------------

│            │             │

Credit     UPI         PayPal

Strategy   Strategy    Strategy
```

---

# ✅ Advantages

* Eliminates large `if-else` and `switch` statements
* Promotes composition over inheritance
* Follows the Open/Closed Principle
* Makes algorithms reusable
* Easy to add new strategies
* Improves code readability
* Encourages loose coupling
* Easier to test individual algorithms

---

# ❌ Disadvantages

* Increases the number of classes
* The client must know which strategy to choose
* Slightly more complex for very small applications

---

# 🎯 When Should You Use It?

Use the Strategy Pattern when:

* Multiple algorithms solve the same problem.
* The algorithm should be selected at runtime.
* You want to avoid long `if-else` or `switch` statements.
* Different implementations share the same interface.
* New behaviors may be added in the future.

---

# 🌍 Real-World Examples

* Payment Gateways (Credit Card, UPI, PayPal)
* Google Maps Route Selection
* File Compression (ZIP, RAR, 7z)
* Sorting Algorithms
* Tax Calculation
* Discount Calculation
* Shipping Cost Calculation
* Authentication Methods (OAuth, JWT, Basic Authentication)

---

# 🧩 SOLID Principles

The Strategy Pattern supports several SOLID principles.

## Open/Closed Principle (OCP)

New strategies can be added without modifying existing code.

Example:

* Add `CryptoPaymentStrategy`
* No changes are required in the Context class.

---

## Single Responsibility Principle (SRP)

Each strategy class is responsible for only one algorithm.

Examples:

* `CreditCardStrategy`
* `UPIStrategy`
* `PayPalStrategy`

Each class has a single responsibility.

---

## Dependency Inversion Principle (DIP)

The Context depends on the `Strategy` interface instead of concrete implementations.

Instead of:

```java
CreditCardStrategy payment = new CreditCardStrategy();
```

Use:

```java
PaymentStrategy payment = new CreditCardStrategy();
```

---

# ☕ Java API Examples

The Strategy Pattern is widely used in Java.

Examples include:

* `Comparator<T>`
* `Comparable<T>`
* `Collections.sort()`
* `Arrays.sort()`
* `ExecutorService`
* `ThreadPoolExecutor`

---



# 🚀 Conclusion

The Strategy Pattern is one of the most useful behavioral design patterns because it separates **what** needs to be done from **how** it is done.

Instead of hardcoding different algorithms inside a single class, each algorithm is implemented as a separate strategy. The Context delegates the work to the selected strategy, making the application more flexible, maintainable, and easier to extend.

Whenever you have multiple ways of performing the same task and want to switch between them at runtime, the **Strategy Design Pattern** is an excellent choice.
