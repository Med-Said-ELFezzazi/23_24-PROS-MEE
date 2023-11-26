package actividad1_INETADDRESS;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Actividad3 {

    public static void main(String[] args) {
        if (args.length == 0) {
            mostrarDireccionesLocales();
        } else {
            String dominio = args[0];
            obtenerYMostrarDireccionIP(dominio);
        }
    }

    private static void mostrarDireccionesLocales() {
        try {
            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println("Dirección IP: " + localHost.getHostAddress());
            System.out.println("Nombre: " + localHost.getHostName());
            System.out.println(localHost.getHostName() + "/" + localHost.getHostAddress() + ".");
            
            InetAddress[] localAddresses = InetAddress.getAllByName(localHost.getHostName());
            for (InetAddress localAddress : localAddresses) {
                System.out.println(localHost.getHostName() + "/" + localAddress.getHostAddress());
            }
        } catch (UnknownHostException e) {
            System.err.println("Error al obtener la dirección IP local");
            e.printStackTrace();
        }
    }

    private static void obtenerYMostrarDireccionIP(String dominio) {
        try {
            InetAddress[] direccionesIP = InetAddress.getAllByName(dominio);

            System.out.println("Dirección IP: " + direccionesIP[0].getHostAddress());
            System.out.println("Nombre: " + direccionesIP[0].getHostName());
            System.out.println(dominio + "/" + direccionesIP[0].getHostAddress() + ".");
            
            for (InetAddress direccion : direccionesIP) {
                System.out.println(dominio + "/" + direccion.getHostAddress());
            }
        } catch (UnknownHostException e) {
            System.err.println("No se pudo obtener la dirección IP del dominio: " + dominio);
            e.printStackTrace();
        }
    }
}
