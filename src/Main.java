import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        presentarApp();

        while (true){
            mostrarMenu();

            Scanner lectura = new Scanner(System.in);
            System.out.println("Ingrese el número de opción deseado: ");
            var opcionUsuario = lectura.nextLine();


            String monedaBase;
            String monedaDeseada;
            switch(opcionUsuario) {
                case "1":
                    monedaBase = "ARS";
                    monedaDeseada = "USD";
                    break;
                case "2":
                    monedaBase = "USD";
                    monedaDeseada = "ARS";
                    break;
                case "3":
                    monedaBase = "ARS";
                    monedaDeseada = "EUR";
                    break;
                case "4":
                    monedaBase = "EUR";
                    monedaDeseada = "ARS";
                    break;
                case "5":
                    monedaBase = "ARS";
                    monedaDeseada = "BRL";
                    break;
                case "6":
                    monedaBase = "BRL";
                    monedaDeseada = "ARS";
                    break;
                case "7":
                    System.out.println("Saliendo del sistema. Gracias por utilizar nuestro servicio.");
                    return;
                default:
                    System.out.println("Error. Ingrese una opción válida");
                    System.out.println();;
                    continue;
            }
                //crea la URL a partir de la opcion seleccionada
                String direccionURL = ConsultaMoneda.crearURL(monedaBase,monedaDeseada);

                //guarda el json devuelto por la HTTPrequest
                String json = ConsultaMoneda.consultarURL(direccionURL);

                var servicio = new ServicioDeConversion();
                Monedas monedaConvertida = servicio.convertirDeJson(json);


            String montoIngresado;
            double monto;

            while (true) {
                System.out.println("Ingrese el monto a convertir: ");
                montoIngresado = lectura.nextLine();

                try {
                    monto = Double.parseDouble(montoIngresado);
                    if (monto <= 0) {
                        System.out.println("El monto debe ser mayor a 0. Ingrese un monto válido.");
                    } else {
                        break; // sale del bucle si el monto es válido
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Ingrese un número válido (use punto como separador decimal).");
                }
            }


                System.out.println(montoIngresado+" "+monedaBase+" equivalen a "+(monto*monedaConvertida.tasaConversion)+" "+monedaDeseada);
                System.out.println();
            }



    }



    public static void presentarApp() {
        System.out.println("""
                ********************************** 
                           COINVERTER
                **********************************
                """);
    }

    public static void mostrarMenu() {
        System.out.println("""
                       MENÚ DE MONEDAS:
            *************************************    
            1 - PESO ARGENTINO A DOLAR AMERICANO
            2 - DOLAR AMERICANO A PESO ARGENTINO
            3 - PESO ARGENTINO A EURO
            4 - EURO A PESO ARGENTINO
            5 - PESO ARGENTINO A REAL BRASILEÑO
            6 - REAL BRASILEÑO A PESO ARGENTINO
            7 - SALIR
            """);
    }
}
