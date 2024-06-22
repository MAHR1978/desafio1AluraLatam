package com.desafioAlura.desafio1.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Monedas(
        @JsonAlias("currency_code") String tipo,
        @JsonAlias("value") Double valor
) {
}