package optional;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        // https://docs.oracle.com/javase/8/docs/api/java/util/Optional.html

        Optional<Person> empty = Optional.empty();

        /*
        Optional<Person> ofNull  = Optional.of(null);
        Exception in thread "main" java.lang.NullPointerException
            at java.base/java.util.Objects.requireNonNull(Objects.java:208)
            at java.base/java.util.Optional.of(Optional.java:113)
            at optional.Main.main(Main.java:8)
        * */

        Person samplePerson = new Person("Ibrahim");
        Optional<Person> person = Optional.of(samplePerson);

        Optional<Person> ofNullable = Optional.ofNullable(null);

        Optional<Integer> optionalNumber = Optional.ofNullable(null);
        Integer number01 = optionalNumber.orElse(1919);

        /*
          Integer number02 = optionalNumber.orElseThrow(NumberFormatException::new);
          Exception in thread "main" java.lang.NumberFormatException
            at java.base/java.util.Optional.orElseThrow(Optional.java:403)
            at optional.Main.main(Main.java:24)
        * */

        Person newInstance = ofNullable.orElseGet(()-> new Person("Aslı"));

    }
}

class Person {
    public String name;

    public Person(String name) {
        this.name = name;
    }
}
