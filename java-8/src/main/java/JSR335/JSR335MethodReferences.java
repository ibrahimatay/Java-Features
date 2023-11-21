package JSR335;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.ToIntFunction;

/*
https://docs.oracle.com/javase/tutorial/java/javaOO/methodreferences.html
* */
public class JSR335MethodReferences {
    public static void main(String[] args) {
        // Method References (JSR 335)
        // https://javaalmanac.io/features/method-references/

        List<String> names = Arrays.asList("İbrahim", "Aslı", "Nil");
        names.forEach(System.out::println);

        ToIntFunction<String> len = String::length;
        System.out.println(len.applyAsInt("Hello Reference!"));

        BiFunction<String, String, String> concat = String::concat;
        System.out.println(concat.apply("Hello ", "Reference!"));
    }
}
