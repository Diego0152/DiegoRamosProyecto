package Sintaxis.OutputInput;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SalidaEntrada {
    public static void main(String[] args) throws IOException, InterruptedException {
        ProcessBuilder pb = new ProcessBuilder("nslookup");
        Process proceso = pb.start();

        //Envio con esto lienas al proceso
        BufferedWriter escritor = new BufferedWriter(new OutputStreamWriter(proceso.getOutputStream()));
        escritor.write("8.8.8.8");
        escritor.flush();
        escritor.close();
        
        //Y con esto leo la slaida de proceso hijo
        BufferedReader lector = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
        String linea;
        while ((linea = lector.readLine()) != null) {
            System.out.println(linea);
        }

        int codigo = proceso.waitFor();
        System.out.println("Código de salida: " + codigo);
    }
}
