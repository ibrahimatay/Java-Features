package com.ibrahimatay.httpclient;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
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

        HttpClient.newHttpClient().sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(resp -> System.out.printf("Async response:%s\n", response));
    }
}
