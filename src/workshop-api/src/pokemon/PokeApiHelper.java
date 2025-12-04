package pokemon;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.Gson;

public class PokeApiHelper {

    private static final HttpClient client = HttpClient.newHttpClient();
    private static final Gson gson = new Gson();

    public static Pokemon fetchPokemon(String name) throws IOException, InterruptedException {
        String url = "https://pokeapi.co/api/v2/pokemon/" + name.toLowerCase();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            System.out.println("Kunne ikke hente Pokémon: " + name);
            return null;
        }

        return gson.fromJson(response.body(), Pokemon.class);
    }
}

