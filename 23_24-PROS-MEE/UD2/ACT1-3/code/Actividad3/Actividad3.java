package p1;

public class Actividad3 {
    public static void main(String[] args) {
        Thread hilo = Thread.currentThread(); // Obtener el hilo actual

        // Mostrar los valores iniciales
        System.out.println("El nombre del hilo es " + hilo.getName() + " y tiene la prioridad " + hilo.getPriority());

        // Cambiar el nombre y la prioridad
        hilo.setName("SUPER-HILO-DM2");
        hilo.setPriority(6);

        // Mostrar los valores modificados
        System.out.println("Ahora el nombre del hilo es " + hilo.getName() + " y tiene la prioridad " + hilo.getPriority());

        System.out.println("Final programa");
    }
}
