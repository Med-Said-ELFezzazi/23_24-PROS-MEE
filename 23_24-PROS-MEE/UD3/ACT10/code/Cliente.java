package actividad10;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Cliente {
	
	public static void main(String[] args) {
		
		Tenista tenista = new Tenista("del Potro", 198);
		
		int puertoServidor = 12391;
		int puertoLocal = 34567;
		
		try {
            // Convertir el objeto a bytes
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(tenista);
            byte[] datos = byteArrayOutputStream.toByteArray();

            // Enviar el objeto al servidor
            DatagramSocket socket = new DatagramSocket(puertoLocal);
            DatagramPacket envio = new DatagramPacket(datos, datos.length, InetAddress.getByName("localhost"), puertoServidor);
            socket.send(envio);

            // Mostrar mensaje de envío
            System.out.println("Envío el objeto: " + tenista);

            // Esperar la respuesta del servidor
            System.out.println("Esperando datagrama.......");
            DatagramPacket recibo = new DatagramPacket(new byte[1024], 1024);
            socket.receive(recibo);

            // Obtener el objeto Tenista modificado del servidor
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(recibo.getData());
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            Tenista tenistaModificado = (Tenista) objectInputStream.readObject();

            // Mostrar el objeto Tenista modificado
            System.out.println("He recibido el objeto: " + tenistaModificado);

            // Cerrar el socket de cliente
            socket.close();
            System.out.println("Fin del cliente");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
