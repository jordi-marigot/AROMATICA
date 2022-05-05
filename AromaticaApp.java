package plantid5; // incluim dintre del package del grup 5

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class AromaticaApp {

    public static void main(String[] args) {
    	boolean error = true;
        Scanner s= new Scanner(System.in);    
        DirectoryStream<Path> llista;

        // Bucle per preguntar les vegades que calgui el directori si no s'introdueix un correctament
        while (error == true) {
	        System.out.println("Introdueix el directori per obtenir els arxius i les mides: ");
	
	        // Afegim el directori indicat per l'usuari al objecte path per fer el tractament
	        Path p = Paths.get(s.nextLine());
	        
	        // Comprovació de directori existent
	        if(Files.exists(p) || Files.isDirectory(p)) { //comprovar si es un directori
	    
	        	// Obtenció del nom i la mida dels fitxers
	            try {
	                llista= Files.newDirectoryStream(p);
	                System.out.println("Nom del fitxer                                     Mida (bytes)	");
	                System.out.println("----------------------------------------------------------------");
	                for(Path f: llista) {
	                	if (Files.isDirectory(f) == false) { //comprovar que no sigui un directori
		                	System.out.printf("%-50s %d\n", f.getFileName(), Files.size(f)); 
		                	System.out.println("----------------------------------------------------------------");
	                	}
	                }
	                error = false;
	            }
	            catch(IOException ioex){
	                System.out.println("ERROR EN LA LECTURA DE LA CARPETA/FITXER");
	            }
	        }
	        else {
	            System.out.println("El path introduït no existeix o no es correcte...");
	        }
        }
    }

}
