package propuestaExamen;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class conjuntoProcesos {

    static final String[] COMANDO = {"jar", "cf", "convertir-mayusculas.jar", "propuestaExamen.convertirMayusculas.class"};
    static final String[] COMANDO_EJEC = {"java","-cp","convertir-mayusculas.jar","propuestaExamen.convertirMayusculas"};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe una línea de texto:");
        String texto = sc.nextLine();

        if (texto != null && !texto.isEmpty()) {
            try {
                // Crear JAR
                ProcessBuilder pJar = new ProcessBuilder(COMANDO);
                Process procesoJar = pJar.start();
                procesoJar.waitFor();

                // Ejecutar JAR
                ProcessBuilder pEjec = new ProcessBuilder(COMANDO_EJEC);
                Process procesoEjec = pEjec.start();

                // Enviar texto al hijo con println + autoFlush
                try (PrintWriter outJar = new PrintWriter(procesoEjec.getOutputStream(), true)) {
                    outJar.println(texto);
                }

                // Leer toda la salida del hijo
                try (Scanner scIn = new Scanner(procesoEjec.getInputStream())) {
                    while (scIn.hasNextLine()) {
                        String resultado = scIn.nextLine();
                        System.out.println(resultado.toUpperCase()); 
                    }
                }

                procesoEjec.waitFor();

            } catch (IOException | InterruptedException e) {
                System.out.println("Error al crear o ejecutar el .jar:");
            }
        } else {
            System.out.println("No se escribió ninguna línea.");
        }
    }
}