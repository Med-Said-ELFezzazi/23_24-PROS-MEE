package paquete_actividad6_7;

import java.io.*;
import java.net.*;

public class Cliente {
    public static void main(String[] args) {
        final String SERVER_IP = "localhost";
        final int PUERTO = 6010;

        try {
            System.out.println("PROGRAMA CLIENTE INICIANDO");
            
            // Flujo de entrada estándar para leer desde el teclado
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            // Conectar con el servidor
            Socket clientSocket = new Socket(SERVER_IP, PUERTO);
            
            // Flujo de salida al servidor
            DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
            // Flujo de entrada del servidor
            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            System.out.println("Introduce un número:");
            // Leer el número desde el teclado
            int numero = Integer.parseInt(reader.readLine());

            // Enviar el número al servidor
            outToServer.writeBytes(numero + "\n");

            // Recibir y mostrar el resultado del servidor
            String resultado = inFromServer.readLine();
            System.out.println("Recibiendo mensaje del servidor:\n\t" + resultado);

            // Cerrar streams y socket
            outToServer.close();
            inFromServer.close();
            clientSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
