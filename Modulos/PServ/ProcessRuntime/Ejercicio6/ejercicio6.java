package Ejercicio6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejercicio6 {
   public static void main(String[] args) {
            
        if (args.length != 1) {
            System.out.println("Error de formato: java <nombrePrograma> <nombreArchivo>");
            return;
            }

            String fichero = "fichero2.txt";
            String nombreArchivo = args[0];
            File archivo = new File(nombreArchivo);

        try {
            
            Process p = Runtime.getRuntime().exec("cmd.exe /c type " + archivo);
            BufferedReader bRead = new BufferedReader(new InputStreamReader(p.getInputStream()));
            BufferedWriter bWriter = new BufferedWriter(new FileWriter(fichero));

            String linea;
            while ((linea = bRead.readLine()) != null) {
                System.out.println(linea);
                bWriter.write(linea);
                bWriter.newLine();
            }

            bWriter.close();
            p.waitFor();
        } catch (IOException | InterruptedException e) {
            System.out.println(e.getMessage());
        }
    } 
}
