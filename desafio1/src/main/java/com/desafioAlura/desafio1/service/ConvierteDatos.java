package com.desafioAlura.desafio1.service;

import com.desafioAlura.desafio1.model.DatosMonedas;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvierteDatos {

    private ObjectMapper objectMapper = new ObjectMapper();

    public DatosMonedas obtenerDatos(String json) {
        try {
            return objectMapper.readValue(json, DatosMonedas.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error deserializing JSON", e);
        }
    }
}

