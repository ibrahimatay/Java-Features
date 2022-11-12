package com.ibrahimatay;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.stream.Collectors;

public class LocalVar {
    public static void main(String[] args) {
        // JEP 323: Local-Variable Syntax for Lambda Parameters
        // https://openjdk.org/jeps/323

        // Local Variable Type Inference
        // https://docs.oracle.com/en/java/javase/13/language/local-variable-type-inference.html

        // Local Variable Type Inference Style Guidelines
        // https://openjdk.org/projects/amber/guides/lvti-style-guide

        // Update on JEP-286 (Local Variable Type Inference)
        // https://mail.openjdk.org/pipermail/platform-jep-discuss/2016-December/000066.html

        var alphabet = Arrays.asList("A", "B", "C", "D", "E");
        var result01 = alphabet.stream()
                .map(x-> x.toLowerCase())
                .collect(Collectors.joining(","));
        System.out.println(result01);
        // a,b,c,d,e

        var result02 = alphabet.stream()
                .map((var x) -> x.toLowerCase())
                .collect(Collectors.joining(","));
        System.out.println(result02);
        // a,b,c,d,e

        var result03 = alphabet.stream()
                .map((@Nullable var x) -> x.toLowerCase())
                .collect(Collectors.joining(","));
        System.out.println(result03);
        // a,b,c,d,e
    }
}
