package propuestaExamen;

import java.util.Scanner;

public class convertirMayusculas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextLine()) {
            String linea = sc.nextLine();
            System.out.println(linea.toUpperCase());
            System.out.flush(); 
        }
    }
}
