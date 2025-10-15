package Sintaxis.BufferedReaderWriter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Reader {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("entrada.txt"));
        String linea;
        while ((linea = br.readLine()) != null) {
            System.out.println(linea);
        }
        br.close();
    }
}
