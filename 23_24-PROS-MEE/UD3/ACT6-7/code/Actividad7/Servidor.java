package paquete_actividad_7;

import java.io.*;
import java.net.*;

public class Servidor {
    public static void main(String[] args) {
        final int PUERTO = 6013;

        try {
            ServerSocket serverSocket = new ServerSocket(PUERTO);
            System.out.println("Esperando a los clientes.....");

            for (int i = 0; i < 3; i++) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Cliente " + (i + 1) + " conectado.");

                // Flujo de salida al cliente
                PrintWriter outToClient = new PrintWriter(clientSocket.getOutputStream(), true);
                
                // Enviar mensaje de saludo al cliente
                outToClient.println("Hola cliente " + (i + 1));

                // Cerrar streams y socket para este cliente
                outToClient.close();
                clientSocket.close();
            }

            // Cerrar el socket del servidor
            serverSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
