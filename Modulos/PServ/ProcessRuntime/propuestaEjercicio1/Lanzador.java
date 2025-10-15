package propuestaEjercicio1;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Lanzador {
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
            Process procesoPing = pPing.start();

            int resultado = procesoPing.waitFor();
            //SI el resultado es 0, significa que se ha ejectutado perfectamente.
            if (resultado == 0) {
                System.out.println("El proceso Ping ha sido ejecutado correctamente");
            }
            //Iniciamos el proceso Find
            Process procesoFind = pFind.start();
            //Que lea la salida del proceso Find
            Scanner sc = new Scanner(procesoFind.getInputStream());
            String linea;
            //SI hay una linea que leer, la imprime a la consola.
            while (sc.hasNextLine()) {
                linea = sc.nextLine();
                System.out.println(linea);
            }
            //Verificamos si el proceso se ha ejecutado perfectamente.
            int resultado1 = procesoFind.waitFor();
            if (resultado1 == 0) {
                System.out.println("El proceso Find ha sido ejecutado correctamente");
            }

            //Cerramos el scanner.
            sc.close();
        } catch (IOException | InterruptedException e) {
            System.err.println("Error en el proceso Ping");
        }
    }
}
