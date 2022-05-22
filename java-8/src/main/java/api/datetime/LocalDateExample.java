package api.datetime;

import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;

public class LocalDateExample {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        System.out.println(String.format("Today's date is %s", today));
        // Today's date is 2022-05-22

        LocalDate firstDay2022 = LocalDate.of(2022, Month.APRIL, 1);
        System.out.println(String.format("My specific first date is %s", firstDay2022));
        // My specific first date is 2022-04-01

        // https://docs.oracle.com/javase/8/docs/api/java/time/ZoneId.html
        LocalDate timeZoneCurrentDate = LocalDate.now(ZoneId.of("Europe/Istanbul"));
        System.out.println(String.format("The current date is %s for Europe/Istanbul time zone", timeZoneCurrentDate));
        //The current date is 2022-05-22 for Europe/Istanbul time zone

        LocalDate dateFromBase = LocalDate.ofEpochDay(365);
        System.out.println(String.format("365th day from base date is %s", dateFromBase));
        // 365th day from base date is 1971-01-01

        LocalDate hundredDay2022 = LocalDate.ofYearDay(2022, 100);
        System.out.println(String.format("The 100th day of 2022 date is %s", hundredDay2022));
        // The 100th day of 2022 date is 2022-04-10
    }
}
