package com.ibrahimatay;

import java.util.stream.Collectors;

public class StringMethods {
    public static void main(String[] args) {
        // https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/String.html
        System.out.println("  ".isBlank()); // is true
        System.out.println("".isBlank()); // is true
        System.out.println("Istanbul".isBlank()); // is false
        System.out.println("Istanbul is best city in the world".isBlank()); // is false

        System.out.println("----------------");

        String cities = "Istanbul\nIzmir\nAnkara";
        System.out.println(cities);
        /*
        Istanbul
        Izmir
        Ankara
        * */

        System.out.println("----------------");
        System.out.println(cities.lines().collect(Collectors.toList()));
        // [Istanbul, Izmir, Ankara]

        System.out.println("----------------");
        System.out.println("Istanbul,\n".repeat(3));
        /*
        Istanbul,
        Istanbul,
        Istanbul,
        * */

        System.out.println("----------------");
        String testText = "   Welcome to Istanbul      ";
        // https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/String.html#strip()

        System.out.println("----------------");
        System.out.println("Then test text is = " + testText);
        System.out.println("The length of the test text is "+ testText.length()+ " it's " + testText.strip().length()+" after striping.");
        System.out.println("The length of the test text is "+ testText.length()+ " it's " + testText.stripLeading().length()+" after stripLeading.");
        System.out.println("The length of the test text is "+ testText.length()+ " it's " + testText.stripTrailing().length()+" after stripTrailing.");
        // Then test text is =    Welcome to Istanbul
        // The length of the test text is 28 it's 19 after striping.
        // The length of the test text is 28 it's 25 after stripLeading.
        // The length of the test text is 28 it's 22 after stripTrailing.
    }
}
