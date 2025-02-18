package application;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Por favor, digite o número da sua agência");
        int number = sc.nextInt();

        System.out.println("Por favor, digite o número a Agência");
        String agency = sc.nextLine();

        System.out.println("Por favor, digite o Nome do Cliente: ");
        

        System.out.println("Por favor, digite o saldo Inicial da conta: ");

    }
}
