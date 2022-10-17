package com.ibrahimatay;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionsCopyOf {
    public static void main(String[] args) {
        List<String> mutableList = Arrays.asList("New", "Method", "To", "Copy");

        // Copy methods
        List<String> immutableList = List.copyOf(mutableList);
        immutableList.forEach(System.out::println);

        Set<String> immutableSet = Set.copyOf(mutableList);
        immutableSet.forEach(System.out::println);

        Map<String, String> immutableMap = Map.copyOf(Map.of("k1", "v1", "k2", "v2"));
        immutableMap.forEach((key, value) -> System.out.println(key + " = " + value));
    }
}
