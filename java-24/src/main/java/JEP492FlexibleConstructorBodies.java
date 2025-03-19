public class JEP492FlexibleConstructorBodies {
    public static void main(String[] args) {

    }
}

class Person {
    private final String name;
    private final int age;

    Person(String name, int age) {
        prologue {
            if (name == null || name.isBlank()) {
                throw new IllegalArgumentException("Name cannot be empty");
            }
            if (age < 0) {
                throw new IllegalArgumentException("Age cannot be negative");
            }
        }
        this.name = name;
        this.age = age;

        epilogue {
            System.out.println("Person object created: " + name + ", Age: " + age);
        }
    }
}
