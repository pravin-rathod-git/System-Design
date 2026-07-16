🚀 SOLID Design Principles in Java

SOLID is a set of five object-oriented design principles introduced by Robert C. Martin to make software maintainable, scalable, reusable, and easy to understand.

📖 What is SOLID?

SOLID is an acronym for five design principles:

Principle	Full Form
S	Single Responsibility Principle
O	Open Closed Principle
L	Liskov Substitution Principle
I	Interface Segregation Principle
D	Dependency Inversion Principle

Following these principles leads to:

✅ Clean Code
✅ Loose Coupling
✅ High Cohesion
✅ Better Maintainability
✅ Easy Testing
✅ Easier Feature Addition
✅ Better Reusability
1️⃣ Single Responsibility Principle (SRP)
Definition

A class should have only one reason to change.

A class should perform only one responsibility.

If a class performs multiple tasks, any change in one task may affect the others.

❌ Bad Example
class Employee {

    public void calculateSalary() {
        System.out.println("Calculating salary");
    }

    public void saveToDatabase() {
        System.out.println("Saving employee");
    }

    public void generateReport() {
        System.out.println("Generating report");
    }
}
Problems

Employee class is responsible for:

Salary
Database
Report

Three different responsibilities.

✅ Good Example
class Employee {
}

class SalaryCalculator {

    public void calculateSalary(Employee employee) {
        System.out.println("Calculating salary");
    }
}

class EmployeeRepository {

    public void save(Employee employee) {
        System.out.println("Saving employee");
    }
}

class ReportGenerator {

    public void generate(Employee employee) {
        System.out.println("Generating report");
    }
}
Advantages
Easier maintenance
Easy debugging
Better readability
High cohesion
Low coupling
2️⃣ Open Closed Principle (OCP)
Definition

Software entities should be open for extension but closed for modification.

Instead of changing existing code, extend it.

❌ Bad Example
class PaymentProcessor {

    public void pay(String paymentType) {

        if (paymentType.equals("CreditCard")) {
            System.out.println("Credit Card Payment");
        }
        else if (paymentType.equals("UPI")) {
            System.out.println("UPI Payment");
        }
    }
}

Whenever a new payment method is added, this class must be modified.

✅ Good Example
interface Payment {

    void pay();
}

class CreditCardPayment implements Payment {

    @Override
    public void pay() {
        System.out.println("Credit Card Payment");
    }
}

class UpiPayment implements Payment {

    @Override
    public void pay() {
        System.out.println("UPI Payment");
    }
}

class PaymentProcessor {

    public void process(Payment payment) {
        payment.pay();
    }
}

Usage

PaymentProcessor processor = new PaymentProcessor();

processor.process(new CreditCardPayment());
processor.process(new UpiPayment());

Adding PayPal requires creating another class.

No existing code changes.

Advantages
Easy feature addition
Less bugs
Better scalability
Easier maintenance
3️⃣ Liskov Substitution Principle (LSP)
Definition

A subclass should be able to replace its parent class without changing the correctness of the program.

A child class must behave like its parent.

❌ Bad Example
class Bird {

    public void fly() {
        System.out.println("Flying");
    }
}

class Penguin extends Bird {

    @Override
    public void fly() {
        throw new UnsupportedOperationException();
    }
}

Problem:

A Penguin cannot fly.

Replacing Bird with Penguin breaks the program.

✅ Good Example
class Bird {
}

class FlyingBird extends Bird {

    public void fly() {
        System.out.println("Flying");
    }
}

class Sparrow extends FlyingBird {
}

class Penguin extends Bird {
}

Now every subclass behaves correctly.

LSP Rules
1. Signature Rule

A child method must have the same method signature.

Example

class Animal {

    public void eat() {
    }
}

class Dog extends Animal {

    @Override
    public void eat() {
        System.out.println("Dog eating");
    }
}
2. Property Rule

Child objects should preserve parent properties.

Example

Rectangle

class Rectangle {

    protected int width;
    protected int height;

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int area() {
        return width * height;
    }
}

Square

class Square extends Rectangle {

    @Override
    public void setWidth(int width) {
        this.width = width;
        this.height = width;
    }

    @Override
    public void setHeight(int height) {
        this.width = height;
        this.height = height;
    }
}

This violates LSP because Square changes Rectangle's expected behavior.

