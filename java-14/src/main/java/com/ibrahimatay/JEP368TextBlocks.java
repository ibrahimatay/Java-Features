package com.ibrahimatay;

public class JEP368TextBlocks {
    public static void main(String[] args) {
        // JEP 368: Text Blocks (Second Preview)
        // https://openjdk.org/jeps/368

        String json = """
                {
                    "name": "Java",
                    "version": 14
                }
                """;
        System.out.println(json);
    }
}
