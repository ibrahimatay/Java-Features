package com.ibrahimatay;

public class JSR201Autoboxing {

    public static void foo01(A a) {
        System.out.println("foo01 called with " + a);
    }

    public static void foo02(A a, B b) {
        System.out.println("foo02 called with " + a + " and " + b);
    }

    public static void foo03(int value) {
        System.out.println("foo3 called witih " + value);
    }

    public static Integer foo04(int value) {
        System.out.println("foo4 called with " + value);
        return 5;
    }

    public static void invoke(String method, Object[] args) {
        if (method.equals("foo01")) {
            foo01((A)args[0]);
        }

        if (method.equals("foo02")) {
            foo02((A) args[0], (B) args[1]);
        }

        if (method.equals("foo03")) {
            foo03(((Integer)(args[0])).intValue());
        }
    }

    public static void main(String[] args) {
        invoke("foo01", new Object[] {new A()});
        invoke("foo02", new Object[]{new A(), new B()});

        invoke("foo03", new Object[] { 3 }); // Until Java 1.4

        //Now
        invoke("foo3", new Object[]{ 3 }); // In Java 5

        int someValue = foo04(4);
        System.out.println("Result of call to foo4 " + someValue);
    }
}

class A {

}

class B {

}
