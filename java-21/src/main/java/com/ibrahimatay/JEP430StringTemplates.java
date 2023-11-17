package com.ibrahimatay;


import static java.lang.StringTemplate.RAW;
import static java.lang.StringTemplate.STR;
import static java.util.FormatProcessor.FMT;

/*
* JEP 430: String Templates (Preview)
* https://openjdk.org/jeps/430
* */
public class JEP430StringTemplates {

    public static void main(String[] args) {
        System.out.println(interpolationUsingSTRProcessor(getFeelsLike(), getTemperature(), getUnit()));
        System.out.println(interpolationOfJSONBlock(getFeelsLike(), getTemperature(), getUnit()));
        System.out.println(interpolationWithExpressions());
        System.out.println(interpolationWithTemplates());
        System.out.println(interpolationOfJSONBlockWithFMT(getFeelsLike(), 25, getUnit()));
    }

    static String interpolationUsingSTRProcessor(String feelsLike, String temperature, String unit) {
        return STR
                . "Today's weather is \{ feelsLike }, with a temperature of \{ temperature } degrees \{ unit }" ;
    }

    static String interpolationOfJSONBlock(String feelsLike, String temperature, String unit) {
        return STR
                . """
          {
            "feelsLike": "\{ feelsLike }",
            "temperature": "\{ temperature }",
            "unit": "\{ unit }"
          }
          """ ;
    }

    static String interpolationWithExpressions() {
        return STR
                . "Today's weather is \{ getFeelsLike() }, with a temperature of \{ getTemperature() } degrees \{ getUnit() }" ;
    }

    static String interpolationWithTemplates() {
        StringTemplate str = RAW
                . "Today's weather is \{ getFeelsLike() }, with a temperature of \{ getTemperature() } degrees \{ getUnit() }" ;
        return STR.process(str);
    }

    static String interpolationOfJSONBlockWithFMT(String feelsLike, float temperature, String unit) {
        return FMT
                . """
      {
        "feelsLike": "%1s\{ feelsLike }",
        "temperature": "%2.2f\{ temperature }",
        "unit": "%1s\{ unit }"
      }
      """ ;
    }

    private static String getFeelsLike() {
        return "pleasant";
    }

    private static String getTemperature() {
        return "25";
    }

    private static String getUnit() {
        return "Celsius";
    }
}
