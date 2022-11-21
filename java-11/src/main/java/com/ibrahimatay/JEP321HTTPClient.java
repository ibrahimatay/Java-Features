package com.ibrahimatay;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class JEP321HTTPClient {
    // JEP 321: HTTP Client
    // https://openjdk.org/jeps/321

    // https://httpbin.org/get
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException, IOException, InterruptedException, URISyntaxException {
        // asynchronousRequest();
        // synchronousRequest();
        // executorServiceRequest();
    }

    static void synchronousRequest() throws IOException, InterruptedException {
        final HttpClient httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .connectTimeout(Duration.ofSeconds(10))
                .build();

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://httpbin.org/get"))
                .setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        // print response headers
        HttpHeaders headers = response.headers();
        headers.map().forEach((k, v) -> System.out.println(k + ":" + v));

        // print status code
        System.out.println(response.statusCode());

        // print response body
        System.out.println(response.body());
        /*
        *
        access-control-allow-credentials:[true]
        access-control-allow-origin:[*]
        connection:[keep-alive]
        content-length:[269]
        content-type:[application/json]
        date:[Mon, 21 Nov 2022 10:40:59 GMT]
        server:[gunicorn/19.9.0]
        200
        {
          "args": {},
          "headers": {
            "Content-Length": "0",
            "Host": "httpbin.org",
            "User-Agent": "Java 11 HttpClient Bot",
            "X-Amzn-Trace-Id": "Root=1-637b55bb-44a1a08d6db9c38a15b407bc"
          },
          "origin": "5.27.41.90",
          "url": "https://httpbin.org/get"
        }
        * */
    }

    static void asynchronousRequest() throws InterruptedException, ExecutionException, TimeoutException {
        final HttpClient httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .connectTimeout(Duration.ofSeconds(10))
                .build();

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://httpbin.org/get"))
                .setHeader("User-Agent", "Java 11 HttpClient Bot")
                .build();

        CompletableFuture<HttpResponse<String>> response =
                httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString());

        String result = response.thenApply(HttpResponse::body).get(5, TimeUnit.SECONDS);
        System.out.println(result);

        /*
        {
          "args": {},
          "headers": {
            "Host": "httpbin.org",
            "User-Agent": "Java 11 HttpClient Bot",
            "X-Amzn-Trace-Id": "Root=1-637b5462-047f30e05fa45f367fe4c397"
          },
          "origin": "5.27.41.90",
          "url": "https://httpbin.org/get"
        }
        * */
    }

    static void executorServiceRequest() throws URISyntaxException, ExecutionException, InterruptedException {
        final ExecutorService executorService = Executors.newFixedThreadPool(5);
        final HttpClient httpClient = HttpClient.newBuilder()
                .executor(executorService)
                .version(HttpClient.Version.HTTP_2)
                .connectTimeout(Duration.ofSeconds(10))
                .build();

        List<URI> targets = Arrays.asList(
                new URI("https://httpbin.org/get?name=ibrahimatay01"),
                new URI("https://httpbin.org/get?name=ibrahimatay02"),
                new URI("https://httpbin.org/get?name=ibrahimatay03"));

        List<CompletableFuture<String>> result = targets.stream()
                .map(url -> httpClient.sendAsync(
                                HttpRequest.newBuilder(url)
                                        .GET()
                                        .setHeader("User-Agent", "Java 11 HttpClient Bot")
                                        .build(),
                                HttpResponse.BodyHandlers.ofString())
                        .thenApply(response -> response.body()))
                .collect(Collectors.toList());

        for (CompletableFuture<String> future : result) {
            System.out.println(future.get());
        }
    }
}
