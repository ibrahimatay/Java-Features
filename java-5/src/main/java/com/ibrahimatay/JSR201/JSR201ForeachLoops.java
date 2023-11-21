package com.ibrahimatay.JSR201;

import java.util.ArrayList;
import java.util.Iterator;

public class JSR201ForeachLoops {
    public static void main(String[] args) {
        String[] cities = {"Istanbul", "Berlin", "London"};
        for (int i = 0; i < cities.length; i++) {
            System.out.println(cities[i]);
        }

        for(String city: cities) {
            System.out.println(city);
        }

        ArrayList list = new ArrayList();
        list.add(3.14);
        list.add(42);
        list.add("Istanbul");

        for (Iterator iterator = list.iterator(); iterator.hasNext();){
            System.out.println(iterator.next());
        }

        for (Object item:list) {
            System.out.println(item);
        }

        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(3);
        numbers.add(5);
        numbers.add(7);
        numbers.add(9);
        Integer total = 0;
        for (Integer val: numbers) {
            total+=val;
        }

        System.out.println(String.format("Total:%s", total));
    }
}
