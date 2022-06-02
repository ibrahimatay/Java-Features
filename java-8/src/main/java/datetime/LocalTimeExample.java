package datetime;

import java.time.LocalTime;
import java.time.ZoneId;

public class LocalTimeExample {
    public static void main(String[] args) {
        // https://docs.oracle.com/javase/8/docs/api/java/time/LocalTime.html

        LocalTime time = LocalTime.now();
        System.out.println(String.format("Local current time is %s", time));
        // Local current time is 11:08:00.881030200

        LocalTime specificTime = LocalTime.of(11,8,0,0);
        System.out.println(String.format("My specific time is %s", specificTime));
        // My specific time is 11:08

        // https://docs.oracle.com/javase/8/docs/api/java/time/ZoneId.html
        LocalTime timeZoneCurrentTime = LocalTime.now(ZoneId.of("Europe/Istanbul"));
        System.out.println(String.format("The current time is %s for Europe/Istanbul time zone", timeZoneCurrentTime));
        // The current time is 11:12:01.775280700 for Europe/Istanbul time zone

        LocalTime specificSecondTime = LocalTime.ofSecondOfDay(10000);
        System.out.println(String.format("The 10000th second time is %s", specificSecondTime));
        // The 10000th second time is 02:46:40
    }
}
