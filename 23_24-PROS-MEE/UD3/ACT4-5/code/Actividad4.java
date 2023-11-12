package paquete;

import java.net.URL;

class Actividad4 {
    public static void main(String[] args) {
        URL url1, url2, url3, url4;

        try {
            // Constructor simple para una URL
            url1 = new URL("http://docs.oracle.com");
            Visualizar(url1);

            // Constructor para protocolo, host y directorio
            url2 = new URL("http://docs.oracle.com/javase/7");
            Visualizar(url2);

            // Constructor para protocolo, host, puerto y directorio
            url3 = new URL("http://docs.oracle.com:80/javase/7");
            Visualizar(url3);

            // Constructor para un objeto URL y su directorio
            url4 = new URL(url2, "/docs/api/java/net/URL.html");
            Visualizar(url4);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void Visualizar(URL url) {
        System.out.println("Constructor simple para una URL:");
        System.out.println("\tMétodo toString(): " + url.toString());
        System.out.println("\tMétodo getProtocol(): " + url.getProtocol());
        System.out.println("\tMétodo getHost(): " + url.getHost());
        System.out.println("\tMétodo getPort(): " + url.getPort());
        System.out.println("\tMétodo getFile(): " + url.getFile());
        System.out.println("\tMétodo getUserInfo(): " + url.getUserInfo());
        System.out.println("\tMétodo getPath(): " + url.getPath());
        System.out.println("\tMétodo getAuthority(): " + url.getAuthority());
        System.out.println("\tMétodo getQuery(): " + url.getQuery());
        System.out.println();
    }
}

