package actividad8;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Servidor {
    public static void main(String[] args) {
        int puerto = 12346;

        try {
            DatagramSocket socket = new DatagramSocket(puerto);

            // Esperar la llegada del datagrama al servidor
            System.out.println("Esperando datagrama.......");
            DatagramPacket recibo = new DatagramPacket(new byte[1024], 1024);
            socket.receive(recibo);

            // Obtener el número enviado por el cliente
            String mensaje = new String(recibo.getData(), 0, recibo.getLength());
            int numero = Integer.parseInt(mensaje);

            // Calcular el cubo del número
            int resultado = numero * numero * numero;

            // Mostrar información
            System.out.println("Vamos a calcular el cubo de: " + numero);
            System.out.println("IP de origen: " + recibo.getAddress());
            System.out.println("Puerto de origen: " + recibo.getPort());

            // Enviar el resultado al cliente
            String resultadoStr = String.valueOf(resultado);
            DatagramPacket envio = new DatagramPacket(resultadoStr.getBytes(), resultadoStr.length(),
                    recibo.getAddress(), recibo.getPort());
            socket.send(envio);

            // Cerrar el socket de servidor
            System.out.println("Adiósss");
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

