package ar.edu.utn.frba.ddsi.climalert.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class RestClientConfig {

    //usamos el yaml para no hardcodear la ruta de la api ni la key
    @Bean
    public RestClient weatherApiRestClient(@Value("${weatherapi.base-url}") String url){
        return RestClient
                .builder()
                .baseUrl(url)
                .build();
    }
}
