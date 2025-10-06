import java.util.Scanner;

public class RealizarCalculo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextLine()) {return;}

        String[] tokens = sc.nextLine().split(" ");
        /*El formato es el siguiente:
         * valor1 " " simbolo " " valor2
         * Y así se repite hasta que termine.
         * Por eso en el for al valor i se le suma 3
         * porque una sentencia son 3 variables
         * valor1, simbolo y valor2 
         */
        for (int i = 0; i < tokens.length; i += 3) {
            double v1 = Double.parseDouble(tokens[i]);
            String simbolo = tokens[i + 1];
            double v2 = Double.parseDouble(tokens[i + 2]);

            switch (simbolo) {
                case "+" -> System.out.println(v1 + " + " + v2 + " = " + (v1 + v2));
                case "-" -> System.out.println(v1 + " - " + v2 + " = " + (v1 - v2));
                case "*" -> System.out.println(v1 + " * " + v2 + " = " + (v1 * v2));
                case "/" -> System.out.println(v1 + " / " + v2 + " = " + (v1 / v2));
                default -> System.out.println("Operador no válido: " + simbolo);
            }
        }

        sc.close();
    }
}
