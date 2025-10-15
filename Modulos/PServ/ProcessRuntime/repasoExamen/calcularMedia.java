package repasoExamen;

import java.util.Scanner;

public class calcularMedia {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String linea; 

        while (sc.hasNextLine()) {

            linea = sc.nextLine();

            String[] numeros = linea.split(",");
            double suma = 0;
            
            for (String numero : numeros) {
                suma = suma + Double.parseDouble(numero);
            }
            
            double media = suma / numeros.length;
            System.out.printf("%.2f%n", media);
        }
        
        sc.close();
    }
}
