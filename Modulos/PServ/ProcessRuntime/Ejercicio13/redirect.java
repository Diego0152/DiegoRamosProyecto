package Ejercicio13;

import java.io.File;
import java.io.IOException;

public class redirect {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Formato: java <nombre del .java> <nombre del fichero>");
            return;
        }

        String nombreFichero = args[0];
        File file = new File(nombreFichero);

        try {
            ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "dir");
            pb.redirectOutput(file);   
            Process proceso = pb.start();


    
            proceso.waitFor();
        } catch (IOException | InterruptedException e) {
            System.out.println("Error al ejecutar el comando.");
        }
    }
}