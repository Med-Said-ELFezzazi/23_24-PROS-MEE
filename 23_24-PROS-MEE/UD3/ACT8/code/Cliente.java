package actividad8;


import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Cliente {
    public static void main(String[] args) {
        int puertoServidor = 12346;
        int puertoLocal = 34568;
        String host = "localhost";
        int numero = 2;

        try {
            DatagramSocket socket = new DatagramSocket(puertoLocal);

            // Convertir el número a bytes y enviar al servidor
            String numeroStr = String.valueOf(numero);
            DatagramPacket envio = new DatagramPacket(numeroStr.getBytes(), numeroStr.length(),
                    InetAddress.getByName(host), puertoServidor);
            socket.send(envio);

            // Mostrar mensaje de espera
            System.out.println("Esperando respuesta...");

            // Recibir la respuesta del servidor
            DatagramPacket recibo = new DatagramPacket(new byte[1024], 1024);
            socket.receive(recibo);

            // Obtener el resultado y mostrar
            String resultado = new String(recibo.getData(), 0, recibo.getLength());
            System.out.println("Esperando respuesta...: el cubo de " + numero + " es " + resultado);

            // Cerrar el socket de cliente
            socket.close();
            System.out.println("Adiós...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
