package paquete_actividad6_7;

import java.io.*;
import java.net.*;

public class Servidor {
    public static void main(String[] args) {
        final int PUERTO = 6010;

        try {
            ServerSocket serverSocket = new ServerSocket(PUERTO);
            System.out.println("Esperando al cliente.....");

            Socket clientSocket = serverSocket.accept();
            System.out.println("Cliente conectado.");

            // Flujo de entrada del cliente
            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            // Flujo de salida al cliente
            DataOutputStream outToClient = new DataOutputStream(clientSocket.getOutputStream());

            // Recibir el número del cliente
            int numero = Integer.parseInt(inFromClient.readLine());
            System.out.println("Recibido número del cliente: " + numero);

            // Calcular el cuadrado
            int cuadrado = numero * numero;

            // Enviar el resultado al cliente
            outToClient.writeBytes("El cuadrado del número " + numero + " es " + cuadrado + "\n");

            // Cerrar streams y sockets
            inFromClient.close();
            outToClient.close();
            clientSocket.close();
            serverSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
