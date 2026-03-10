package threadsafe_singleton;

public class Singleton {
    private static volatile Singleton insstance;

    private Singleton() {

    }

    public static Singleton getInstance() {
        if (insstance == null) {
            synchronized (Singleton.class) {
                if (insstance == null) {
                    insstance = new Singleton();
                }
            }
        }
        return insstance;

    }
}
