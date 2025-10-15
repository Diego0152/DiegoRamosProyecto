package propuestaEjercicio1;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class lanzador1 {
    //Los comandos para los procesos Ping y Find
    static final String[] COMANDO_PING = {"ping","www.google.es","-n","2"};
    static final String[] COMANDO_FIND = {"find","Media","propuestaEjercicio1/salida.txt"};

    public static void main(String[] args) {
        //Generamos el archivo para meter el resultado del ping
        File salidaOut = new File("propuestaEjercicio1/salida.txt");
        
        try {
            //Configuramos el proceso Ping, cambiando su salida al fichero.
            ProcessBuilder pPing = new ProcessBuilder(COMANDO_PING);
            pPing.redirectOutput(salidaOut);
            
            //Preparamos el proceso Find.
            ProcessBuilder pFind = new ProcessBuilder(COMANDO_FIND);

            //Iniciamos el proceso Ping, y esperamos a que termine de ejecutarse.
           Process procPing = pPing.start();
            Process procGrep = pFind.start();

            //  Crear flujos
            Scanner inDesdePing = new Scanner(procPing.getInputStream());
            PrintWriter outParaGrep = new PrintWriter(procGrep.getOutputStream());

            //  Leer del ping y escribir al grep
            while (inDesdePing.hasNextLine()) {
                String linea = inDesdePing.nextLine();
                outParaGrep.println(linea); // println añade salto de línea automático
            }

            // 🔹 Muy importante: cerrar la salida hacia grep
            outParaGrep.close();

            // 🔹 Ahora leer la salida del grep
            Scanner inDesdeGrep = new Scanner(procGrep.getInputStream());
            System.out.println("\nSalida filtrada (grep):\n");
            while (inDesdeGrep.hasNextLine()) {
                System.out.println(inDesdeGrep.nextLine());
            }

            // 🔹 Esperar a que ambos procesos terminen
            procPing.waitFor();
            procGrep.waitFor();

            inDesdePing.close();
            inDesdeGrep.close();

            System.out.println("\nProcesos finalizados correctamente.");
        } catch (IOException | InterruptedException e) {
            System.err.println("Error en el proceso Ping");
        }
    }
}
