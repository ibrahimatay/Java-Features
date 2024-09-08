package com.ibrahimatay;

import java.text.CompactNumberFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.*;

public class CompactNumberFormatting {

    // Compact Number Formatting support
    // https://bugs.openjdk.org/browse/JDK-8188147

    // Compact Number Formatting Comes to JDK 12
    // https://marxsoftware.blogspot.com/2019/01/jdk12-custom-number-formatting.html

    public static void main(String[] args) throws ParseException {
        NumberFormat fmt = NumberFormat.getCompactNumberInstance(Locale.US, NumberFormat.Style.LONG);

        System.out.println(fmt.parse("100"));
        System.out.println(fmt.parse("1 thousand"));
        System.out.println(fmt.parse("10 thousand"));
        System.out.println(fmt.parse("100 thousand"));

        /*
        Result:
            100
            1000
            10000
            100000
         */
        NumberFormat minimumFractionDigits = NumberFormat.getCompactNumberInstance(Locale.US, NumberFormat.Style.SHORT);
        minimumFractionDigits.setMinimumFractionDigits(3);

        System.out.println(minimumFractionDigits.format(10000));
        System.out.println(minimumFractionDigits.format(10012));
        System.out.println(minimumFractionDigits.format(100201));
        System.out.println(minimumFractionDigits.format(1111111));

        /*
        Result: 
            10.000K
            10.012K
            100.201K
            1.111M
        */
    }
}

