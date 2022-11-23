package com.ibrahimatay;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class NewCollectionMethods {
    public static void main(String[] args) {
        List<String> list = List.of("Testing", "Immutable", "List", "From", "Stream", "List", "From", "Stream");

        // Copy methods
        List<String> newList = List.copyOf(list);
        newList.forEach(System.out::println);
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

        Set<String> newSet = Set.copyOf(list);
        newSet.forEach(System.out::println);
        /*
        Stream
        From
        Testing
        Immutable
        List
        * */

        Map<String, String> newMap = Map.copyOf(Map.of("k1", "v1", "k2", "v2"));
        newMap.forEach((key, value) -> System.out.println(key + " = " + value));
        /*
        k2 = v2
        k1 = v1
        * */

        // toUnmodifiableList method
        List<String> immutableList = list.stream().collect(Collectors.toUnmodifiableList());
        immutableList.forEach(System.out::println);
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
    }
}
