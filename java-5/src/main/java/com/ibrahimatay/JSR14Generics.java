package com.ibrahimatay;

import java.util.ArrayList;

public class JSR14Generics {
    public static void main(String[] args) {
        // JSR 14: Add Generic Types To The JavaTM Programming Language
        // https://jcp.org/en/jsr/detail?id=14
        ArrayList list01 = new ArrayList();
        list01.add(1);
        //list01.add(2.0); // Will throw exception in the for loop
        list01.add(3);

        int total01 = 0;
        for (Object val: list01) {
            total01+=Integer.valueOf(val.toString());
        }

        System.out.println(String.format("Total01:%s", total01));

        ArrayList<Integer> list02 = new ArrayList<>();
        list02.add(1);
        list01.add(3);
        list02.add(5);

        int total02 = 0;
        for (Integer val: list02) {
            total02+=val;
        }

        System.out.println(String.format("Total02:%s", total02));
    }
}
