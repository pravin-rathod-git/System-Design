/*
 *Liskov Substitution Principle (LSP)

The Liskov Substitution Principle (LSP) is the “L” in SOLID. It states that:

Objects of a superclass should be replaceable with objects of its subclasses without affecting the correctness of the program.

In simple terms, a subclass should properly follow the behavior and contract of its parent class. If replacing a parent object with a child object causes unexpected behavior, the inheritance relationship is likely violating LSP.

Key Idea

A subclass should:

Preserve the expected behavior of its parent class.
Not introduce unexpected restrictions.
Honor the methods and contracts defined by the superclass.
Be usable wherever the superclass is expected.
 */

// Parent class
class Bird {

    public void eat() {
        System.out.println("Bird is eating");
    }
}

// Flying Bird
class FlyingBird extends Bird {

    public void fly() {
        System.out.println("Flying...");
    }
}

// Sparrow
class Sparrow extends FlyingBird {

    @Override
    public void fly() {
        System.out.println("Sparrow is flying");
    }
}

// Eagle
class Eagle extends FlyingBird {

    @Override
    public void fly() {
        System.out.println("Eagle is flying");
    }
}

// Penguin
class Penguin extends Bird {

    public void swim() {
        System.out.println("Penguin is swimming");
    }
}

public class LiskovSubstitutionPrinciple {

    public static void makeBirdFly(FlyingBird bird) {
        bird.fly();
    }

    public static void main(String[] args) {

        FlyingBird sparrow = new Sparrow();
        FlyingBird eagle = new Eagle();

        Penguin penguin = new Penguin();

        makeBirdFly(sparrow);
        makeBirdFly(eagle);

        penguin.eat();
        penguin.swim();
    }
}
