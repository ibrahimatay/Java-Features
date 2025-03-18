import java.util.Map;

public class JEP488PrimitiveTypesInPatternsInstanceofAndSwitch {
    public static void main(String[] args) {
        // JEP 488: Primitive Types in Patterns, instanceof, and switch (Second Preview)
        // https://openjdk.org/jeps/488

        // Primitive Types ile Pattern Matching
        Object obj = 42;
        if (obj instanceof int i) {
            System.out.printf("Primitive int value: %1$s\n", i);
        }

        // Switch for Primitive Type
        System.out.printf("%1$s HTTP status code refers to a %2$s%n", 100, getHTTPCodeDesc(100));
        System.out.printf("%1$s HTTP status code refers to a %2$s%n", 200, getHTTPCodeDesc(200));
        System.out.printf("%1$s HTTP status code refers to a %2$s%n", 403, getHTTPCodeDesc(403));
        System.out.printf("%1$s HTTP status code refers to a %2$s%n", 0, getHTTPCodeDesc(0));

        // Record Patterns with Primitive Types
        JsonValue json = new JsonObject(Map.of(
                "name", new JsonString("Alice"),
                "age", new JsonNumber(28)
        ));

        if (json instanceof JsonObject(var map)
                && map.get("name") instanceof JsonString(var name)
                && map.get("age") instanceof JsonNumber(var age)) {
            System.out.printf("Name: %s, Age: %.0f%n", name, age);
        }
    }

    // Switch for Primitive Type
    public static String getHTTPCodeDesc(int code){
        return switch(code) {
            case 100 -> "Continue";
            case 200 -> "OK";
            case 301 -> "Moved Permanently";
            case 302 -> "Found";
            case 400 -> "Bad Request";
            case 500 -> "Internal Server Error";
            case 502 -> "Bad Gateway";
            case int i when (i > 100 && i < 200) -> "Informational";
            case int i when (i > 200 && i < 300) -> "Successful";
            case int i when (i > 302 && i < 400) -> "Redirection";
            case int i when (i > 400 && i < 500) -> "Client Error";
            case int i when (i > 502 && i < 600) -> "Server Error";
            default -> "Unknown error";
        };
    }
}

interface Human {}
class Employee implements Human {}
class Boss implements Human {}

sealed interface JsonValue permits JsonString, JsonNumber, JsonObject {}

record JsonString(String value) implements JsonValue {}
record JsonNumber(double value) implements JsonValue {}
record JsonObject(Map<String, JsonValue> map) implements JsonValue {}
