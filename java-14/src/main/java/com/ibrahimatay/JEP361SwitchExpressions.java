package com.ibrahimatay;

public class JEP361SwitchExpressions {
    public static void main(String[] args) {
        // Switch Expressions (JEP 361)
        // https://javaalmanac.io/features/switch/

        // JEP 361: Switch Expressions
        // https://openjdk.org/jeps/361

        System.out.printf("%1$s HTTP status code refers to a %2$s%n", 100, getHTTPCodeDesc(100));
        System.out.printf("%1$s HTTP status code refers to a %2$s%n", 200, getHTTPCodeDesc(200));
        System.out.printf("%1$s HTTP status code refers to a %2$s%n", 403, getHTTPCodeDesc(403));
        System.out.printf("%1$s HTTP status code refers to a %2$s%n", 0, getHTTPCodeDesc(0));

        /*
        100 HTTP status code refers to a Continue
        200 HTTP status code refers to a OK
        403 HTTP status code refers to a Client Error
        0 HTTP status code refers to a Unknown error
        */
    }

    public static String getHTTPCodeDesc(int code){
        return switch(code) {
            case 100 -> "Continue";
            case 200 -> "OK";
            case 301 -> "Moved Permanently";
            case 302 -> "Found";
            case 400 -> "Bad Request";
            case 500 -> "Internal Server Error";
            case 502 -> "Bad Gateway";
            default                            -> {
                if(code > 100 && code < 200 ) yield "Informational";
                if(code > 200 && code < 300) yield "Successful";
                if(code > 302 && code < 400) yield "Redirection";
                if(code > 400 && code < 500) yield "Client Error";
                if(code > 502 && code < 600 ) yield "Server Error";
                yield "Unknown error";
            }
        };
    }
}
