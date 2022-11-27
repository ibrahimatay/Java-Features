package com.ibrahimatay;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class JEP110HTTP2Client {
    public static void main(String[] args) throws IOException, InterruptedException {
        // JEP 110: HTTP/2 Client
        // https://openjdk.org/jeps/110

        // https://docs.oracle.com/javase/9/docs/api/jdk/incubator/http/HttpClient.html
        // https://openjdk.java.net/groups/net/httpclient/intro.html

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://httpbin.org/uuid"))
                .GET()
                .build();

        String response = HttpClient.newHttpClient()
                .send(request, HttpResponse.BodyHandlers.ofString())
                .body();

        System.out.printf("Response: %s\n", response);

        /*
        Response: {
          "uuid": "a8ad4479-fb75-4815-a88a-7199d0e8c641"
        }
        * */

        HttpClient.newHttpClient().sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(resp -> System.out.printf("Async response:%s\n", response));
    }
}
