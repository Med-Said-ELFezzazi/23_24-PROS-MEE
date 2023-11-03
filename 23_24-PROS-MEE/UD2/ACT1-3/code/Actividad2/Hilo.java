package p1;

class Hilo extends Thread {
    private int numeroHilo;

    public Hilo(int numeroHilo) {
        this.numeroHilo = numeroHilo;
    }

    public void run() {
        for (int i = 1; i <= 20; i++) {
            System.out.println("Hilo " + numeroHilo);
        }
    }
}
