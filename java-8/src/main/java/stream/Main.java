package stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        // https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html

        Stream<String> streamEmpty = Stream.empty(); // empty stream

        // map method
        System.out.println("\n------map method------\n");
        List<Integer> numbers = Arrays.asList(1,3,5,7,9);
        numbers.stream().map(x-> x*2).collect(Collectors.toList()).forEach(System.out::println);

        // allMatch method
        System.out.println("\n------allMatch method------\n");
        boolean hasUnevenNumber = numbers.stream().allMatch(n-> n % 2 == 0);
        String arrays = numbers.stream().map(x-> x.toString()).collect(Collectors.joining(","));
        System.out.println(String.format("There are even numbers (%b) in that array (%s)", hasUnevenNumber, arrays));

        // filter method
        System.out.println("\n------filter method------\n");
        List<String> names = Arrays.asList("Reflection", "Collection", "Stream");
        names.stream().filter(x-> x.contains("i")).collect(Collectors.toList()).forEach(System.out::println);

        // sorted method
        // https://stackoverflow.com/questions/40517977/sorting-a-list-with-stream-sorted-in-java
        System.out.println("\n------sorted method------\n");
        names.stream().sorted(Comparator.comparingLong(String::length)).collect(Collectors.toList()).forEach(System.out::println);

        List<Person> people = Arrays.asList(
                new Person("Barbara Liskov", 1939 ),
                new Person("Grace Hopper", 1906),
                new Person("Dennis Ritchie", 1941),
                new Person("Donald Knuth", 1938 ),
                new Person("Edsger W. Dijkstra", 1930),
                new Person("James Gosling", 1955 )
        );

        // people.stream().sorted(Comparator.comparingInt(Person::getBornOfYear).reversed()).forEach(System.out::println);
        people.stream().sorted(Comparator.comparingInt(Person::getBornOfYear)).forEach(System.out::println);

        // count method
        System.out.println("\n------count method------\n");
        long count = people.stream().filter(p-> p.getBornOfYear() >1940).count();
        System.out.println(String.format("%d people were born after %d", count, 1940));

        // iterate, skip & limit methods
        System.out.println("\n------iterate, skip & limit methods------\n");
        Stream<Integer> infiniteStream = Stream.iterate(100, i -> i*5);
        infiniteStream.skip(10).limit(5).forEach(System.out::println);

        // generate method
        System.out.println("\n------generate method------\n");
        Stream.generate(Math::random).limit(10).forEach(System.out::println);

        // findFirst method (return by Optional type)
        System.out.println("\n------findFirst method (return by Optional type)------\n");
        Person selectedPerson = people.stream().filter(x-> x.getBornOfYear() == 1938).findFirst().orElse(null);
        System.out.println(selectedPerson);

        // min method
        System.out.println("\n------min method------\n");
        Person minBornOfYear = people.stream().min(Comparator.comparingInt(Person::getBornOfYear)).orElse(null);
        System.out.println(minBornOfYear);

        // max method
        System.out.println("\n------min method------\n");
        Person maxBornOfYear = people.stream().max(Comparator.comparingInt(Person::getBornOfYear)).orElse(null);
        System.out.println(maxBornOfYear);

        // distinct method
        System.out.println("\n------distinct method------\n");
        System.out.println("Example 1:\n");

        List<Integer> duplicatedNumbers = Arrays.asList(1,2,2,5,7,8,9,2,6,7,10,11,1,23,78,7);
        duplicatedNumbers.stream().distinct().sorted().forEach(System.out::println);

        System.out.println("\nExample 2:\n");
        // https://stackoverflow.com/questions/23699371/java-8-distinct-by-property
        List<Scientist> duplicatedScientists = Arrays.asList(
                new Scientist("Barbara Liskov"),
                new Scientist("Grace Hopper"),
                new Scientist("Dennis Ritchie"),
                new Scientist("Donald Knuth"),
                new Scientist("Edsger W. Dijkstra"),
                new Scientist("James Gosling"),
                new Scientist("Grace Hopper"),
                new Scientist("Dennis Ritchie"),
                new Scientist("Donald Knuth"),
                new Scientist("Edsger W. Dijkstra"),
                new Scientist("Grace Hopper"),
                new Scientist("Dennis Ritchie"),
                new Scientist("Donald Knuth"),
                new Scientist("Edsger W. Dijkstra")
        );

        duplicatedScientists.stream().distinct().forEach(System.out::println);

        // Collectors.joining & map methods
        System.out.println("\n------Collectors.joining & map methods------\n");
        String computerScientistNames = people.stream().map(Person::getName).collect(Collectors.joining(","));
        System.out.println(computerScientistNames);

        // Collectors.toSet methods (same distinct)
        System.out.println("\n------Collectors.toSet method------\n");
        duplicatedNumbers.stream().collect(Collectors.toSet()).forEach(System.out::println);

        // map (with model mapping)
        // https://stackoverflow.com/questions/54834550/simplified-java-8-stream-map-entity-to-model
        System.out.println("\n------map (with model mapping) method------\n");
        people.stream().map(person -> {
            return new Scientist(person.getName());
        }).forEach(System.out::println);

        List<Book> books = Arrays.asList(
                new Book("Effective Java", 32.47),
                new Book("Clean Code", 44.99),
                new Book("The Pragmatic Programmer", 30.18),
                new Book("The Clean Coder", 37.29),
                new Book("Working Effectively with Legacy Code", 31.47)
        );

        // DoubleSummaryStatistics
        // https://stackoverflow.com/questions/3693079/problem-with-system-out-printf-command-in-java
        System.out.println("\n------DoubleSummaryStatistics------\n");
        DoubleSummaryStatistics statistics = books.stream().collect(Collectors.summarizingDouble(Book::getUnitPrice));
        System.out.println(String.format("Book count: %d", statistics.getCount()));
        System.out.println(String.format("Book total unit price: %f", statistics.getSum()));
        System.out.println(String.format("Book max unit price: %f", statistics.getMax()));
        System.out.println(String.format("Book min unit price: %f", statistics.getMin()));
        System.out.println(String.format("Book Average unit price: %f", statistics.getAverage()));
    }

    static Stream<String> streamOf(List<String> items) {
        return items == null || items.isEmpty() ? Stream.empty() : items.stream();
    }
}

class Person {
    private final String name;
    private final Integer bornOfYear;
    public Person(String name, Integer bornOfYear) {
        this.name = name;
        this.bornOfYear = bornOfYear;
    }

    public String getName() {
        return name;
    }

    public Integer getBornOfYear() {
        return bornOfYear;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", bornOfYear=" + bornOfYear +
                '}';
    }
}

class Scientist {
    private String name;
    public Scientist(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Scientist{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Scientist scientist = (Scientist) o;
        return Objects.equals(name, scientist.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

class Book {
    private String name;
    private Double unitPrice;

    public Book(String name, Double unitPrice) {
        this.name = name;
        this.unitPrice = unitPrice;
    }

    public String getName() {
        return name;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", unitPrice=" + unitPrice +
                '}';
    }
}