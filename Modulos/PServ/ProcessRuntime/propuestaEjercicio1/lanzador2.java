package propuestaEjercicio1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class lanzador2 {
    public static void main(String[] args) {
        try {
            //  Comandos Windows
            String[] COMANDO_PING = {"ping", "-n", "2", "google.com"};
            String[] COMANDO_FIND = {"find","Media","propuestaEjercicio1/salida.txt"};

            // Crear los ProcessBuilder
            ProcessBuilder pbPing = new ProcessBuilder(COMANDO_PING);
            ProcessBuilder pbFind = new ProcessBuilder(COMANDO_FIND);

            // Iniciar ambos procesos
            Process pPing = pbPing.start();
            Process pFind = pbFind.start();

            // Flujos de comunicación
            // Del ping al padre
            Scanner inDesdePing = new Scanner(pPing.getInputStream());

            // Del padre al find
            PrintWriter outParaFind = new PrintWriter(pFind.getOutputStream());

            // Leer del ping y mandar al find
            while (inDesdePing.hasNextLine()) {
                String lineaPing = inDesdePing.nextLine();
                outParaFind.println(lineaPing);
            }

            // Cerramos el flujo de salida hacia find
            outParaFind.close();

            // Ahora el padre recupera los datos de la salida del Find
            Scanner inDesdeFind = new Scanner(pFind.getInputStream());

            System.out.println("\n--- Resultados filtrados del Find ---\n");
            while (inDesdeFind.hasNextLine()) {
                String lineaFind = inDesdeFind.nextLine();
                // Aquí puedes procesar la línea en lugar de imprimirla directamente
                System.out.println(lineaFind);
            }

            // Esperar que terminen ambos procesos
            pPing.waitFor();
            pFind.waitFor();

            // Cerrar todos los flujos
            inDesdePing.close();
            inDesdeFind.close();

            System.out.println("\nProcesos finalizados correctamente.");

        } catch (IOException | InterruptedException e) {
            System.err.println("Error ejecutando procesos: " + e.getMessage());
            Thread.currentThread().interrupt();
        }
    }
}
