package com.aluracursos.coinverter.servicios;

import com.aluracursos.coinverter.modelos.DatosExchangeRate;
import com.aluracursos.coinverter.modelos.Monedas;

public class ServicioDeConversion {
    public Monedas convertirDeJson (String json){
        DatosExchangeRate respuestaAPI = ConsultaMoneda.parsearJson(json);
        return new Monedas(respuestaAPI);
    }
}
