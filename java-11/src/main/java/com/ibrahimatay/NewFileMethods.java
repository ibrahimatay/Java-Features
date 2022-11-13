package com.ibrahimatay;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class NewFileMethods {
    public static void main(String[] args) {
        // java.io.File
        // https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/io/File.html

        // java.nio.file.Files.writeString writes garbled UTF-16 instead of UTF-8
        // https://bugs.openjdk.org/browse/JDK-8209576

        // Add methods to Files for reading/writing a string from/to a file
        // https://bugs.openjdk.org/browse/JDK-8202055

        // Reading and writing file in ISO-8859-1 encoding?
        // https://stackoverflow.com/questions/63363359/reading-and-writing-file-in-iso-8859-1-encoding

        readString();
        readWriteString();
        readWriteStringWithCharset();
    }

    private static void readString() {
        try {
            Path path = Paths.get("test01.txt");
            String data = Files.readString(path);
            System.out.println(data);
            System.out.println(data.getClass().getName());
        }catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void readWriteString() {
        try {
            Path path = Paths.get("test02.txt");
            path = Files.writeString(path, "Welcome to Istanbul!!");
            String data = Files.readString(path);
            System.out.println(data);
        }catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void readWriteStringWithCharset() {
        try {
            Path path = Paths.get("test03.txt");
            // java.nio.charset.StandardCharsets
            // https://docs.oracle.com/javase/7/docs/api/java/nio/charset/StandardCharsets.html
            path = Files.writeString(path, "Welcome to Istanbul!!", Charset.forName(StandardCharsets.UTF_8.name()));
            String data = Files.readString(path);
            System.out.println(data);
        }catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
