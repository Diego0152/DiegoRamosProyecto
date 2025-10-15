package repasoExamen;

import java.util.Scanner;

public class calcularMediaGeneral {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String linea;

        double contador = 0;
        double suma = 0;


        while (sc.hasNextLine()) {

            linea = sc.nextLine().trim().replace(",", ".");
            contador++;
        
            suma = suma + Double.parseDouble(linea);
            
        }
        double media = suma / contador;
        System.out.printf("La media general es: %.2f%n", media);
        
        sc.close();
           
    }
}
