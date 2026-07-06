package ar.edu.utn.frba.ddsi.climalert.services;

import ar.edu.utn.frba.ddsi.climalert.domain.WeatherInfo;
import ar.edu.utn.frba.ddsi.climalert.repositories.InMemoryWeatherInfoImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AlertService {
    private final InMemoryWeatherInfoImpl repo;
    private final MailService mailService;

    public void evaluatePending() {
        List<WeatherInfo> pendientes = repo.findNotEvaluated();
        for (WeatherInfo weatherInfo : pendientes) {
            if (isCriticalCondition(weatherInfo)) {
                mailService.sendAlert(weatherInfo);
            }
            weatherInfo.evaluate();
        }
    }

    private boolean isCriticalCondition(WeatherInfo w){
        return w.getTemp() > 10 && w.getHumidity() > 2;
        }

}

