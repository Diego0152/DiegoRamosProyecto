package Sintaxis.Scanner;

import java.util.Scanner;

public class leerEntrada {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce tu nombre: ");
        String nombre = sc.nextLine();
        System.out.println("Hola, " + nombre);
        sc.close();
    }
}
