package paquete3;

public class Actividad14 extends Thread {
    public static void main(String args[]) {
        Recurso a = new Recurso();
        Recurso b = new Recurso();

        Hilo h1 = new Hilo(a, b, "uno");
        Hilo h2 = new Hilo(a, b, "dos"); // Cambiado el orden de los recursos

        h1.start();
        h2.start();
    }
}