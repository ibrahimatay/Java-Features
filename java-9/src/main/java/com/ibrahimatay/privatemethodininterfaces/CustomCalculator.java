package com.ibrahimatay.privatemethodininterfaces;

import java.util.function.IntPredicate;
import java.util.stream.IntStream;

/*
What’s New for the Java Language in JDK 9
https://docs.oracle.com/javase/9/whatsnew/toc.htm#JSNEW-GUID-825576B5-203C-4C8D-85E5-FFDA4CA0B346

JEP 213: Milling Project Coin
https://openjdk.org/jeps/213
* */

interface Calculator {
    default int addEvenNumbers(int... nums) {
        return add(n -> n % 2 == 0, nums);
    }

    default int addOddNumbers(int... nums) {
        return add(n -> n % 2 != 0, nums);
    }
    private int add(IntPredicate predicate, int... nums) {
        return IntStream.of(nums).filter(predicate).sum();
    }
}

public class CustomCalculator implements Calculator {
    public static void main(String[] args) {
        Calculator calculator = new CustomCalculator();

        int sumOfEvens = calculator.addEvenNumbers(1,2,3,4,5,6,7,8,9);
        System.out.println(sumOfEvens);

        int sumOfOdds = calculator.addOddNumbers(1,2,3,4,5,6,7,8,9);
        System.out.println(sumOfOdds);
    }
}
