# Singleton Design Pattern (Java)

The **Singleton Design Pattern** is a **Creational Design Pattern** that ensures **only one instance** of a class exists throughout the application's lifecycle while providing a **global access point** to access that instance.

It is one of the most commonly used design patterns in Java and is widely used for managing shared resources such as database connections, loggers, caches, configuration managers, and thread pools.

---

# Table of Contents

- [What is Singleton?](#what-is-singleton)
- [Why Do We Need Singleton?](#why-do-we-need-singleton)
- [Real-World Examples](#real-world-examples)
- [Structure of Singleton](#structure-of-singleton)
- [Singleton Variants](#singleton-variants)
  - Eager Initialization
  - Lazy Initialization
  - Synchronized Singleton
  - Double Checked Locking
  - Bill Pugh Singleton
  - Enum Singleton
- [Comparison Table](#comparison-table)
- [Advantages](#advantages)
- [Disadvantages](#disadvantages)
- [When to Use](#when-to-use)
- [Interview Questions](#interview-questions)

---

# What is Singleton?

A Singleton is a class that satisfies two important conditions:

- Only **one object** of the class can exist.
- The object can be accessed globally from anywhere in the application.

Unlike normal classes where multiple objects can be created using `new`, a Singleton class controls object creation itself.

---

# Why Do We Need Singleton?

Imagine every module of your application creates its own database connection.

```
Login Module
      |
Database Connection 1

Payment Module
      |
Database Connection 2

Admin Module
      |
Database Connection 3
```

Problems:

- Too many connections
- Increased memory usage
- Resource wastage
- Difficult resource management

Instead, every module shares a single connection.

```
                Database

                    ^
                    |

         Singleton Database Manager

      /        |         |        \
 Login     Payment    Admin    Product
```

Only one object manages everything.

---

# Real-World Examples

Singleton is commonly used in:

- Database Connection Pool
- Logger
- Configuration Manager
- Cache Manager
- Printer Spooler
- Thread Pool
- Runtime Environment
- File System
- Application Configuration

---

# Structure of Singleton

Every Singleton class contains three important parts.

## 1. Private Constructor

Prevents object creation using the `new` keyword.

```java
private Singleton() {}
```

---

## 2. Static Instance Variable

Stores the only object.

```java
private static Singleton instance;
```

---

## 3. Public Static Method

Returns the Singleton object.

```java
public static Singleton getInstance() {
    return instance;
}
```

---

# Singleton Variants

---

# 1. Eager Initialization

The object is created immediately when the class is loaded.

### Implementation

```java
class Singleton {

    private static final Singleton INSTANCE = new Singleton();

    private Singleton() {}

    public static Singleton getInstance() {
        return INSTANCE;
    }
}
```

### Advantages

- Simple
- Thread-safe
- No synchronization required

### Disadvantages

- Object is created even if never used
- Can waste memory

---

# 2. Lazy Initialization

The object is created only when required.

### Implementation

```java
class Singleton {

    private static Singleton instance;

    private Singleton() {}

    public static Singleton getInstance() {

        if(instance == null){
            instance = new Singleton();
        }

        return instance;
    }
}
```

### Advantages

- Saves memory
- Object created only when needed

### Disadvantages

- Not thread-safe

---

# 3. Synchronized Singleton

Makes the `getInstance()` method synchronized.

### Implementation

```java
class Singleton {

    private static Singleton instance;

    private Singleton(){}

    public static synchronized Singleton getInstance(){

        if(instance == null){
            instance = new Singleton();
        }

        return instance;
    }
}
```

### Advantages

- Thread-safe
- Easy to implement

### Disadvantages

- Slower because every method call acquires a lock

---

# 4. Double Checked Locking

Checks twice before creating the object.

### Implementation

```java
class Singleton {

    private static volatile Singleton instance;

    private Singleton(){}

    public static Singleton getInstance(){

        if(instance == null){

            synchronized(Singleton.class){

                if(instance == null){
                    instance = new Singleton();
                }

            }
        }

        return instance;
    }
}
```

### Why `volatile`?

Without `volatile`, the JVM may reorder object creation instructions.

Another thread might receive a partially initialized object.

Using `volatile` guarantees:

- Correct initialization
- Visibility across threads
- No instruction reordering

### Advantages

- Thread-safe
- High performance
- Lazy Initialization

---

# 5. Bill Pugh Singleton (Recommended)

Uses a static inner helper class.

### Implementation

```java
class Singleton {

    private Singleton(){}

    private static class Helper{

        private static final Singleton INSTANCE =
                new Singleton();
    }

    public static Singleton getInstance(){

        return Helper.INSTANCE;
    }
}
```

### Why is it Thread Safe?

Java guarantees that class loading is thread-safe.

The helper class is loaded only when `getInstance()` is called.

### Advantages

- Lazy Initialization
- Thread-safe
- No synchronization overhead
- Excellent performance

---

# 6. Enum Singleton

The safest Singleton implementation.

### Implementation

```java
enum Singleton {

    INSTANCE;

    public void show(){
        System.out.println("Hello Singleton");
    }
}
```

Usage

```java
Singleton.INSTANCE.show();
```

### Advantages

- Thread-safe
- Serialization-safe
- Reflection-safe (for normal usage)
- Very simple

### Disadvantages

- Less flexible if inheritance is required

---

# Comparison Table

| Variant | Lazy Initialization | Thread Safe | Performance | Recommended |
|----------|---------------------|-------------|-------------|-------------|
| Eager Initialization | ❌ | ✅ | ⭐⭐⭐⭐⭐ | ✅ |
| Lazy Initialization | ✅ | ❌ | ⭐⭐⭐⭐⭐ | ❌ |
| Synchronized Singleton | ✅ | ✅ | ⭐⭐⭐ | ⚠️ |
| Double Checked Locking | ✅ | ✅ | ⭐⭐⭐⭐⭐ | ✅ |
| Bill Pugh Singleton | ✅ | ✅ | ⭐⭐⭐⭐⭐ | ⭐ Best Choice |
| Enum Singleton | Effectively eager on enum initialization | ✅ | ⭐⭐⭐⭐⭐ | ⭐ Most Robust |

---

# Advantages

- Controlled access to shared resources
- Reduces memory consumption
- Avoids unnecessary object creation
- Global access point
- Thread-safe variants available
- Easy resource management

---

# Disadvantages

- Global state can make testing harder
- Can violate the Single Responsibility Principle if overused
- Difficult to extend because of the private constructor
- Requires careful implementation in multithreaded applications

---

# When to Use

Use Singleton when your application requires exactly one shared instance.

Examples:

- Database Connection
- Logger
- Configuration Manager
- Cache Manager
- Thread Pool
- Runtime Environment
- File System
- Application Settings
- Printer Manager

---

# Interview Questions

### Why is the constructor private?

To prevent external classes from creating objects using the `new` keyword.

---

### Why is `getInstance()` static?

Because no object exists initially, so the instance must be accessed through the class itself.

---

### Why is Lazy Initialization not thread-safe?

Two threads can simultaneously find the instance as `null` and both create separate objects.

---

### Why do we use `volatile`?

To prevent instruction reordering and ensure all threads see a fully initialized object.

---

### Which Singleton implementation is best?

For most Java applications:

- ✅ Bill Pugh Singleton (clean, lazy, thread-safe)
- ✅ Double Checked Locking (high-performance, thread-safe)
- ✅ Enum Singleton (most robust and safest)

---

# Summary

```
Singleton Design Pattern
│
├── Eager Initialization
│
├── Lazy Initialization
│
├── Synchronized Singleton
│
├── Double Checked Locking
│
├── Bill Pugh Singleton ⭐
│
└── Enum Singleton ⭐
```

---

## Repository Structure

```
Singleton-Design-Pattern/
│
├── EagerSingleton.java
├── LazySingleton.java
├── SynchronizedSingleton.java
├── DoubleCheckedSingleton.java
├── BillPughSingleton.java
├── EnumSingleton.java
└── README.md
```

---

## References

- *Design Patterns: Elements of Reusable Object-Oriented Software* (Gang of Four)
- *Effective Java* by Joshua Bloch

---

## Author

**Pravin Rathod**

If you found this repository helpful, consider giving it a ⭐ to support the project.