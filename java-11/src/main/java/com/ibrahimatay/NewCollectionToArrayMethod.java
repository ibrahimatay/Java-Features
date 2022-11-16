package com.ibrahimatay;

import java.util.List;

public class NewCollectionToArrayMethod {
    public static void main(String[] args) {
        // Convert list to array in Java [duplicate]
        // https://stackoverflow.com/questions/9572795/convert-list-to-array-in-java

        // toArray
        //https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Collection.html#toArray()
        List<String> cities = List.of("Istanbul", "Izmir", "Ankara", "Berlin", "Frankfurt");
        String[] array01 = cities.toArray(String[]::new);
        String[] array02 = cities.toArray(new String[0]);

        // A[] toArray(IntFunction<A[]> generator)
        List<Person> people = List.of(new Person("Ibrahim", Gender.MALE), new Person("Aslı",Gender.FEMALE));
        Person[] men = people.stream().filter(p-> p.gender == Gender.MALE).toArray(Person[]::new);
    }
}

class Person {

    public final String name;
    public final Gender gender;

    Person(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
    }
}

enum Gender {
    MALE, FEMALE
}
