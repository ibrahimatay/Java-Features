package com.ibrahimatay;

import java.util.List;

public class JEP286LocalVariableTypeInference {
    public static void main(String[] args) {
        // JEP 286: Local-Variable Type Inference
        // https://openjdk.org/jeps/286

        // FAQ for JEP 286 (Local Variable Type Inference)
        // http://cr.openjdk.java.net/~briangoetz/jep-286/lvti-faq.html

        // Local Variable Type Inference for Java
        // https://tr.surveymonkey.com/results/SM-FLWGS5PW/

        final var CURRENCY_CODE="TRY";
        var name = "Cansu";
        var currentYear= 2022;

        var words = List.of("cloud", "fine", "pen", "dog", "temper", "sky", "book");
        System.out.println(words);
        // [cloud, fine, pen, dog, temper, sky, book]

        var person = new Person("Cansu");
        var message = "Welcome to Java";
        if (message instanceof String){
            System.out.println("'"+ message +"' is type of String");
        } else {
            System.out.println("'"+ message +"' is not type of String");
        }
    }
}

class Person {
    public String name;
    // public var surname; // compilation error, java: 'var' is not allowed here

    public Person(String name) {
        this.name = name;
    }

}
