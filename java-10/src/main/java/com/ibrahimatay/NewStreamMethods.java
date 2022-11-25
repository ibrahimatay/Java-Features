package com.ibrahimatay;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class NewStreamMethods {
    public static void main(String[] args) {
        // New Collectors method to accumulate unmodifiable collections
        // https://www.logicbig.com/tutorials/core-java-tutorial/java-10-changes/collectors-changes.html
        List<String> list = List.of("Testing", "Immutable", "List", "From", "Stream", "List", "From", "Stream");

        // toUnmodifiableList method
        list.stream().collect(Collectors.toUnmodifiableList()).forEach(System.out::println);
        /*
        Testing
        Immutable
        List
        From
        Stream
        List
        From
        Stream
        * */

        // toUnmodifiableMap
        Set<String> newImmutableSet = Set.copyOf(list);
        Map<String, Integer> wordsLengths = newImmutableSet.stream()
                .collect(Collectors.toUnmodifiableMap(Function.identity(), word -> word.length()));
        wordsLengths.forEach((word, length) -> System.out.println(word + " -> " + length + " letters"));
        /*
        List -> 4 letters
        Immutable -> 9 letters
        Testing -> 7 letters
        From -> 4 letters
        Stream -> 6 letters
        * */

        // toUnmodifiableSet
        list.stream().collect(Collectors.toUnmodifiableSet()).forEach(System.out::println);
        /*
        List
        Immutable
        Testing
        From
        Stream
        * */

        List<Integer> intList = List.of(1,3,5,7,9);
        Integer firstValue = intList.stream().filter(i-> i %2 ==0).findFirst().orElseThrow();
        /*
        Exception in thread "main" java.util.NoSuchElementException: No value present
            at java.base/java.util.Optional.orElseThrow(Optional.java:377)
            at com.ibrahimatay.NewStreamMethods.main(NewStreamMethods.java:54)
        * */
    }
}
