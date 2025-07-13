import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Currancy {
    public Current exchangeCurrency(String baseCode, String targetCode) {
        URI code = URI.create("https://v6.exchangerate-api.com/v6/b82a698fc5447766fe65e7c6/pair/" + baseCode + "/" + targetCode);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(code)
                .build();
        HttpResponse<String> response = null;
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            throw new RuntimeException("Aconteceu algum erro");
        }
        return new Gson().fromJson(response.body(), Current.class);
    }
}
