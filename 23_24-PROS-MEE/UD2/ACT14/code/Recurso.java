package paquete3;

class Recurso {
    private String nombre;

    public Recurso() {
        nombre = java.util.UUID.randomUUID().toString();
    }

    public String getNombre() {
        return nombre;
    }
}