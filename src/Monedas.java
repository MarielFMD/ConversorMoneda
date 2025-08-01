public class Monedas {
    String monedaBase;
    String monedaDeseada;
    float tasaConversion;

    public Monedas(DatosExchangeRate datosJson) {
        this.monedaBase = datosJson.base_code();
        this.monedaDeseada = datosJson.target_code();
        this.tasaConversion = datosJson.conversion_rate();
    }


}
