package Ejercicio11;

import java.io.IOException;
import java.util.Scanner;

public class processBuilder {
    public static void main(String[] args) {

        if (args.length != 1) {
            System.out.println("Formato: java <nombre del .java> <nombre del fichero>");
            return;
        }

        String nombreFichero = args[0];

        try {
            ProcessBuilder pb = new ProcessBuilder("cmd", "/çc", "type", nombreFichero);
            Process proceso = pb.start();
        
            Scanner sc = new Scanner(proceso.getInputStream());
            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            } 
            
            proceso.waitFor();
        } catch (IOException | InterruptedException e) {
            System.out.println("Error al ejecutar el comando.");
        }
    }
    
}
