package actividad1_INETADDRESS;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Actividad2 {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Se necesita una URL para obtener su dirección.");
        } else {
            String url = args[0];
            obtenerDirecciones(url);
        }
    }

    public static void obtenerDirecciones(String url) {
        try {
            InetAddress[] direccionesIP = InetAddress.getAllByName(url);

            System.out.println("Las direcciones asociadas a " + url + " son:");
            for (InetAddress direccion : direccionesIP) {
                System.out.println(url + "/" + direccion.getHostAddress());
            }
        } catch (UnknownHostException e) {
            System.err.println("No se pudo obtener la dirección IP de la URL: " + url);
            e.printStackTrace();
        }
    }
}
