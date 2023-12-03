package paquete;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class HiloServidor extends Thread {
    private Socket socket;

    public HiloServidor(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            System.out.println("Comunico con: " + socket);

            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            String mensaje;
            while ((mensaje = input.readLine()) != null) {
                if (mensaje.equals("*")) {
                    System.out.println("Fin de la conexión con: " + socket);
                    break;
                }

                System.out.println("Recibido: " + mensaje);
                String respuesta = mensaje.toUpperCase();
                output.println("=>Respuesta:" + respuesta);
            }

            input.close();
            output.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
