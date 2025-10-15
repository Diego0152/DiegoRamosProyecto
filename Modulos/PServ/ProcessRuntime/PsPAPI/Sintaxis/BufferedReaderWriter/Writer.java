package Sintaxis.BufferedReaderWriter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Writer {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("salida.txt"));
        bw.write("Hola mundo desde Java!");
        bw.newLine();
        bw.write("Segunda línea.");
        bw.close();
    }
}
