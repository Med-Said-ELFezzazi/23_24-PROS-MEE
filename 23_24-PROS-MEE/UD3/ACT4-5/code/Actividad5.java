package paquete2;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class Actividad5 {
    public static void main(String[] args) {
        String urlString = "http://www.vitoria-gasteiz.org";
        try {
            URL url = new URL(urlString);
            URLConnection urlConnection = url.openConnection();
            VisualizarConexion(urlConnection);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void VisualizarConexion(URLConnection urlConnection) {
        System.out.println("Conexión con " + urlConnection.getURL());
        System.out.println("==========================");

        // Métodos de la clase URLConnection
        System.out.println("\tMétodo toString(): " + urlConnection.toString());
        System.out.println("\tMétodo Fecha(): " + urlConnection.getDate());
        System.out.println("\tMétodo getContentType(): " + urlConnection.getContentType());

        // Campos Cabecera con getHeaderField
        System.out.println("\nCampos Cabecera con getHeaderField:");
        System.out.println("====================================");
        for (int i = 0; ; i++) {
            String headerField = urlConnection.getHeaderField(i);
            if (headerField == null) break;
            System.out.println("\t\tLinea " + (i + 1) + ":" + headerField);
        }

        // Campos Cabecera con getHeaderFields
        System.out.println("\nCampos Cabecera con getHeaderFields:");
        System.out.println("====================================");
        Map<String, List<String>> headerFields = urlConnection.getHeaderFields();
        for (Map.Entry<String, List<String>> entry : headerFields.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
}

