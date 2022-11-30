package com.ibrahimatay.JEP213MillingProjectCoin;

import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class PrivateMethodInInterfaces implements Calculator, Message{
    public static void main(String[] args) {
        // JEP 213: Milling Project Coin
        // https://openjdk.org/jeps/213

        // What’s New for the Java Language in JDK 9
        // https://docs.oracle.com/javase/9/whatsnew/toc.htm#JSNEW-GUID-825576B5-203C-4C8D-85E5-FFDA4CA0B346

        PrivateMethodInInterfaces calculator = new PrivateMethodInInterfaces();

        int sumOfEvens = calculator.addEvenNumbers(1,2,3,4,5,6,7,8,9);
        System.out.println(sumOfEvens);
        // 20

        int sumOfOdds = calculator.addOddNumbers(1,2,3,4,5,6,7,8,9);
        System.out.println(sumOfOdds);
        // 25

        PrivateMethodInInterfaces message = new PrivateMethodInInterfaces();
        message.method1();
        message.method2();
        Message.method3();
        // abstract method
        // private method
        // private static method
        // default method
        // private static method
        // static method
    }

    @Override
    public void method1() {
        System.out.println("abstract method");
    }
}
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

interface Message {
    public abstract void method1();

    public default void method2() {
        method4(); // private method inside default method
        method5(); // static method inside other non-static method
        System.out.println("default method");
    }

    public static void method3() {
        method5(); //static method inside other static method
        System.out.println("static method");
    }

    private void method4() {
        System.out.println("private method");
    }

    private static void method5() {
        System.out.println("private static method");
    }
}
