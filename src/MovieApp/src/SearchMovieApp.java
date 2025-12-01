import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class SearchMovieApp {

    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner sc = new Scanner(System.in);
        System.out.print("Indtast filmnavn: ");
        String query = sc.nextLine();

        String apiKey = "b88ef195e07424c2d91099e4f7a9372e"; // ← Indsæt din TMDB nøgle her

        // query skal URL-encodes (fx mellemrum → %20)
        String encodedQuery = URLEncoder.encode(query, StandardCharsets.UTF_8);

        String url = "https://api.themoviedb.org/3/search/movie"
                + "?query=" + encodedQuery
                + "&api_key=" + apiKey
                + "&language=en-US";

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
        SearchResponse result = gson.fromJson(response.body(), SearchResponse.class);

        // --- Udskriv resultater ---
        System.out.println("\n=== Søgeresultater ===");

        if (result.results == null || result.results.length == 0) {
            System.out.println("Ingen film fundet!");
            return;
        }

        // Vis de første 5 film (eller færre)
        int limit = Math.min(5, result.results.length);

        for (int i = 0; i < limit; i++) {
            Movie m = result.results[i];
            System.out.println("\nTitel: " + m.title);
            System.out.println("Udgivelsesdato: " + m.release_date);
            System.out.println("Rating: " + m.vote_average);
        }
    }
}