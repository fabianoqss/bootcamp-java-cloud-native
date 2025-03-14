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



    public static void menu(){
        System.out.println("'---------- MENU ----------'");
        System.out.println("'Digite Para:'");
        System.out.println("1 - Abrir Conta ");
        System.out.println("2 - Remover Conta ");
        System.out.println("3 - Buscar Conta ");
        System.out.println("4 - Fazer Operação de Transferência ");
        System.out.println("5 - Exibir Todas as Contas do Banco ");
        System.out.println("6 - Para sacar Dinheiro ");
        System.out.println("7 - Para Depositar dinheiro ");
        System.out.println("8 - Imprimir extrato de uma Conta");
    }
}
