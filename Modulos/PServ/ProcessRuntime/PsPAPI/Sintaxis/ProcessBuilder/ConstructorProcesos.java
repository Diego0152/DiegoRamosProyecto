package Sintaxis.ProcessBuilder;

import java.io.IOException;

public class ConstructorProcesos {
    public static void main(String[] args) throws IOException, InterruptedException {
        // Crear un ProcessBuilder para ejecutar un comando
        ProcessBuilder pb = new ProcessBuilder("ping", "google.com");

        // Iniciar el proceso
        Process proceso = pb.start();

        // Esperar a que termine
        int codigoSalida = proceso.waitFor();

        System.out.println("Proceso terminado con código: " + codigoSalida);
    }
    
}