Advantages
Better inheritance
Reliable polymorphism
Fewer runtime bugs
4️⃣ Interface Segregation Principle (ISP)
Definition

Clients should not be forced to implement interfaces they do not use.

Create small, focused interfaces instead of one large interface.

❌ Bad Example
interface Machine {

    void print();

    void scan();

    void fax();
}

Printer

class BasicPrinter implements Machine {

    public void print() {
        System.out.println("Printing");
    }

    public void scan() {
        throw new UnsupportedOperationException();
    }

    public void fax() {
        throw new UnsupportedOperationException();
    }
}

Problem:

Printer doesn't support scan or fax.

✅ Good Example
interface Printer {

    void print();
}

interface Scanner {

    void scan();
}

interface Fax {

    void fax();
}

Basic Printer

class BasicPrinter implements Printer {

    @Override
    public void print() {
        System.out.println("Printing");
    }
}

Advanced Printer

class MultiFunctionPrinter implements Printer, Scanner, Fax {

    @Override
    public void print() {
        System.out.println("Printing");
    }

    @Override
    public void scan() {
        System.out.println("Scanning");
    }

    @Override
    public void fax() {
        System.out.println("Faxing");
    }
}
Advantages
Smaller interfaces
Cleaner implementation
Better flexibility
5️⃣ Dependency Inversion Principle (DIP)
Definition

High-level modules should not depend on low-level modules. Both should depend on abstractions.

Use interfaces instead of concrete classes.

❌ Bad Example
class Keyboard {

    public void type() {
        System.out.println("Typing");
    }
}

class Computer {

    private Keyboard keyboard = new Keyboard();

    public void start() {
        keyboard.type();
    }
}

Computer is tightly coupled with Keyboard.

✅ Good Example

Interface

interface InputDevice {

    void input();
}

Keyboard

class Keyboard implements InputDevice {

    @Override
    public void input() {
        System.out.println("Typing");
    }
}

Mouse

class Mouse implements InputDevice {

    @Override
    public void input() {
        System.out.println("Mouse Input");
    }
}

Computer

class Computer {

    private InputDevice device;

    public Computer(InputDevice device) {
        this.device = device;
    }

    public void start() {
        device.input();
    }
}

Usage

Computer computer = new Computer(new Keyboard());

computer.start();

Now Computer can work with Keyboard, Mouse, or any future input device.

Advantages
Loose coupling
Easy testing
Easy dependency injection
Better scalability
📊 SOLID Summary
Principle	Rule	Goal
SRP	One class → One responsibility	High Cohesion
OCP	Extend, don't modify	Easy feature addition
LSP	Child should replace parent safely	Correct inheritance
ISP	Small interfaces	No unnecessary implementation
DIP	Depend on abstractions	Loose coupling
🎯 Interview Questions
Q1. What is SOLID?

SOLID is a collection of five object-oriented design principles that help build maintainable, scalable, flexible, and reusable software.

Q2. Which SOLID principle improves maintainability?

Single Responsibility Principle (SRP).

Q3. Which principle is mostly achieved using interfaces?

Dependency Inversion Principle (DIP) and Interface Segregation Principle (ISP).

Q4. Which principle uses inheritance the most?

Liskov Substitution Principle (LSP).

Q5. Which principle reduces coupling?

Dependency Inversion Principle (DIP).

Q6. Which principle improves feature addition?

Open Closed Principle (OCP).

Q7. What happens if LSP is violated?
Incorrect inheritance
Unexpected runtime behavior
Broken polymorphism
Q8. What is the difference between SRP and ISP?
SRP	ISP
Focuses on classes	Focuses on interfaces
One responsibility per class	Small, specific interfaces
Prevents multiple responsibilities	Prevents forcing unused methods
Q9. What is the difference between OCP and DIP?
OCP	DIP
Extend behavior without modifying existing code	Depend on abstractions instead of concrete implementations
Uses inheritance or composition	Uses interfaces and dependency injection
🏆 Best Practices
✔ Keep classes focused on a single responsibility.
✔ Prefer composition over inheritance when appropriate.
✔ Program to interfaces, not implementations.
✔ Create small, meaningful interfaces.
✔ Avoid modifying tested code—extend it instead.
✔ Use dependency injection to reduce coupling.
✔ Follow SOLID alongside design patterns such as Factory, Strategy, Observer, and Decorator for cleaner architecture.