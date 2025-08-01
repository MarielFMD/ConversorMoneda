public class ServicioDeConversion {
    public Monedas convertirDeJson (String json){
        DatosExchangeRate respuestaAPI = ConsultaMoneda.parsearJson(json);
        return new Monedas(respuestaAPI);
    }
}
