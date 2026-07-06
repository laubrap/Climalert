package ar.edu.utn.frba.ddsi.climalert;

import ar.edu.utn.frba.ddsi.climalert.clients.WeatherApiClient;
import ar.edu.utn.frba.ddsi.climalert.dtos.Response;
import ar.edu.utn.frba.ddsi.climalert.services.AlertService;
import ar.edu.utn.frba.ddsi.climalert.services.WeatherService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class ClimalertApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClimalertApplication.class, args);

	}
}
