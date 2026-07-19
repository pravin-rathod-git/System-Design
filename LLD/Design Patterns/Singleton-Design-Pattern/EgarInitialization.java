class Singleton {

    // Object created immediately
    private static final Singleton instance = new Singleton();

    // Private constructor
    private Singleton() {
        System.out.println("Singleton Created");
    }

    // Global access point
    public static Singleton getInstance() {
        return instance;
    }
}

public class EgarInitialization {
    public static void main(String[] args) {

        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();

        System.out.println(s1 == s2);
    }
}
