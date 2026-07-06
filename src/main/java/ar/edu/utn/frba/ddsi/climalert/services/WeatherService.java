package ar.edu.utn.frba.ddsi.climalert.services;

import ar.edu.utn.frba.ddsi.climalert.clients.WeatherApiClient;
import ar.edu.utn.frba.ddsi.climalert.domain.WeatherInfo;
import ar.edu.utn.frba.ddsi.climalert.dtos.Response;
import ar.edu.utn.frba.ddsi.climalert.repositories.InMemoryWeatherInfoImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class WeatherService {
    private final InMemoryWeatherInfoImpl inMemoryWeatherRepo;
    private final WeatherApiClient weatherApiClient;
    
    public void saveCurrentWeather(){
        Response response = weatherApiClient.getWeather();
        WeatherInfo mappedData = mapResponseToDomain(response);
        inMemoryWeatherRepo.save(mappedData);
    }

    private WeatherInfo mapResponseToDomain(Response response){
        return new WeatherInfo(
                response.location().name(),
                response.current().tempC(),
                response.current().humidity(),
                LocalDateTime.now(),
                false
        );
    }
}
