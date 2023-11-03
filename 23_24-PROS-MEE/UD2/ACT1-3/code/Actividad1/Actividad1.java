package paquete1;

public class Actividad1 {
    public static void main(String[] args) {
        Hilo hilo1 = new Hilo("Primero");
        Hilo hilo2 = new Hilo("Segundo");
        
        hilo1.start();
        hilo2.start();
        
        try {
            hilo1.join();
            hilo2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("Fin programa");
    }
    
}
