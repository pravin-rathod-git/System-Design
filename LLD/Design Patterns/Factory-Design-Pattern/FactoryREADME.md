# 🏭 Factory Design Pattern

The **Factory Design Pattern** is one of the **Creational Design Patterns**. It provides a way to create objects without exposing the object creation logic to the client. Instead of creating objects directly using the `new` keyword, the client requests the required object from a factory.

This pattern helps make applications **loosely coupled**, **easier to maintain**, and **easier to extend**.

---

# 📚 Table of Contents

* What is the Factory Design Pattern?
* Why Do We Need It?
* Real-Life Analogy
* Types of Factory Pattern

  * Simple Factory
  * Factory Method
  * Abstract Factory
* Comparison
* Advantages
* Disadvantages
* When to Use
* SOLID Principles
* Java API Examples
* Repository Structure

---

# 📖 What is the Factory Design Pattern?

The Factory Pattern delegates the responsibility of object creation to a separate class called a **Factory**.

Instead of writing:

```java
Burger burger = new PremiumBurger();
```

we write:

```java
BurgerFactory factory = new BurgerFactory();
Burger burger = factory.createBurger("premium");
```

The client only requests an object. The factory decides which object should be created.

---

# ❓ Why Do We Need It?

Suppose an application directly creates objects everywhere.

```java
Burger burger = new PremiumBurger();
```

If the implementation changes or a new burger type is added, every location that creates the object may need to be modified.

This leads to:

* Tight coupling
* Duplicate object creation logic
* Difficult maintenance
* Harder testing

Using a factory centralizes the object creation logic into one place.

---

# 🍔 Real-Life Analogy

Imagine you visit a burger restaurant.

You don't go into the kitchen and prepare the burger yourself.

Instead, you simply place an order.

```
Customer
    │
    ▼
Burger Restaurant
    │
    ▼
Kitchen
    │
    ▼
Burger
```

The restaurant decides how the burger is prepared.

The customer only receives the finished product.

The **restaurant** acts as the **Factory**.

---

# 🏗️ Types of Factory Pattern

The Factory Pattern family consists of three commonly used variants.

```
Factory Pattern
│
├── Simple Factory
├── Factory Method
└── Abstract Factory
```

---

# 1️⃣ Simple Factory

A **single factory class** creates different types of objects based on the client's request.

### Structure

```
Client
   │
   ▼
BurgerFactory
   │
   ├── BasicBurger
   ├── StandardBurger
   └── PremiumBurger
```

### Characteristics

* One factory
* Multiple products
* Uses `if-else` or `switch`
* Easy to understand
* Suitable for small applications

---

# 2️⃣ Factory Method

Instead of having one large factory, each product family has its own factory.

### Structure

```
                BurgerFactory
                     ▲
         ┌───────────┴───────────┐
         │                       │
   SinghBurger             KingBurger
         │                       │
         ▼                       ▼
 Regular Burgers          Wheat Burgers
```

### Characteristics

* Multiple factories
* Each factory creates one product family
* Easy to extend
* Follows the Open/Closed Principle better than Simple Factory

---

# 3️⃣ Abstract Factory

The Abstract Factory creates an **entire family of related objects**.

Example:

```
MealFactory
     ▲
     │
───────────────
│             │
SinghBurger   KingBurger
│             │
├── Burger    ├── Burger
└── GarlicBread
              └── GarlicBread
```

Each factory creates matching products.

Example:

**SinghBurger**

* Basic Burger
* Cheese Garlic Bread

**KingBurger**

* Wheat Burger
* Wheat Garlic Bread

The client only changes the factory, and the entire product family changes automatically.

---

# 📊 Comparison

| Feature             | Simple Factory | Factory Method                  | Abstract Factory                                                  |
| ------------------- | -------------- | ------------------------------- | ----------------------------------------------------------------- |
| Number of Factories | One            | Multiple                        | Multiple                                                          |
| Creates             | One Product    | One Product                     | Family of Products                                                |
| Uses if-else        | ✅ Yes          | Usually inside concrete factory | Usually inside concrete factory (or none in pure implementations) |
| Easy to Extend      | Limited        | Yes                             | Yes                                                               |
| Complexity          | Easy           | Medium                          | Advanced                                                          |
| Best For            | Small Projects | Medium Projects                 | Large Applications                                                |

---

# ✅ Advantages

* Centralized object creation
* Reduces code duplication
* Promotes loose coupling
* Improves code readability
* Easier maintenance
* Easier testing
* Easier to extend

---

# ❌ Disadvantages

* Introduces additional classes
* Can increase project complexity
* Too much abstraction may be unnecessary for very small projects

---

# 🎯 When Should You Use It?

Use the Factory Pattern when:

* Object creation logic is complex.
* The client should not know which concrete class is created.
* Different implementations need to be selected at runtime.
* The application should be easy to extend without changing client code.

---

# 🧩 SOLID Principles

The Factory Pattern supports several SOLID principles.

### Dependency Inversion Principle (DIP)

The client depends on interfaces instead of concrete classes.

Instead of:

```java
PremiumBurger burger = new PremiumBurger();
```

Use:

```java
Burger burger = factory.createBurger("premium");
```

---

### Open/Closed Principle (OCP)

New products can often be introduced by adding new classes instead of changing client code.

---

# ☕ Java API Examples

Many Java APIs use the Factory concept.

* `Calendar.getInstance()`
* `NumberFormat.getInstance()`
* `DocumentBuilderFactory.newInstance()`
* `Executors.newFixedThreadPool()`

---

# 📂 Repository Structure

```
Factory-Pattern/
│
├── README.md
│
├── SimpleFactory/
│   └── SimpleFactory.java
│
├── FactoryMethod/
│   └── FactoryMethod.java
│
└── AbstractFactory/
    └── AbstractFactory.java
```

---

# 🚀 Conclusion

The Factory Pattern is one of the most commonly used creational design patterns in object-oriented programming.

* **Simple Factory** is ideal for centralizing object creation in smaller applications.
* **Factory Method** provides flexibility by allowing each concrete factory to create its own product.
* **Abstract Factory** is used when creating families of related objects that should work together.

Understanding these three variants provides a strong foundation for learning advanced frameworks such as **Spring**, **Hibernate**, and other enterprise Java technologies where object creation is often delegated to factories or containers.
