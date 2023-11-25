package actividad10;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Servidor {
    public static void main(String[] args) {
        int puerto = 12391;
        try {
            DatagramSocket socket = new DatagramSocket(puerto);
            System.out.println("Esperando datagrama.......");

            while (true) {
                // Recibir el datagrama del cliente
                DatagramPacket recibo = new DatagramPacket(new byte[1024], 1024);
                socket.receive(recibo);

                // Obtener el objeto Tenista del cliente
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(recibo.getData());
                ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
                Tenista tenista = (Tenista) objectInputStream.readObject();

                // Mostrar el objeto Tenista recibido
                System.out.println("Recibo el objeto: " + tenista);
                System.out.println("IP de origen: " + recibo.getAddress());
                System.out.println("Puerto de origen: " + recibo.getPort());

                // Modificar el objeto Tenista
                tenista.setApellido("Karlovic");
                tenista.setAltura(208);

                // Enviar el objeto Tenista modificado de vuelta al cliente
                InetAddress direccionCliente = recibo.getAddress();
                int puertoCliente = recibo.getPort();
                byte[] respuestaBytes = objectToBytes(tenista);
                DatagramPacket respuesta = new DatagramPacket(respuestaBytes, respuestaBytes.length, direccionCliente, puertoCliente);
                socket.send(respuesta);

                // Mostrar el objeto Tenista modificado
                System.out.println("Envío el objeto: " + tenista);
                
                System.out.println("Fin del servidor");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static byte[] objectToBytes(Object object) throws IOException {
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
             ObjectOutputStream oos = new ObjectOutputStream(bos)) {
            oos.writeObject(object);
            return bos.toByteArray();
        }
    }
}