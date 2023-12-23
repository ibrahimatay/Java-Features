import java.util.IntSummaryStatistics;
import java.util.List;

public class NewSummaryStatisticClasses {
    public static void main(String[] args) {
        // Class IntSummaryStatistics
        // https://docs.oracle.com/javase%2F8%2Fdocs%2Fapi%2F%2F/java/util/IntSummaryStatistics.html

        // LongSummaryStatistics
        // https://docs.oracle.com/javase/8/docs/api/java/util/LongSummaryStatistics.html

        // DoubleSummaryStatistics
        // https://docs.oracle.com/javase/8/docs/api/java/util/DoubleSummaryStatistics.html

        List<Integer> integers = List.of(154, 65, 456, 765,23456,34565432);

        IntSummaryStatistics intSummaryStatistics = new IntSummaryStatistics();
        integers.stream().forEach(intSummaryStatistics::accept);

        System.out.println(intSummaryStatistics);
        // IntSummaryStatistics{count=6, sum=34590328, min=65, average=5765054.666667, max=34565432}

        System.out.printf("Max: %d, Min: %d, Ave: %f, Sum: %d",
                intSummaryStatistics.getMax(),
                intSummaryStatistics.getMin(),
                intSummaryStatistics.getAverage(),
                intSummaryStatistics.getSum());

        // Max: 34565432, Min: 65, Ave: 5765054.666667, Sum: 34590328
    }
}
