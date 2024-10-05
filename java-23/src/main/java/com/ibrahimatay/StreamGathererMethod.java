package com.ibrahimatay;

import java.util.List;
import java.util.stream.Gatherers;
import java.util.stream.Stream;

public class StreamGathererMethod {
    public static void main(String[] args) {
        // JEP 473: Stream Gatherers (Second Preview)
        // https://openjdk.org/jeps/473

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<List<Integer>> pairedEvenSquares = numbers.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * n)
                .gather(Gatherers.windowFixed(2))
                .toList();

        System.out.println(pairedEvenSquares);
        // [[4, 16], [36, 64], [100]]

        List<List<Integer>> windowsOfThree
                = Stream.of(0,1,2,3,4,5,6,7)
                .gather(Gatherers.windowFixed(3))
                .toList();

        System.out.println(windowsOfThree);
        // [[0, 1, 2], [3, 4, 5], [6, 7]]
    }
}
