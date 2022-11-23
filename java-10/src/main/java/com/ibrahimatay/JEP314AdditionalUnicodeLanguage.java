package com.ibrahimatay;

import java.text.DateFormat;
import java.time.DayOfWeek;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;

public class JEP314AdditionalUnicodeLanguage {
    public static void main(String[] args) {
        // JEP 314: Additional Unicode Language-Tag Extensions
        // https://openjdk.org/jeps/314

        /*
        ca (calendar) -> gregorian, buddhist, chinese
        nu (numbers) -> arab, roman
        cu (currency type) -> ISO 4217 currency codes
        fw (first day of week) -> sun (Sunday), mon (Monday)
        rg (region override) -> uszzzz (US units)

        https://en.wikipedia.org/wiki/List_of_tz_database_time_zones
        tz (time zone) -> uslax (Los Angeles), deber (Berlin)
        * */

        Locale locale = Locale.forLanguageTag("tr-TR-cu-tr-fw-mon-tz-tr");
        Currency currency = Currency.getInstance(locale); // TRY
        Calendar calendar = Calendar.getInstance(locale);
        DayOfWeek firstDayOfWeek = DayOfWeek.of((calendar.getFirstDayOfWeek() + 5) % 7 + 1);

        DateFormat dateFormat = DateFormat.getTimeInstance(DateFormat.LONG, locale);
        String time = dateFormat.format(new Date());

        System.out.println("currency       = " + currency);
        System.out.println("firstDayOfWeek = " + firstDayOfWeek);
        System.out.println("time           = " + time);

        /*
        currency       = TRY
        firstDayOfWeek = MONDAY
        time           = 23:37:22 TRT
        * */
    }
}
