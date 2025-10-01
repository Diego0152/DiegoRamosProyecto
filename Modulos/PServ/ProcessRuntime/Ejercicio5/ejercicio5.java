import java.io.*;

public class ejercicio5 {
    public static void main(String[] args) {
        // Parte 1
        Runtime rt = Runtime.getRuntime();
        try {
            rt.exec("mspaint");
        } catch (Exception e) {
            e.getMessage();
        }

        // Parte 2
        try {
            if (args.length != 1) {
            System.out.println("Uso: java ejercicio5 <ruta_directorio>");
            return;
            }

            String directorio = args[0];
            Process p = Runtime.getRuntime().exec("cmd /c dir " + directorio);
            BufferedReader rd = new BufferedReader(new InputStreamReader(p.getInputStream()));
            
            String linea;
            while ((linea = rd.readLine()) != null) {
                System.out.println(linea);
            }

            p.waitFor();
        } catch (IOException | InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
