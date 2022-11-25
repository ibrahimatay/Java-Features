import java.util.Base64;

public class JEP135Base64EncodingDecoding {
    public static void main(String[] args) {
        // JEP 135: Base64 Encoding & Decoding
        // https://openjdk.org/jeps/135

        // base64
        // https://en.wikipedia.org/wiki/Base64

        // Decode Base64 data in Java
        // https://stackoverflow.com/questions/469695/decode-base64-data-in-java
        String originalString = "Java-8 Features";

        System.out.println();
        System.out.println("---------Simple Encoding and Decoding---------");

        Base64.Encoder encoder = Base64.getEncoder();
        String encodedString = encoder.encodeToString(originalString.getBytes());
        System.out.println(String.format("original string (%s) to encoded: %s", originalString, encodedString));
        // original string (Java-8 Features) to encoded: SmF2YS04IEZlYXR1cmVz

        Base64.Decoder decoder = Base64.getDecoder();
        String decodedString = new String(decoder.decode(encodedString.getBytes()));
        System.out.println(String.format("Encoded string (%s) to decoded: %s", encodedString, decodedString));
        // Encoded string (SmF2YS04IEZlYXR1cmVz) to decoded: Java-8 Features

        System.out.println();
        System.out.println("---------URL Encoding and Decoding---------");

        String originalURL = "https://www.ibrahimatay.com/contact/";

        Base64.Encoder urlEncoder = Base64.getUrlEncoder();
        String encodedURL = urlEncoder.encodeToString(originalURL.getBytes());
        System.out.println(String.format("original url (%s) to encoded: %s", originalURL, encodedURL));
        // original url (https://www.ibrahimatay.com/contact/) to encoded: aHR0cHM6Ly93d3cuaWJyYWhpbWF0YXkuY29tL2NvbnRhY3Qv

        Base64.Decoder decoderURL = Base64.getUrlDecoder();
        String decodedURL = new String(decoderURL.decode(encodedURL.getBytes()));
        System.out.println(String.format("Encoded url (%s) to decoded: %s", encodedURL, decodedURL));
        // Encoded url (aHR0cHM6Ly93d3cuaWJyYWhpbWF0YXkuY29tL2NvbnRhY3Qv) to decoded: https://www.ibrahimatay.com/contact/
    }
}
