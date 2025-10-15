package repasoExamen;

import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class main {

    private static String[] COMPILADOR_MEDIA = {"javac","repasoExamen\\calcularMedia.java"};
    private static String[] COMPILADOR_MEDIA_GENERAL = {"javac","repasoExamen\\calcularMediaGeneral.java"};

    private static String[] LANZADOR_MEDIA = {"java","repasoExamen\\calcularMedia.java"};
    private static String[] LANZADOR_MEDIA_GENERAL = {"java","repasoExamen\\calcularMediaGeneral.java"};
    public static void main(String[] args) {
        /*
         * El ejercicio consistirá en tres procesos y dos ficheros.
         * 
         * 1 El programa mostrará un menú con distintas opciones:
         * En la primera opción, el usuario introducirá varios números por consola.
         * El programa calculará la media de esos números, como si se tratara de calcular la nota media de un examen.
         * 
         * 2 En la segunda opción, el programa tomará todas esas medias y calculará una media general.
         * 
         * 3 El primer proceso se encargará de compilar los otros dos y ejecutarlos.
         * 
         * 4 El segundo proceso leerá los datos del fichero mediante una redirección, los procesará calculando la media y, 
         * posteriormente, enviará el resultado a otro fichero llamado resultados.txt.
         * 
         * 5 El tercer proceso tomará todos los ficheros resultados.txt generados y calculará la media final.
         * Desarolla un esquema para ayudarte y despues programalo, suerte. 
         */
        

        try {

            File fichDat = new File("repasoExamen\\datos.txt");
            fichDat.createNewFile();
            new FileWriter(fichDat, false).close();


            File fichResult = new File("repasoExamen\\resultados.txt");
            fichResult.createNewFile();
            new FileWriter(fichResult, false).close();


            ProcessBuilder pbCompM = new ProcessBuilder(COMPILADOR_MEDIA);
            ProcessBuilder pbCompMG = new ProcessBuilder(COMPILADOR_MEDIA_GENERAL);

            Process pCompM = pbCompM.start();
            Process pCompMG = pbCompMG.start();

            int estadoCompM = pCompM.waitFor();
            int estadoCompMG = pCompMG.waitFor();

            if (estadoCompM != 0) {
                System.err.println("El proceso pCompM no se ha terminado correctamente.");
            }
            if (estadoCompMG != 0) {
                System.err.println("El proceso pCompMG no se ha terminado correctamente.");
            }

            Scanner sc = new Scanner(System.in);
            String menu = """
                Escoge entre estas dos opciones:
                1) Media de los valores.
                2) Media general.
                Otra opción salir.
                    """;
            int opciones;
            do {
                System.out.println(menu);
                opciones = sc.nextInt(); 
                sc.nextLine();
                switch (opciones) {
                    case 1 -> {
                        
                        try {
                            Scanner scExeM = new Scanner(System.in);
                        
                            System.out.println("Coloca los valores para hacer la media, con este formato: (1,2,3,4,5,6,...)");
                            String valores = scExeM.nextLine();
                        
                            PrintWriter pWrit = new PrintWriter(new FileWriter(fichDat, true));
                            pWrit.println(valores);     
                            pWrit.close();                 

                            ProcessBuilder pbExeM = new ProcessBuilder(LANZADOR_MEDIA);
                            pbExeM.redirectInput(fichDat);
                            pbExeM.redirectOutput(fichResult);

                            if (valores.length() != 0) {
                                Process pExeM = pbExeM.start();

                                int estadoExeM = pExeM.waitFor();
                                if (estadoExeM != 0) {
                                    System.err.println("El proceso pExeM no se ha terminado correctamente.");
                                }
                                System.out.println("Se ha realizado la media correspondiente.");
                                System.out.println("");
                            }

                            break;
                        
                        } catch (IOException e) {
                            System.err.println("Error en la opción 1.");
                            return;
                        }
                    }
                    case 2 -> {

                        try {
                            ProcessBuilder pbExeMG = new ProcessBuilder(LANZADOR_MEDIA_GENERAL);
                            pbExeMG.redirectInput(fichResult);
                            pbExeMG.redirectOutput(ProcessBuilder.Redirect.INHERIT);
                            
                            Process pExeMG = pbExeMG.start();
                            int estadoExeMG = pExeMG.waitFor();
                            if (estadoExeMG != 0) {
                                System.err.println("El proceso pExeMG no se ha terminado correctamente.");
                            }

                            break;
                        
                        } catch (IOException e) {
                            System.err.println("Error en la opción 2.");
                            return;
                        }
                    }
                        
                    default -> {
                        System.out.println("Saliendo del programa.");
                        return;
                    }
                }
            } while (opciones < 3 && opciones > 0);


            sc.close();

        } catch (IOException | InterruptedException e) {
            System.err.println("Error al ejecutar el sistema.");
        }
    }
}
