package Ejercicio8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ejemploPing {
    public static void main(String[] args) {

        //Creo el runtime y el process para despues crear el proceso hijo.
        Runtime runTime = Runtime.getRuntime();
        Process process = null;

        try {
            //Le paso el argumento, y ya el programa termina el comando.   
            process = runTime.exec("ping " + args[0] + " -n 4");
            //Creamos el buffer para leer los datos del proceso hijo.
            BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));

            //Hago que el hijo imprima los datos, uno a uno.
            String linea;
            while ((linea = in.readLine()) != null) {
                System.out.println(linea);
            }
            //Hago un try-catch por si ocurre algo mientras se ejecuta.
        } catch (IOException e) {
            System.out.println("No pudimos correr el ping desde nuestra clase");
            System.exit(-1);
        }
            //Si el proceso no se ha terminado, se destruye.
        if (process != null) 
            process.destroy();

        //Como último recurso, el proceso padre espera por si el proceso no terminó de ejecutarse.
        try {
            process.waitFor();
        } catch (InterruptedException e) {
            System.out.println("No pudimos esperar porque termino");
            System.exit(-1);
        }
        System.out.println("Estado de termino: " + process.exitValue());
            System.exit(0);
    }
}
