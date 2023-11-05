package actividad11;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

class Actividad11 {
	@SuppressWarnings("deprecation")

    public static void main(String[] args) {
        Runtime r = Runtime.getRuntime();
        // Aquí puedes definir el comando que desees ejecutar
        //String comando = "ls -al"; // Por ejemplo, en Linux
        String comando = "CMD /C DIR"; // Por ejemplo, en Windows
        Process p = null;
        try {
            p = r.exec(comando);
            InputStream is = p.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String linea;
            while ((linea = br.readLine()) != null)
                System.out.println(linea);
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        int exitVal;
        try {
            exitVal = p.waitFor();
            System.out.println("Valor de Salida " + exitVal);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}