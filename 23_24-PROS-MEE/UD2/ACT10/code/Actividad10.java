package paquete;

public class Actividad10 {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + " tiene la prioridad " + Thread.currentThread().getPriority());

        Hilo hilo1 = new Hilo("Hilo-prioridad 3");
        Hilo hilo2 = new Hilo("Hilo-prioridad 7");

        hilo1.setPriority(3);
        hilo2.setPriority(7);

        synchronized (hilo1) {
            hilo1.start();
            try {
                hilo1.wait(); // Esperar a que hilo1 notifique antes de continuar
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        synchronized (hilo2) {
            hilo2.start();
            try {
                hilo2.wait(); // Esperar a que hilo2 notifique antes de continuar
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Final programa");
    }
}

    