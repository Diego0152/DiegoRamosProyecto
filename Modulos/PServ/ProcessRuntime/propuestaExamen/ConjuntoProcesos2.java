package propuestaExamen;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ConjuntoProcesos2 {

    //Hacemos los 3 arrays constantes para los comandos que vamos a utilizar. 
    static final String[] COMANDO = {"jar", "cf", "realizar-calculo.jar", "RealizarCalculo.class"};
    static final String[] COMANDO_COMPILER = {"javac","RealizarCalculo.java"};
    static final String[] COMANDO_EJEC = {"java","-cp","realizar-calculo.jar","RealizarCalculo"};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Escribe una linea de calculo ejemplo: 12 - 2 4 + 1.");
        String linea = sc.nextLine();
        
        if (!linea.isEmpty()) {
            try {

                // Hacer el compilador
                ProcessBuilder pComp = new ProcessBuilder(COMANDO_COMPILER);
                Process procesoComp = pComp.start();
                procesoComp.waitFor();

                // Crear JAR
                ProcessBuilder pJar = new ProcessBuilder(COMANDO);
                Process procesoJar = pJar.start();
                procesoJar.waitFor();

                // Ejecutar JAR
                ProcessBuilder pEjec = new ProcessBuilder(COMANDO_EJEC);
                Process procesoEjec = pEjec.start();

                // Enviar texto al hijo con println + autoFlush
                try (PrintWriter outEjec = new PrintWriter(procesoEjec.getOutputStream(), true)) {
                    outEjec.println(linea);
                }

                // Leer toda la salida del hijo
                try (Scanner scIn = new Scanner(procesoEjec.getInputStream())) {
                    while (scIn.hasNextLine()) {
                        System.out.println(scIn.nextLine()); 
                    }
                }
                //Hacemos que el padre mate al hijo, y así conseguir el texto para después que termine el padre imprimiendo el texto.
                procesoEjec.waitFor();
                sc.close();
            } catch (IOException | InterruptedException e) {
                System.out.println("Error al crear o ejecutar el .jar:");
            }
        } else {
            System.out.println("No se escribió ninguna línea.");
        }
    }
}