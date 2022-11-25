package com.ibrahimatay;

import java.util.List;
import java.util.Map;
import java.util.Set;

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
    }
}
