package convertidordemoneda;

import static convertidordemoneda.Conversion.realizarConversion;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;


public class ConvertidorMoneda {

    // Clave API de ExchangeRate-API
    private static final String API_KEY = "62941d886eaab936cf93e36d";
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            // Menú de opciones
            System.out.println("1 - Dólar a Peso Argentino");
            System.out.println("2 - Peso Argentino a Dólar");
            System.out.println("3 - Dólar a Peso Mexicano");
            System.out.println("4 - Peso Mexicano a Dólar");
            System.out.println("5 - Salir");
            System.out.println("");
            System.out.print("Elija una opción: ");
            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    realizarConversion("USD", "ARS", BASE_URL);
                    break;
                case "2":
                    realizarConversion("ARS", "USD", BASE_URL);
                    break;
                case "3":
                    realizarConversion("USD", "MXN", BASE_URL);
                    break;
                case "4":
                    realizarConversion("MXN", "USD", BASE_URL);
                    break;
                case "5":
                    System.out.println("Saliendo del programa...");
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
            System.out.println();
        }

        scanner.close();
    }
}
