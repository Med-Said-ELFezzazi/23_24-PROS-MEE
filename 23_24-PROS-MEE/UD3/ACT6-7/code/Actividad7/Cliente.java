package paquete_actividad_7;

import java.io.*;
import java.net.*;

public class Cliente {
    public static void main(String[] args) {
        final String SERVER_IP = "localhost";
        final int PUERTO = 6013;

        try {
            System.out.println("PROGRAMA CLIENTE INICIANDO");

            // Conectar con el servidor
            Socket clientSocket = new Socket(SERVER_IP, PUERTO);

            // Flujo de entrada del servidor
            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            // Recibir y mostrar el mensaje del servidor
            String mensaje = inFromServer.readLine();
            System.out.println("Recibiendo mensaje del servidor:\n\t" + mensaje);

            // Cerrar stream y socket
            inFromServer.close();
            clientSocket.close();

        } catch (ConnectException e) {
            System.out.println("Connection refused: connect");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
