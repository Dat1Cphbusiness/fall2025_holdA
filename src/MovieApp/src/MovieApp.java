import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

import com.google.gson.Gson;


public class MovieApp {

    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner sc = new Scanner(System.in);
        System.out.print("Indtast film ID (fx 550 for Fight Club): ");
        int id = Integer.parseInt(sc.nextLine());

        String apiKey = "b88ef195e07424c2d91099e4f7a9372e"; // ← indsæt TMDB nøgle her

        String url = "https://api.themoviedb.org/3/movie/" + id +
                "?api_key=" + apiKey + "&language=en-US";

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            System.out.println("Fejl: " + response.statusCode());
            System.out.println(response.body());
            return;
        }

        Gson gson = new Gson();
        Movie m = gson.fromJson(response.body(), Movie.class);

        System.out.println("\n=== Film ===");
        System.out.println("Titel: " + m.title);
        System.out.println("År: " + m.release_date);
        System.out.println("Rating: " + m.vote_average);
        System.out.println("\nBeskrivelse:");
        System.out.println(m.overview);
    }
}
