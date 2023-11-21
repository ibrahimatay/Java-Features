package com.ibrahimatay;

import java.util.OptionalInt;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UnicodeEmojiMethods {

    // Unicode Emoji Properties
    // https://bugs.openjdk.org/browse/JDK-8303018

    // JDK 21 JavaDoc for java.lang.Character
    // https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/Character.html

    // Unicode® Technical Standard #Emoji Character Properties
    // https://unicode.org/reports/tr51/#Emoji_Properties_and_Data_Files

    public static void main(String[] args) {
        String welcomeMsg = "Hey Java Developers! ☕️";

        if(welcomeMsg.codePoints().anyMatch(Character::isEmoji)) {
            System.out.println("Message contains an emoji!");
        }

        Matcher matcher = Pattern.compile("\\p{IsEmoji}").matcher(welcomeMsg);
        if(matcher.find()) {
            System.out.println("Message contains an emoji!");
        }

        Matcher matcher_modifier_base = Pattern.compile("\\p{IsEmoji_Modifier_Base}").matcher(welcomeMsg);
        if(matcher_modifier_base.find()) {
            System.out.println("Message contains an emoji modifier base!");
        }

        OptionalInt emojiOptional = welcomeMsg.codePoints().filter(Character::isEmoji).findFirst();
        if (emojiOptional.isPresent()) {
            int emojiCodePoint = emojiOptional.getAsInt();
            if (Character.isEmojiModifierBase(emojiCodePoint)) {
                System.out.println("Emoji can be modified");
                if (Character.isEmojiModifier(emojiCodePoint)) {
                    System.out.println("Emoji is modified");
                } else {
                    System.out.println("Emoji has not been modified");
                }
            } else {
                System.out.println("Emoji cannot be modified");
            }
        } else {
            System.out.println("No emoji");
        }
    }
}
