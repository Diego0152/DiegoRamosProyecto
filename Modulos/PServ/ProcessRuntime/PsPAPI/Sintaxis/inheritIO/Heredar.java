package Sintaxis.inheritIO;

import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;

public class Heredar {
    public static void main(String[] args) throws IOException, InterruptedException {

        ProcessBuilder pb = new ProcessBuilder("java", "--version");
        // Heredar todo :
        pb.inheritIO(); // usa la misma consola

        // Solo heredar lo que te interesa (normalmente la salida)
        pb.redirectInput(Redirect.INHERIT); // Usar STDIN del padre
        pb.redirectOutput(Redirect.INHERIT); // Usar STDOUT del padre
        pb.redirectError(Redirect.INHERIT); // Usar STDERR del padre

        Process p = pb.start();
        p.waitFor();
    }
}
