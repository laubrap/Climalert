package ar.edu.utn.frba.ddsi.climalert.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Current(
        @JsonProperty("temp_c") double tempC,
        @JsonProperty("humidity") int humidity
) {
}
