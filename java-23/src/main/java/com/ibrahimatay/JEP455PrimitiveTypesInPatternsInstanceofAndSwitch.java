package com.ibrahimatay;

public class JEP455PrimitiveTypesInPatternsInstanceofAndSwitch {
    // JEP 455: Primitive Types in Patterns, instanceof, and switch
    // https://openjdk.org/jeps/455

    public static void main(String[] args) {
        System.out.printf("%1$s HTTP status code refers to a %2$s%n", 100, getHTTPCodeDesc(100));
        System.out.printf("%1$s HTTP status code refers to a %2$s%n", 200, getHTTPCodeDesc(200));
        System.out.printf("%1$s HTTP status code refers to a %2$s%n", 403, getHTTPCodeDesc(403));
        System.out.printf("%1$s HTTP status code refers to a %2$s%n", 0, getHTTPCodeDesc(0));

        // 100 HTTP status code refers to a Continue
        // 200 HTTP status code refers to a OK
        // 403 HTTP status code refers to a Client Error
        // 0 HTTP status code refers to a Unknown error

        // An employee is calling me. class com.ibrahimatay.Employee
        whoCallMe(new Employee());

        // An employee is calling me. class com.ibrahimatay.Boss
        whoCallMe(new Boss());

        // Wrong number.
        whoCallMe(null);
    }

    public static void whoCallMe(Human human) {
        if (human instanceof Employee employee) {
            System.out.printf("An employee is calling me. %1$s%n", employee.getClass());
            return;
        }

        if (human instanceof Boss boss) {
            System.out.printf("An employee is calling me. %1$s%n", boss.getClass());
            return;
        }

        System.out.println("Wrong number.");
    }

    public static String getHTTPCodeDesc(int code) {
        return switch(code) {
            case 100 -> "Continue";
            case 200 -> "OK";
            case 301 -> "Moved Permanently";
            case 302 -> "Found";
            case 400 -> "Bad Request";
            case 500 -> "Internal Server Error";
            case 502 -> "Bad Gateway";
            case int i when i > 100 && i < 200 -> "Informational";
            case int i when i > 200 && i < 300 -> "Successful";
            case int i when i > 302 && i < 400 -> "Redirection";
            case int i when i > 400 && i < 500 -> "Client Error";
            case int i when i > 502 && i < 600 -> "Server Error";
            default                            -> "Unknown error";
        };
    }
}

interface Human {}
class Employee implements Human {}
class Boss implements Human {}
