package paquete1;

class Hilo extends Thread {
    private String mensaje;
    /**
     * metodo para instanciar los dos hilos
     * @param mensaje
     */
    public Hilo(String mensaje) {
        this.mensaje = mensaje;
    }

    public void run() {
        for (int i = 1; i <= 20; i++) {
            System.out.println(mensaje + " " + i);
        }
    }
}