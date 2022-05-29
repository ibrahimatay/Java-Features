package interfaces;

public class Main {
    public static void main(String[] args) {
        DefaultMethods defaultMethods = new DefaultMethods();
        defaultMethods.say();
        defaultMethods.sayMore("Hello from the main method.");

        Sayable.consoleSay("Hello from the static interface method.");
    }
}
interface Sayable {
    default void say() {
        System.out.println("Hello, this is the default method");
    }

    void sayMore(String message);

    static void consoleSay(String message) {
        System.out.println(message);
    }
}

class DefaultMethods implements Sayable {
    @Override
    public void sayMore(String message) {
        System.out.println(String.format("This message '%s' came in the implemented method.", message));
    }
}

