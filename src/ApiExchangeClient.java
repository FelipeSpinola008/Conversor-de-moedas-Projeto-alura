import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiExchangeClient {
    public ExchangeRate exchangeCurrency(String baseCode, String targetCode) {
        URI code = URI.create("https://v6.exchangerate-api.com/v6/b82a698fc5447766fe65e7c6/pair/" + baseCode + "/" + targetCode);
        try {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(code)
                .build();
        HttpResponse<String>  response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), ExchangeRate.class);
        } catch (Exception e) {
            throw new RuntimeException("Aconteceu algum erro");
        }

    }
}
