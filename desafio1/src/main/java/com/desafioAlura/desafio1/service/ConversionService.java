package com.desafioAlura.desafio1.service;

import com.desafioAlura.desafio1.model.DatosMonedas;

public class ConversionService {



    public static double convertirMoneda(DatosMonedas datosMonedas, String monedaOrigen, String monedaDestino, double cantidad) {
        if (!datosMonedas.getConversionRates().containsKey(monedaOrigen) ||
                !datosMonedas.getConversionRates().containsKey(monedaDestino)) {
            throw new IllegalArgumentException("Moneda no soportada");
        }

        double tasaOrigen = datosMonedas.getConversionRates().get(monedaOrigen);
        double tasaDestino = datosMonedas.getConversionRates().get(monedaDestino);

        // Convertir la cantidad de la moneda de origen a la base (USD)
        double cantidadEnBase = cantidad / tasaOrigen;

        // Convertir la cantidad en la base a la moneda de destino
        return cantidadEnBase * tasaDestino;
    }
}

