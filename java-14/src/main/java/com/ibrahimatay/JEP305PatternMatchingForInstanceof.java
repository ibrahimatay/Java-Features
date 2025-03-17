package com.ibrahimatay;

public class JEP305PatternMatchingForInstanceof {
    public static void main(String[] args) {
        // JEP 305: Pattern Matching for instanceof (Preview)
        // https://openjdk.org/jeps/305

        Object obj = "JEP305P";
        if (obj instanceof String) {
            String str = (String) obj;
            System.out.println(str.toUpperCase());
        }

        if (obj instanceof String str){
            System.out.println(str.toUpperCase());
        }
    }
}
