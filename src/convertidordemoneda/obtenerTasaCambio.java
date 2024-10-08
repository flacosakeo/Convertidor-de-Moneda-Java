package convertidordemoneda;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;


public class obtenerTasaCambio {
      public static double obtenerTasaCambio(String fromCurrency, String toCurrency, String BASE_URL) {
          
        try {
            
            // URL de la API con la moneda base
            String urlStr = BASE_URL + fromCurrency;
            URL url = new URL(urlStr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            // Verificar si la respuesta fue exitosa
            int responseCode = conn.getResponseCode();
            if (responseCode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responseCode);
            } else {
                // Leer la respuesta de la API
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inputLine;
                StringBuffer content = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }
                in.close();
                conn.disconnect();

                // Convertir la respuesta JSON a un objeto JSONObject
                JSONObject jsonResponse = new JSONObject(content.toString());

                // Verificar que exista la moneda solicitada
                if (!jsonResponse.getJSONObject("conversion_rates").has(toCurrency)) {
                    System.out.println("La moneda destino no es válida.");
                    return -1;
                }

                // Obtener la tasa de cambio de la moneda destino
                return jsonResponse.getJSONObject("conversion_rates").getDouble(toCurrency);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
