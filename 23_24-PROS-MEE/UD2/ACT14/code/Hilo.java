package paquete3;

class Hilo extends Thread {
    Recurso primero;
    Recurso segundo;

    public Hilo(Recurso a, Recurso b, String nombre) {
        super(nombre);
        // Asigna recursos en orden alfabético para prevenir el deadlock
        if (a.getNombre().compareTo(b.getNombre()) < 0) {
            primero = a;
            segundo = b;
        } else {
            primero = b;
            segundo = a;
        }
    }

    public void run() {
        System.out.println("Hilo " + this.getName() + " comienza");

        synchronized (primero) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (segundo) {
                System.out.println("Hilo " + this.getName() + " ha terminado");
            }
        }
    }
}