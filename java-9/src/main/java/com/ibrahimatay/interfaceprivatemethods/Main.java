package com.ibrahimatay.interfaceprivatemethods;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        BasketPriceCalculator basketPriceCalculator = new BasketPriceCalculator();
        String label =basketPriceCalculator.getProductLabel("Books", 12.56,89.12,78.12);
        System.out.println(label);
    }
}

interface PriceCalculator{
    default String getProductLabel(String name, double...price) {
        return String.format("Product name is %s and total price: %s", name, add(price));
    }
    private double add(double...price) {
        return Arrays.stream(price).sum();
    }
}

class BasketPriceCalculator implements PriceCalculator {

}