package functionalinterface;

public class Main {
    public static void main(String[] args) {
        String word = "Aslı";
        StringLength<String, Integer> length = s -> s.length();
        Integer applyLength = length.apply(word);

        System.out.println(String.format("String (%s) length is %d", word, applyLength));

        FirstCharacter<String, String> firstCharacter = s -> s.substring(0,1);
        String applyFirstCharacter = firstCharacter.apply(word);

        System.out.println(String.format("String (%s) first character is %s", word, applyFirstCharacter));
    }
}

@FunctionalInterface
interface StringLength<T,R> {
    R apply(T t);
}

@FunctionalInterface
interface FirstCharacter<T, R> {
    R apply(T t);
}
