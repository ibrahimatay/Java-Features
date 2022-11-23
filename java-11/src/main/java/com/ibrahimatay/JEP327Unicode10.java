package com.ibrahimatay;

public class JEP327Unicode10 {
    // JEP 327: Unicode 10
    // https://openjdk.org/jeps/327

    // About the Unicode® Standard
    // http://www.unicode.org/standard/standard.html

    // Unicode
    // https://docs.oracle.com/javase/tutorial/i18n/text/unicode.html

    // java.lang.Character
    // https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/Character.html

    // Emoji Unicode Tables
    // https://apps.timwhitlock.info/emoji/tables/unicode
    public static void main(String[] args) {
        System.out.println("name  = " + Character.getName(0x1F929));
        System.out.println("block = " + Character.UnicodeBlock.of(0x1F929));
        // name  = GRINNING FACE WITH STAR EYES
        // block = SUPPLEMENTAL_SYMBOLS_AND_PICTOGRAPHS

        System.out.println("name  = " + Character.getName(0x1F92A));
        System.out.println("block = " + Character.UnicodeBlock.of(0x1F92A));
        // name  = GRINNING FACE WITH ONE LARGE AND ONE SMALL EYE
        // block = SUPPLEMENTAL_SYMBOLS_AND_PICTOGRAPHS

        System.out.println("name  = " + Character.getName(0x2705));
        System.out.println("block = " + Character.UnicodeBlock.of(0x2705));
        //name  = WHITE HEAVY CHECK MARK
        // block = DINGBATS

        System.out.println("name  = " + Character.getName(0x1F680));
        System.out.println("block = " + Character.UnicodeBlock.of(0x1F680));
        // name  = ROCKET
        // block = TRANSPORT_AND_MAP_SYMBOLS
    }
}
