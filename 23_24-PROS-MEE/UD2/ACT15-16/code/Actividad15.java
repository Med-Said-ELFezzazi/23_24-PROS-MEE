package paquete;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Actividad15 {
    public static void main(String[] args) {
        Hilo hilo1 = new Hilo("Hilo 1");
        Hilo hilo2 = new Hilo("Hilo 2");
        Hilo hilo3 = new Hilo("Hilo 3");

        hilo1.start();
        hilo2.start();
        hilo3.start();
    }
}

class Hilo extends Thread {
    private final String nombre;

    public Hilo(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run() {
        SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");

        for (int i = 0; i < 5; i++) {
            String horaActual = formatoHora.format(new Date());
            System.out.println(nombre + " - " + horaActual);

            try {
                Thread.sleep(1000); // Espera 1 segundo entre mensajes
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}