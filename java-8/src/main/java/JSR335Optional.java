import java.util.Optional;

public class JSR335Optional {
    public static void main(String[] args) {
        // https://docs.oracle.com/javase/8/docs/api/java/util/Optional.html

        // Is there a JEP for Optional?
        // https://stackoverflow.com/questions/70724741/is-there-a-jep-for-optional

        Optional<JSR335OptionalPerson> empty = Optional.empty();

        /*
        Optional<Person> ofNull  = Optional.of(null);
        Exception in thread "main" java.lang.NullPointerException
            at java.base/java.util.Objects.requireNonNull(Objects.java:208)
            at java.base/java.util.Optional.of(Optional.java:113)
            at optional.Main.main(Main.java:8)
        * */

        JSR335OptionalPerson samplePerson = new JSR335OptionalPerson("Ibrahim");
        Optional<JSR335OptionalPerson> person = Optional.of(samplePerson);

        Optional<JSR335OptionalPerson> ofNullable = Optional.ofNullable(null);
        if (ofNullable.isPresent()) {
            System.out.println("ofNullable variable is not a null");
        } else {
            System.out.println("ofNullable variable is a null");
        }

        ofNullable.ifPresent(p -> System.out.println(p));

        Optional<Integer> optionalNumber = Optional.ofNullable(null);
        Integer number01 = optionalNumber.orElse(1919);

        /*
          Integer number02 = optionalNumber.orElseThrow(NumberFormatException::new);
          Exception in thread "main" java.lang.NumberFormatException
            at java.base/java.util.Optional.orElseThrow(Optional.java:403)
            at optional.Main.main(Main.java:24)
        * */

        JSR335OptionalPerson newInstance = ofNullable.orElseGet(()-> new JSR335OptionalPerson("Aslı"));

    }
}

class JSR335OptionalPerson {
    public String name;

    public JSR335OptionalPerson(String name) {
        this.name = name;
    }
}
