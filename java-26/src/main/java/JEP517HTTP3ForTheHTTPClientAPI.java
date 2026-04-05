import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpClient.Version;

public class JEP517HTTP3ForTheHTTPClientAPI {
    static void main() {
        try {
            // 1. Configure the HttpClient to prefer HTTP/3
            // If the server does not support HTTP/3, it will automatically fallback to HTTP/2
            HttpClient client = HttpClient.newBuilder()
                    .version(Version.HTTP_3)
                    .build();

            // 2. Create the request for an HTTP/3 enabled endpoint
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://quic.rocks:4433/"))
                    .GET()
                    .build();

            // 3. Send the request and receive the response synchronously
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // 4. Output the results to the console
            System.out.println("Protocol Used: " + response.version());
            System.out.println("Status Code: " + response.statusCode());
            System.out.println("Response Body (Preview): " + response.body().substring(0, 100) + "...");

        } catch (Exception e) {
            // Handle potential network or protocol exceptions
            System.err.println("Error during HTTP/3 request: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
