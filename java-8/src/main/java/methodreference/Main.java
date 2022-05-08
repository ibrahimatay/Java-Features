package methodreference;

import java.util.Arrays;
import java.util.List;
/*
https://docs.oracle.com/javase/tutorial/java/javaOO/methodreferences.html
* */
public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("İbrahim", "Aslı", "Nil");
        names.forEach(System.out::println);
    }
}
