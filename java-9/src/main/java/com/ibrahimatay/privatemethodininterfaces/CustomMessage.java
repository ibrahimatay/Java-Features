package com.ibrahimatay.privatemethodininterfaces;

/*
What’s New for the Java Language in JDK 9
https://docs.oracle.com/javase/9/whatsnew/toc.htm#JSNEW-GUID-825576B5-203C-4C8D-85E5-FFDA4CA0B346

JEP 213: Milling Project Coin
https://openjdk.org/jeps/213
* */

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

public class CustomMessage implements Message{
    @Override
    public void method1() {
        System.out.println("abstract method");
    }

    public static void main(String[] args) {
        Message message = new CustomMessage();
        message.method1();
        message.method2();
        Message.method3();

        /*
        print out:

        abstract method
        private method
        private static method
        default method
        private static method
        static method
        *
        * */
    }
}
