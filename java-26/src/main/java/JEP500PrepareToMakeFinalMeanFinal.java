import java.lang.reflect.Field;

// JEP 500: Prepare to Make Final Mean Final
// https://openjdk.org/jeps/500

public class JEP500PrepareToMakeFinalMeanFinal {
    static void main() {
        AppConfig config = new AppConfig();
        System.out.println("1. Original Value: " + config.dbUrl);
        try {
            // We capture the 'dbUrl' field using the Reflection API
            Field field = AppConfig.class.getDeclaredField("dbUrl");

            // We disable Java's access checks (Opening the backdoor)
            field.setAccessible(true);

            // We force (hack) a change to the value of the 'final' variable
            field.set(config, "jdbc:mysql://hacked-server:3306/stolen_db");

            System.out.println("2. New Value (Changed): " + config.dbUrl);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class AppConfig{
    public final String dbUrl = "jdbc:postgresql://localhost:5432/mydb";
}
