package Ejercicio7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class lecturaFicheros {
    public static void main(String[] args) {

        //Si el argumento no es solo 1, salta error y se sale del main.
        if (args.length != 1) {
            System.out.println("Error de formato: java <nombrePrograma> <nombreArchivo>");
            return;
            }

        // Variable que se le pasa el argumento.
        String nombreArchivo = args[0];

        try {
            //Con un .indexOf(".") rastreo el punto, para que al hacer el substring, busque el numero por detras de este.
            int punto = nombreArchivo.indexOf(".");
            //Con el posicionamiento pongo los 7 caracteres que tiene "fichero" para que si o si de con el numero.
            String posicionNumero = nombreArchivo.substring(7, punto);
            //paso a entero el numero que hemos rastreado.
            int numero = Integer.parseInt(posicionNumero);

            //Al numero que tenia el archivo le sumo 1, esto para no crear archivos con el mismo nombre.
            int numeroSumado = numero + 1;
            String nuevoArchivo = "fichero" + numeroSumado + ".txt";

            //creo el archivo nuevo, y los Buffered.
            File archivo = new File(nombreArchivo);
            BufferedReader bRead = new BufferedReader(new FileReader(archivo));
            BufferedWriter bWrite = new BufferedWriter(new FileWriter(nuevoArchivo));
            
            //creo la variable linea para depositar las lineas del primer archivo.
            String linea;
            //Y ya dentro del bucle paso los datos del primer archivo al archivo copia.
            while ((linea = bRead.readLine()) != null) {
                bWrite.write(linea);
                bWrite.newLine();
            }
            //Cerramos los Buffered
            bRead.close();
            bWrite.close();

        //hago un try-catch para evitar que salgan excepciones al dar error.
        } catch (IOException e) {
            System.out.println("Error al crear el nuevo archivo");
        }
        
    }
                
}
