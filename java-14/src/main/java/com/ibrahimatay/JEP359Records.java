package com.ibrahimatay;

public class JEP359Records {

    public static void main(String[] args) {
        // JEP 359: Records (Preview)
        // https://openjdk.org/jeps/359
    }
}

class Person{
    private final String name;
    private final int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

// record Person(String name, int age) {}


