import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiDemo1 {
    public static void main(String[] args) throws IOException, InterruptedException {

        HttpClient client = HttpClient.newHttpClient();

        String url = "https://bored-api.appbrewery.com/random";    

        // Build request
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        // Send request amd get response as string
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("Statuskode: " + response.statusCode());
        System.out.println("Raw JSON response!:");
        System.out.println(response.body());     
    }
}
