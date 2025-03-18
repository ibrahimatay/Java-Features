import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Gatherers;
import java.util.stream.Stream;

public class JEP485StreamGatherers {
    public static void main(String[] args) {
        // Stream Gatherers (JEP 485)
        // https://openjdk.java.net/jeps/485

        // Custom Intermediate Operation distinctBy
        /*
        Stream.of("foo", "bar", "baz", "quux")
                .gather(Gatherers.distinctBy(String::length))
                .toList();
        */

        // Creating Fixed-size Windows
        /*
        Stream.iterate(0, i -> i + 1)
                .gather(Gatherers.windowFixed(3))
                .limit(2)
                .toList();
         */

        // Parallel Processing with selectOne
        /*
        Stream.generate(() -> ThreadLocalRandom.current().nextInt())
                .limit(1000)
                .parallel()
                .gather(Gatherers.selectOne(Math::max))
                .findFirst();
         */
    }
}
