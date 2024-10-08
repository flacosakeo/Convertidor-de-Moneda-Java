package convertidordemoneda;

import static convertidordemoneda.obtenerTasaCambio.obtenerTasaCambio;
import java.util.Scanner;

public class Conversion {
    
    public static void realizarConversion(String fromCurrency, String toCurrency, String BASE_URL) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la cantidad de " + fromCurrency + " a convertir: ");
        double amount = scanner.nextDouble();

        try {
            double conversionRate = obtenerTasaCambio(fromCurrency, toCurrency, BASE_URL);
            if (conversionRate != -1) {
                double convertedAmount = amount * conversionRate;
                System.out.println(amount + " " + fromCurrency + " es igual a " + convertedAmount + " " + toCurrency);
            } else {
                System.out.println("No se pudo obtener la tasa de cambio.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
