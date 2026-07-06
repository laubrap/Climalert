package ar.edu.utn.frba.ddsi.climalert.clients;

import ar.edu.utn.frba.ddsi.climalert.dtos.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class WeatherApiClient {
    private final RestClient restClient;
    private final String apiKey;
    private final String location;

    public WeatherApiClient(RestClient restClient,
                            @Value("${weatherapi.key}") String apiKey,
                            @Value("${weatherapi.location}") String location)
    {
        this.restClient = restClient;
        this.apiKey = apiKey;
        this.location = location;
    }

    public Response getWeather(){
        return restClient.get()
                .uri(uriBuilder ->
                        uriBuilder.path("/current.json")
                                .queryParam("key", apiKey)
                                .queryParam("q", location)
                                .build())
                .retrieve()
                .body(Response.class);
    }
}
