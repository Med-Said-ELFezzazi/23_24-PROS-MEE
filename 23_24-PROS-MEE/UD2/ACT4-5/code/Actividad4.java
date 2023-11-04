package paquete;

public class Actividad4 {
    public static void main(String[] args) {
        Thread p = new Thread(new Posicion("Primero"));
        Thread s = new Thread(new Posicion("Segundo"));
        p.start();
        s.start();
        System.out.println("Fin programa");
    }
}

class Posicion implements Runnable {
    private String nombre;

    public Posicion(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 15; i++) {
            System.out.println(nombre + " " + i);
        }
    }
}

