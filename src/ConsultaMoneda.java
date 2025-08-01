import com.google.gson.Gson;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMoneda {
    //temporalmente declaramos variables para construir la URI. Esto tiene que venir de un input
    String monedaBase;
    String monedaDeseada;

    public static String crearURL(String monedaBase, String monedaDeseada) {
        String direccion = "https://v6.exchangerate-api.com/v6/a1b2c5a82c48685a8e1b993b/pair/" + monedaBase + "/" + monedaDeseada;
        return direccion;
    }

    public static String consultarURL(String direccion) throws IOException, InterruptedException {

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();
        System.out.println(json);
        return json;
    }

    public static DatosExchangeRate parsearJson(String json) {
        Gson gson = new Gson();
        DatosExchangeRate respuestaAPI = gson.fromJson(json, DatosExchangeRate.class);
        System.out.println(respuestaAPI);
        return respuestaAPI;

    }
}









