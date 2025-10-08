package propuestaEjercicio1;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Lanzador {
    static final String[] COMANDO_PING = {"ping","www.google.es","-n","2"};
    static final String[] COMANDO_FIND = {"find","Media"};

    public static void main(String[] args) {
        File salidaOut = new File("propuestaEjercicio1/salida.txt");
        
        try {
            ProcessBuilder pPing = new ProcessBuilder(COMANDO_PING);
            pPing.redirectOutput(salidaOut);

            ProcessBuilder pFind = new ProcessBuilder(COMANDO_FIND);
            pFind.redirectInput(salidaOut);

            Process procesoPing = pPing.start();
            PrintWriter printPing = new PrintWriter(procesoPing.getOutputStream(), true);
            printPing.println(salidaOut);

            int resultado = procesoPing.waitFor();
            if (resultado == 0) {
                System.out.println("El proceso ha sido ejecutado correctamente");
            }
            Process procesoFind = pFind.start();
            Scanner sc = new Scanner();
            
            


        } catch (IOException | InterruptedException e) {
            System.err.println("Error en el proceso Ping");
        }
        


        
    }
}
