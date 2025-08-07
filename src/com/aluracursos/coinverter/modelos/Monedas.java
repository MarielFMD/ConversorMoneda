package com.aluracursos.coinverter.modelos;

public class Monedas {
    String monedaBase;
    String monedaDeseada;

    public float getTasaConversion() {
        return tasaConversion;
    }

    float tasaConversion;

    public Monedas(DatosExchangeRate datosJson) {
        this.monedaBase = datosJson.base_code();
        this.monedaDeseada = datosJson.target_code();
        this.tasaConversion = datosJson.conversion_rate();
    }


}
