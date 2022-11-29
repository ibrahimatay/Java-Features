package com.ibrahimatay.JEP213MillingProjectCoin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SafeVarargsToSupportPrivateMethods {
    public static void main(String[] args) {
        // Last coin improvement stamped into place; mailing list transitioning to an archive
        // https://mail.openjdk.org/pipermail/coin-dev/2015-April/003487.html

        // java @SafeVarargs why do private methods need to be final
        // https://stackoverflow.com/questions/7728971/java-safevarargs-why-do-private-methods-need-to-be-final

        // Annotation Type SafeVarargs
        // https://docs.oracle.com/javase/9/docs/api/java/lang/SafeVarargs.html

        SafeVarargsToSupportPrivateMethods safeVar = new SafeVarargsToSupportPrivateMethods();
        safeVar.printToListV1(Arrays.asList("Istanbul", "Ankara", "Izmir"));
        // [Istanbul, Ankara, Izmir]
        safeVar.printToListV2(Arrays.asList("Berlin", "Frankfurt", "Hamburg"));
        // [Berlin, Frankfurt, Hamburg]
    }

    private void printToListV1(List<String>... items) {
        for (List<String> item: items) {
            System.out.println(item);
        }
    }
    @SafeVarargs
    private void printToListV2(List<String>... items) {
        for (List<String> item: items) {
            System.out.println(item);
        }
    }
}
