package com.ibrahimatay.JSR201;

public class JSR201VarArgs {
    public static void main(String[] args) {
        int[] numbers = {1, 7, 2, 4, 5};

        System.out.println(max(numbers));
        System.out.println(max2(numbers));
    }

    static int max(int[] numbers) {
        int max = numbers[0];
        for (int val: numbers) {
            if(val > max) max = val;
        }

        return max;
    }

    static int max2(int... numbers) {
        int max = numbers[0];
        for (int val: numbers) {
            if(val > max) max = val;
        }

        return max;
    }
}
