package com.ibrahimatay.JEP213MillingProjectCoin;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TryWithResources {
    public static void main(String[] args) {
        // https://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html

        // Update java.base module to use new try-with-resources statement
        // https://bugs.openjdk.org/browse/JDK-8068948

        // Use resource in try with resource statement that was created before, Stackoverflow
        // https://stackoverflow.com/questions/41206524/use-resource-in-try-with-resource-statement-that-was-created-before

        String path = "";
        try (FileReader fr = new FileReader(path);
             BufferedReader br = new BufferedReader(fr)) {
            br.readLine();
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException");
        } catch (IOException e) {
            System.out.println("IOException");
        }
    }
}
