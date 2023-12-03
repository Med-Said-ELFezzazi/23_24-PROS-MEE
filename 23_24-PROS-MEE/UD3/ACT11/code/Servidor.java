package paquete;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(6000);
            System.out.println("Servidor iniciado. Esperando clientes...");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Cliente Conectado....");
                HiloServidor hiloServidor = new HiloServidor(socket);
                hiloServidor.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
