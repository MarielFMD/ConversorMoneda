package com.aluracursos.coinverter.servicios;

import com.aluracursos.coinverter.modelos.DatosExchangeRate;
import com.google.gson.Gson;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMoneda {


    public static String crearURL(String monedaBase, String monedaDeseada) {
        String direccion = "https://v6.exchangerate-api.com/v6/a1b2c5a82c48685a8e1b993b/pair/" + monedaBase + "/" + monedaDeseada;
        return direccion;
    }

    public static String consultarURL(String direccion) {

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();
            return json;
        }catch (IOException e) {
            throw new RuntimeException("Error de conexión con la API. Verifique su conexión a internet.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("La consulta a la API fue interrumpida.");

        }
    }

    public static DatosExchangeRate parsearJson(String json) {
        Gson gson = new Gson();
        DatosExchangeRate respuestaAPI = gson.fromJson(json, DatosExchangeRate.class);
        return respuestaAPI;

    }

}









