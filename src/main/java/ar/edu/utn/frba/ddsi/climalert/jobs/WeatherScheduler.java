package ar.edu.utn.frba.ddsi.climalert.jobs;

import ar.edu.utn.frba.ddsi.climalert.services.AlertService;
import ar.edu.utn.frba.ddsi.climalert.services.WeatherService;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class WeatherScheduler {
    private final WeatherService weatherService;
    private final AlertService alertService;

    @Scheduled(fixedRate = 300000)
    public void getWeather() {
        weatherService.saveCurrentWeather();
    }

    @Scheduled(fixedRate = 60000)
    public void evaluateAlerts() {
        alertService.evaluatePending();
    }
}
