package paquete;

import java.io.FileInputStream;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;

public class Actividad2 {
    public static void main(String[] args) {
        try {
            // Leer la clave pública
            FileInputStream keyfis = new FileInputStream("src/paquete/Clave.publica");//La ruta del fichero en me caso src/paquete...
            byte[] encKey = keyfis.readAllBytes();
            keyfis.close();

            X509EncodedKeySpec pubKeySpec = new X509EncodedKeySpec(encKey);
            KeyFactory keyFactory = KeyFactory.getInstance("DSA");
            PublicKey pubKey = keyFactory.generatePublic(pubKeySpec);

            // Leer la firma del fichero
            FileInputStream sigfis = new FileInputStream("src/paquete/FICHERO.FIRMA");//La ruta del fichero en me caso src/paquete...
            byte[] sigToVerify = sigfis.readAllBytes();
            sigfis.close();

            // Inicializar el objeto Signature
            Signature sig = Signature.getInstance("SHA1withDSA");
            sig.initVerify(pubKey);

            // Leer el fichero de datos y suministrarlo a Signature
            FileInputStream datafis = new FileInputStream("src/paquete/FICHERO.DAT");//La ruta del fichero en me caso src/paquete...
            byte[] buffer = new byte[1024];
            int len;
            while (datafis.available() != 0) {
                len = datafis.read(buffer);
                sig.update(buffer, 0, len);
            }
            datafis.close();

            // Verificar la firma
            boolean verifies = sig.verify(sigToVerify);
            System.out.println("LOS DATOS " + (verifies ? "SE CORRESPONDEN CON SU FIRMA" : "NO SE CORRESPONDEN CON SU FIRMA"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
