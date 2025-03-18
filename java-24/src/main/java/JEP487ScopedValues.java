import static java.lang.ScopedValue.where;

public class JEP487ScopedValues {
    // Define a scoped value
    private static final ScopedValue<String> USER_NAME = ScopedValue.newInstance();

    public static void main(String[] args) {
        // JEP 487: Scoped Values (Fourth Preview)
        // https://openjdk.org/jeps/487

        where(USER_NAME, "John").run(() -> {
            System.out.println("User: " + USER_NAME.get());
            subMethod();
        });
    }

    public static void subMethod() {
        // Access scoped value within a sub-method
        System.out.println("User in subMethod: " + USER_NAME.get());
    }
}
