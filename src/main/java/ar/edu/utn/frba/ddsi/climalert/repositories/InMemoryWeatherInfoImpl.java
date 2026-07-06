package ar.edu.utn.frba.ddsi.climalert.repositories;

import ar.edu.utn.frba.ddsi.climalert.domain.WeatherInfo;
import ar.edu.utn.frba.ddsi.climalert.utils.SecuentialIdGenerator;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class InMemoryWeatherInfoImpl {
    private final SecuentialIdGenerator idGenerator = new SecuentialIdGenerator();

    private final List<WeatherInfo> historicWeatherInfo = new ArrayList<>();

    public void save(WeatherInfo newWeatherInfo){
        newWeatherInfo.setId(idGenerator.next());
        historicWeatherInfo.add(newWeatherInfo);
    }

    public List<WeatherInfo> findNotEvaluated(){
        return historicWeatherInfo
                .stream()
                .filter(w-> !w.isAlreadyEvaluated())
                .toList();
    }
}
