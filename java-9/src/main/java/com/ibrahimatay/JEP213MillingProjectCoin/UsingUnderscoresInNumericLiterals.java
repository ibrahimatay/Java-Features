package com.ibrahimatay.JEP213MillingProjectCoin;

public class UsingUnderscoresInNumericLiterals {
    public static void main(String[] args) {
        // Underscores in Numeric Literals
        // https://docs.oracle.com/javase/7/docs/technotes/guides/language/underscores-literals.html

        // int x1 = _52;           // This is an identifier, not a numeric literal, compilation error
        int x2 = 5_2;              // OK (decimal literal)
        System.out.println(x2);    // 52

        double x3 = 1_2_3.4_5_6;
        System.out.println(x3);    // 123.456

        // int x4 = 052_; // Invalid; cannot put underscores at the end of a number

        //long socialSecurityNumber1 = 999_99_9999_L; // Invalid; cannot put underscores

        long creditCardNumber = 6684_5678_9012_3456L;
        System.out.println(creditCardNumber); // 6684567890123456
    }
}
