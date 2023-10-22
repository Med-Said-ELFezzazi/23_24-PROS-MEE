package paquete;

class Hilo extends Thread {
    private String mensaje;

    public Hilo(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public void run() {
        System.out.println(getName() + " tiene la prioridad " + getPriority());
        if (mensaje != null) {
            System.out.println("Ejecutando " + mensaje);
        }

        synchronized (this) {
            notify(); // Notificando al hilo principal de que ha terminado
        }
    }
}