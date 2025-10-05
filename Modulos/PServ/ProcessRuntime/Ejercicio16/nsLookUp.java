package Ejercicio16;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class nsLookUp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String linea;

        System.out.println("Introducir nombre del dominio:");
        while ((linea = sc.nextLine()) != null && !linea.isEmpty()) {
            try {
                //Creamos el proceso con el comando nslookup
                ProcessBuilder pb = new ProcessBuilder("nslookup");
                //Hacemos que comparta la misma salida el hijo que el padre.
                pb.redirectOutput(ProcessBuilder.Redirect.INHERIT);

                Process proceso = pb.start();
                
                //Mandamos las lineas que cogemos del proceso hijo, y las imprimimos.
                try (PrintWriter out = new PrintWriter(proceso.getOutputStream())) {
                    out.println(linea); 
                    out.flush();
                }
                proceso.waitFor();

            } catch (IOException | InterruptedException e) {
                System.out.println("Error al ejecutar el comando nslookup");
            }

            System.out.println("\nIntroduce otro dominio (Cadena vacía para salir):");
        }
    }
}