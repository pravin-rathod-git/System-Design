class Singleton {

    private Singleton() {}

    // Loaded only when getInstance() is called
    private static class Helper {
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        return Helper.INSTANCE;
    }
}

public class BillPughSingleton {
    
    public static void main(String[] args) {

        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();

        System.out.println(s1 == s2);
    }
}
