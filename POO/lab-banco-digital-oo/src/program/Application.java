package program;

import model.entities.*;
import model.enums.CategoriaConta;
import model.exception.SaldoInsuficienteException;

import java.util.Locale;
import java.util.Scanner;

public class Application {
    private static Banco banco = new Banco();
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
        System.out.println("1 - Abrir Conta "); // V
        System.out.println("2 - Remover Conta ");// V
        System.out.println("3 - Buscar Conta ");
        System.out.println("4 - Fazer Operação de Transferência ");
        System.out.println("5 - Exibir Todas as Contas do Banco "); // V
        System.out.println("6 - Para sacar Dinheiro ");
        System.out.println("7 - Para Depositar dinheiro ");
        System.out.println("8 - Imprimir extrato de uma Conta");
    }

    public static void opcoes(int opcao){

        switch(opcao){
            case 1-> abrirConta();
            case 2-> removeConta();
            case 3-> buscarUmaConta();
            case 4-> transferencia();
            case 5-> buscartodasAsContas();
            case 6-> saque();
            case 7-> deposito();
            case 8-> imprimeExtrato();
        }
    }

    public static void abrirConta(){
        System.out.println("Conta corrente ou Conta poupança ?");
        String tipoContaStr = sc.nextLine().toUpperCase();
        CategoriaConta tipoConta = CategoriaConta.valueOf(tipoContaStr);

        System.out.println("Digite o Número da Agência: ");
        int numberAgency = sc.nextInt();

        System.out.println("Digite o número da conta: ");
        int numberAccount = sc.nextInt();

        System.out.println("Existe saldo inicial? (Sim/Não)");
        sc.nextLine();
        double saldoInicial = 0;
        if (sc.nextLine().equalsIgnoreCase("Sim")){
            System.out.println("Se existir , digite o saldo inicial");
            saldoInicial = sc.nextDouble();
        }



        System.out.println("Digite o nome do cliente: ");
        String cliente = sc.nextLine();

        if (tipoConta == CategoriaConta.CORRENTE){
        banco.adicionarConta(new ContaCorrente(numberAgency, numberAccount, saldoInicial, new Cliente(cliente)));
        }else if(tipoConta == CategoriaConta.POUPANCA){
        banco.adicionarConta(new ContaPoupanca(numberAgency, numberAccount, saldoInicial, new Cliente(cliente)));
        }
    }

    public static void removeConta(){
        System.out.println("Digite o nome da conta ser removido: ");
        String nome = sc.nextLine();
        banco.removeConta(nome);
    }

    public static void buscarUmaConta(){
    }

    public static void transferencia(){
    }

    public static void buscartodasAsContas(){
        banco.imprimeContas();
    }

    public static void saque(){
        System.out.println("Digite o número da conta: ");
        int numeroConta = sc.nextInt();

        Conta conta = banco.buscarConta(numeroConta);
        if (conta == null) {
            System.out.println("Conta não encontrada!");
            return;
        }

        System.out.println("Digite o valor do saque: ");
        double valor = sc.nextDouble();

        try {
            conta.sacar(valor);
            System.out.println("Saque realizado com sucesso!");
        } catch (SaldoInsuficienteException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void deposito(){
        System.out.println("Digite o número da conta: ");
        int numeroConta = sc.nextInt();

        Conta conta = banco.buscarConta(numeroConta);
        if (conta == null) {
            System.out.println("Conta não encontrada!");
            return;
        }

        System.out.println("Digite o valor do depósito: ");
        double valor = sc.nextDouble();
        conta.depositar(valor);
        System.out.println("Depósito realizado com sucesso!");
    }

    public static void imprimeExtrato(){
        System.out.println("Digite o número da conta: ");
        int numeroConta = sc.nextInt();

        Conta conta = banco.buscarConta(numeroConta);
        if (conta == null) {
            System.out.println("Conta não encontrada!");
            return;
        }

        conta.imprimirInfosComuns();
    }
}
