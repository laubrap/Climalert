package ar.edu.utn.frba.ddsi.climalert.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
public class WeatherInfo {
    @Setter
    private long id;

    private final String name;
    private final double temp;
    private final int humidity;
    private final LocalDateTime date;
    private boolean evaluated;

    public WeatherInfo(String name, double temp, int humidity, LocalDateTime date, boolean evaluated) {
        this.name = name;
        this.temp = temp;
        this.humidity = humidity;
        this.date = date;
        this.evaluated = evaluated;
    }


    public void evaluate(){
        this.evaluated=true;
    }

    public boolean isAlreadyEvaluated(){
        return evaluated;
    }
}
