package actividad1_INETADDRESS;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Actividad1 {

    public static void main(String[] args) {
        String dominio = "www.spotify.com";

        try {
            InetAddress[] direccionesIP = InetAddress.getAllByName(dominio);

            System.out.println("Direcciones asociadas a Spotify :");
            for (InetAddress direccion : direccionesIP) {
                System.out.println(dominio + "/" + direccion.getHostAddress());
            }
        } catch (UnknownHostException e) {
            System.err.println("No se pudo obtener la dirección IP del dominio: " + dominio);
            e.printStackTrace();
        }
    }
}
