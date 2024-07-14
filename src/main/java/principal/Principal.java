package principal;

import service.ConsumoAPI;
import service.ConvierteDatos;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URI;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        String urlBase = "https://v6.exchangerate-api.com/v6/";
        String apiKey = "2400a5f1785a5471dcb0a242";
        String urlRespuesta = "/pair/";
        String monedaBase = "";
        String monedaDestino = "";
        Double montoUsuario = 0.0;

        ConsumoAPI consumoAPI = new ConsumoAPI();
        ConvierteDatos convierteDatos = new ConvierteDatos();
        Scanner teclado = new Scanner(System.in);
        var opcion = -1;

        while(opcion != 0){
            System.out.println("""
                ************************************************************
                             Sistema conversor de divisas
                ************************************************************
                """);

            var menu = """
                    ************************************************************
                    Ingrese una opción:
                    
                        1. USD - Dolar => MXN - Peso Mexicano
                        2. MXN - Peso Mexicano => USD - Dolar
                        3. USD - Dolar => BRL - Real Brasileno
                        4. BRL - Real Brasileno => USD - Dolar
                        5. USD - Dolar => COP - Peso Colombiano
                        6. COP - Peso Colombiano => USD - Dolar
                        7. USD - Dolar => ARS - Peso Argentino
                        8. ARS - Peso Argentino => USD Dolar
                        
                        0. Salir.
                    ************************************************************""";

            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();
            System.out.println("Ingrese el importe a convertir: ");
            montoUsuario = teclado.nextDouble();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    monedaBase = "USD";
                    monedaDestino = "MXN";
                    break;
                case 2:
                    monedaBase = "MXN";
                    monedaDestino = "USD";
                    break;
                case 3:
                    monedaBase = "USD";
                    monedaDestino = "BRL";
                case 4:
                    monedaBase = "BRL";
                    monedaDestino = "USD";
                case 5:
                    monedaBase = "USD";
                    monedaDestino = "COP";
                case 6:
                    monedaBase = "COP";
                    monedaDestino = "USD";
                case 7:
                    monedaBase = "USD";
                    monedaDestino = "ARS";
                case 8:
                    monedaBase = "ARS";
                    monedaDestino = "USD";
                case 0:
                    System.out.println("Cerrando aplicacion...");
                    break;
                default:
                    System.out.println("Opcion invalida");

            }

            URI direccion = URI.create(urlBase + apiKey + urlRespuesta + monedaBase + "/" + monedaDestino + "/" + montoUsuario);

            String json = consumoAPI.obtenerDatosAPI(direccion);

            var conversion = convierteDatos.convierteDatos(json);

            BigDecimal resultado = BigDecimal.valueOf(montoUsuario * conversion.conversion_rate());
            System.out.println("El valor de $" + montoUsuario + " [" + monedaBase + "] corresponde al valor de => $"
                    + resultado.setScale(2, RoundingMode.HALF_UP) + " [" + monedaDestino + "].");

            var comprobarResultado = conversion.conversion_result();
    }
}
    private static void convertirDivisa() {

    }

    private static void historialConversiones() {
        System.out.println("En construccion...");
    }
    }


