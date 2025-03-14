package program;

import java.util.Locale;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        String answer;
        do {
        






            System.out.println("Deseja continuar ou sair do programa? (S/N)");
            answer = sc.next();
        }while(answer.equalsIgnoreCase("N"));
    }
}
