package paquete;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Cliente {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 6000);

            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("PROGRAMA CLIENTE INICIANDO");

            while (true) {
                System.out.print("Introduce una cadena: ");
                String mensaje = teclado.readLine();
                output.println(mensaje);

                String respuesta = input.readLine();
                System.out.println("=>Respuesta:" + respuesta);

                if (mensaje.equals("*")) {
                    System.out.println("Fin del envío....");
                    break;
                }
            }

            input.close();
            output.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
