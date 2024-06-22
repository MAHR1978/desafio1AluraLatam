package com.desafioAlura.desafio1.service;

public interface IConviertedatos {
    <T> T obtenerDatos(String json, Class<T> clase);
}
