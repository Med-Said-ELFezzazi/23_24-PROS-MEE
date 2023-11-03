package p1;

public class Actividad2 {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Uso: java Actividad2 <número de hilos>");
            return;
        }

        int n = Integer.parseInt(args[0]);

        for (int i = 1; i <= n; i++) {
            Thread hilo = new Hilo(i);
            hilo.start();
        }

        System.out.println("Final Programa");
    }
}
