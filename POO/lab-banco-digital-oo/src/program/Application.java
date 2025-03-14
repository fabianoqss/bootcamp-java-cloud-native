package program;

import model.entities.Banco;
import model.entities.Conta;

import java.util.Locale;
import java.util.Scanner;

public class Application {
    private static Banco banco = new Banco();
    private static Conta contas;
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
    Locale.setDefault(Locale.US);

        String answer;
        do {
            menu();
            int opcao = sc.nextInt();
            opcoes(opcao);




            System.out.println("Deseja continuar ou sair do programa? (S/N)");
            answer = sc.next();
        }while(answer.equalsIgnoreCase("S"));
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

    public static void opcoes(int opcao){

        switch(opcao){
            case 1-> abrirConta();
            case 2-> removeConta();
        }
    }

    public static void abrirConta(){
        System.out.println("Conta corrente ou Conta poupança ?");

    }

    public static void removeConta(){
        System.out.println("Digite o nome da conta ser removido: ");
        String nome = sc.nextLine();
        banco.removeConta(nome);
    }


}
