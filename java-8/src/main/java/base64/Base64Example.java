package base64;

import java.util.Base64;

public class Base64Example {
    public static void main(String[] args) {
        String originalString = "Java-8 Features";

        System.out.println();
        System.out.println("---------Simple Encoding and Decoding---------");

        Base64.Encoder encoder = Base64.getEncoder();
        String encodedString = encoder.encodeToString(originalString.getBytes());
        System.out.println(String.format("original string (%s) to encoded: %s", originalString, encodedString));

        Base64.Decoder decoder = Base64.getDecoder();
        String decodedString = new String(decoder.decode(encodedString.getBytes()));
        System.out.println(String.format("Encoded string (%s) to decoded: %s", encodedString, decodedString));

        System.out.println();
        System.out.println("---------URL Encoding and Decoding---------");

        String originalURL = "https://www.ibrahimatay.com/contact/";

        Base64.Encoder urlEncoder = Base64.getUrlEncoder();
        String encodedURL = urlEncoder.encodeToString(originalURL.getBytes());
        System.out.println(String.format("original url (%s) to encoded: %s", originalURL, encodedURL));

        Base64.Decoder decoderURL = Base64.getUrlDecoder();
        String decodedURL = new String(decoderURL.decode(encodedURL.getBytes()));
        System.out.println(String.format("Encoded url (%s) to decoded: %s", encodedURL, decodedURL));
    }
}
