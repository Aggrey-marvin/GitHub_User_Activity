package app;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class APICaller {
    public HttpResponse<String> makeAPICall(String url) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .header("Accept", "application/json")
            .GET()
            .build();

        try {
            HttpResponse<String> response =  client.send(request, HttpResponse.BodyHandlers.ofString());

            return response;
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
            return null;
        }   catch (InterruptedException e) {
            System.out.println("InterruptedException: " + e.getMessage());
            return null;
        }
    }
}
