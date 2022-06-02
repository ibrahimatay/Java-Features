package datetime;

import java.time.*;

import static java.lang.String.format;

public class LocalDateTimeExample {
    public static void main(String[] args) {
        // https://docs.oracle.com/javase/8/docs/api/java/time/LocalDateTime.html

        LocalDateTime today = LocalDateTime.now();
        System.out.println(format("Today's date is %s", today));
        // Today's date is 2022-05-23T22:52:43.659402400

        today = LocalDateTime.of(LocalDate.now(), LocalTime.now());
        System.out.println(String.format("My date time is %s", today));
        // My date time is 2022-05-23T22:53:58.520092

        LocalDateTime specificDate  = LocalDateTime.of(2022, Month.FEBRUARY, 2, 0,0);
        System.out.println(format("My specific first date is %s", specificDate ));
        // My specific first date is 2022-02-02T00:00

        // https://docs.oracle.com/javase/8/docs/api/java/time/ZoneId.html
        LocalDateTime timeZoneCurrentDate = LocalDateTime.now(ZoneId.of("Europe/Istanbul"));
        System.out.println(format("The current date is %s for Europe/Istanbul time zone", timeZoneCurrentDate));
        // The current date is 2022-05-23T22:56:44.222150300 for Europe/Istanbul time zone
    }
}
