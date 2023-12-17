package paquete;

import org.apache.commons.net.ftp.FTPClient;

public class Actividad1 {

    public static void main(String[] args) {
        // Creación de una instancia de FTPClient para interactuar con el servidor FTP
        FTPClient cliente = new FTPClient();
        // Datos del servidor FTP al que se conectará
        String servidor = "ftp.rediris.es";
        String usuario = "anonymous"; // Usuario 
        String clave = "dm2";         // Contraseña 

        try {
            // Mensaje inicial antes de realizar la conexión
            System.out.println("Nos conectamos a " + servidor);
            // Conexión al servidor FTP
            cliente.connect(servidor);

            // Intento de login con los datos proporcionados
            if (!cliente.login(usuario, clave)) {
                // Si el login falla, muestra un mensaje y desconecta
                System.out.println("Login incorrecto...");
                cliente.disconnect();
                // Sale del programa
                System.exit(1);
            }
            
            // Si el login es exitoso, continúa
            System.out.println("Login correcto");
            // Muestra el directorio actual en el servidor
            System.out.println("Directorio actual: " + cliente.printWorkingDirectory());

            // Intenta crear un directorio en el servidor
            if (cliente.makeDirectory("DM2PROS")) {
                // Si la creación es exitosa, muestra un mensaje
                System.out.println("Directorio creado....");
            } else {
                // Si falla la creación, muestra un mensaje
                System.out.println("NO SE HA PODIDO CREAR EL DIRECTORIO");
            }

            // Intenta cerrar la sesión en el servidor FTP
            if (cliente.logout()) {
                // Si el logout es exitoso, muestra un mensaje
                System.out.println("Logout del servidor FTP...");
            } else {
                // Si falla el logout, muestra un mensaje
                System.out.println("Error al hacer logout...");
            }

            // Desconecta del servidor FTP
            cliente.disconnect();
            // Mensaje final al desconectar
            System.out.println("Desconectado...");

        } catch (Exception e) {
            // En caso de cualquier excepción, imprime el error
            e.printStackTrace();
        } 
    }
}
