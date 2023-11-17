package com.ibrahimatay;

import java.util.*;

/*
* JEP 431: Sequenced Collections
* https://openjdk.org/jeps/431
* */
public class JEP431SequencedCollections {
    public static void main(String[] args) {
        /*
        interface SequencedSet<E> extends SequencedCollection<E>, Set<E> {
            SequencedSet<E> reversed();
        }
        * */

        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>(List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));

        System.out.println(STR."Fist item: \{linkedHashSet.getFirst()} in LinkedHashSet"); // Fist item: 1=One
        System.out.println(STR."Last item: \{linkedHashSet.getLast()}  in LinkedHashSet"); // Last item: 3=Three

        linkedHashSet.addFirst(0);
        linkedHashSet.addLast(4);

        System.out.println(linkedHashSet.reversed());

        /*
         interface SequencedMap<K,V> extends Map<K,V> {
          // New Methods
          SequencedMap<K,V> reversed();

          SequencedSet<K> sequencedKeySet();
          SequencedCollection<V> sequencedValues();
          SequencedSet<Entry<K,V>> sequencedEntrySet();

          V putFirst(K, V);
          V putLast(K, V);


          // Promoted Methods from NavigableMap<K, V>

          Entry<K, V> firstEntry();
          Entry<K, V> lastEntry();

          Entry<K, V> pollFirstEntry();
          Entry<K, V> pollLastEntry();
        }
        * */

        LinkedHashMap<Integer, String> map = new LinkedHashMap<>();

        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");

        System.out.println(STR."Fist item: \{map.firstEntry()}"); // Fist item: 1=One
        System.out.println(STR."Last item: \{map.lastEntry()}"); // Last item: 3=Three

        System.out.println(map); // {1=One, 2=Two, 3=Three}

        Map.Entry<Integer, String> firstMap = map.pollFirstEntry();
        System.out.println(firstMap); // 1=One
        Map.Entry<Integer, String> lastMap = map.pollLastEntry();
        System.out.println(lastMap); // 3=Three

        System.out.println(map.reversed());

        /*
        interface SequencedCollection<E> extends Collection<E> {
          // New Method

          SequencedCollection<E> reversed();

          // Promoted methods from Deque<E>

          void addFirst(E);
          void addLast(E);

          E getFirst();
          E getLast();

          E removeFirst();
          E removeLast();
        }
        * */

        ArrayList<Integer> arrayList = new ArrayList<>();

        arrayList.add(1);
        arrayList.addFirst(0);
        arrayList.addLast(2);

        System.out.println(STR."Fist item: \{arrayList.getFirst()} in ArrayList"); // Fist item: 0 in ArrayList
        System.out.println(STR."Last item: \{arrayList.getLast()} in ArrayList"); // Last item: 2 in ArrayList
    }
}
