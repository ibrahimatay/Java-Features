package JEP150DateTimeAPI;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import static java.lang.String.format;

public class InstantExample {
    public static void main(String[] args) {
        // https://docs.oracle.com/javase/8/docs/api/java/time/Instant.html
        // https://stackoverflow.com/questions/32437550/whats-the-difference-between-instant-and-localdatetime

        Instant timestamp = Instant.now();
        System.out.println(format("The current machine timestamp is %s in UTC", timestamp));
        // The current machine timestamp is 2022-05-23T20:10:45.535167800Z in UTC

        ZonedDateTime currentDateTimeZone = timestamp.atZone(ZoneId.of("Europe/Istanbul"));
        System.out.println(format("The current date is %s for Europe/Istanbul time zone", currentDateTimeZone));
        // The current date is 2022-05-23T23:13:56.661158700+03:00[Europe/Istanbul] for Europe/Istanbul time zone
    }
}
