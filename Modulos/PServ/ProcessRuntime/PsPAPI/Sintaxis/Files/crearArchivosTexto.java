package Sintaxis.Files;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class crearArchivosTexto {
    public static void main(String[] args) {
        File file = new File("archivo.txt");
        System.out.println("Existe: " + file.exists());
        System.out.println("Ruta absoluta: " + file.getAbsolutePath());
        System.out.println("Es directorio: " + file.isDirectory());

        //Tambien se puede usar el fileWriter Y fileReader:
        try {
            FileWriter fl = new FileWriter(file, true);
            fl.write("hola");
            fl.write(",");
            fl.close();
            FileReader fr = new FileReader(file);
            System.out.println(fr.readAllLines());
            fr.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
