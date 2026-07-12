/*
 * Liskov Substitution Principle (Correct Example)
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