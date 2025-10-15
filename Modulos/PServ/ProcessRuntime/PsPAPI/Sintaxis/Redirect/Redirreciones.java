package Sintaxis.Redirect;

import java.io.File;
import java.io.IOException;

public class Redirreciones {
    public static void main(String[] args) throws IOException, InterruptedException {
        ProcessBuilder pb = new ProcessBuilder("ls");

        //Son ficheros inventados, no va a ir
        pb.redirectInput(new File("entrada.txt"));
        pb.redirectOutput(new File("salida.txt"));  // salida estándar → archivo
        pb.redirectError(new File("errores.txt"));  // errores → archivo

        //Se puede tambien hacer a proceso pero es ma lioso
        //Para mas informacion sobre esto tambien puedes mirar el inheritIO
        Process p = pb.start();
        p.waitFor();
    }
}
