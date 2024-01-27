package paquete;

import java.security.Provider;
import java.security.Security;

public class Actividad1 {
	
	
	public static void main(String[] args) {
	    Provider provider = Security.getProvider("SUN");
	    System.out.println("** Proveedor " + provider.getName() + ", Version: " + provider.getVersion() + " **");

	    for (Provider.Service service : provider.getServices()) {
	        if (service.getType().equals("MessageDigest")) {
	            System.out.println("\tNombre del algoritmo: \"" + service.getAlgorithm() + "\"");
	        }
	    }
	}

}
