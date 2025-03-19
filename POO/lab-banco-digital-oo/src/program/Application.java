package program;

import model.entities.*;
import model.enums.CategoriaConta;
import model.exception.SaldoInsuficienteException;
import model.interfaces.IConta;

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

            System.out.println("Deseja continuar ou sair do programa? (Sim/Não)");
            System.out.println("Sim - para continuar.");
            System.out.println("Não - Para sair.");
            answer = sc.next();
        }while(answer.equalsIgnoreCase("Sim"));
    }



    public static void menu(){
        System.out.println("'---------- MENU ----------'");
        System.out.println("1 - Abrir Conta ");
        System.out.println("2 - Remover Conta ");
        System.out.println("3 - Fazer Operação de Transferência ");
        System.out.println("4 - Exibir Todas as Contas do Banco ");
        System.out.println("5 - Para sacar Dinheiro ");
        System.out.println("6 - Para Depositar dinheiro  ");
        System.out.println("7 - Imprimir extrato de uma Conta ");
        System.out.println("Escolha uma opção: ");
    }

    public static void opcoes(int opcao){

        switch(opcao){
            case 1-> abrirConta();
            case 2-> removeConta();
            case 3-> transferencia();
            case 4-> buscartodasAsContas();
            case 5-> saque();
            case 6-> deposito();
            case 7-> imprimeExtrato();
            default -> System.out.println("Opção inválida! Tente novamente.");
        }
    }

    public static void abrirConta(){
        sc.nextLine();
        CategoriaConta tipoConta = null;

        while (tipoConta == null) {
            System.out.println("Conta Corrente ou Conta Poupança? (CORRENTE/POUPANCA)");
            String tipoContaStr = sc.nextLine().toUpperCase();

            try {
                tipoConta = CategoriaConta.valueOf(tipoContaStr);
            } catch (IllegalArgumentException e) {
                System.out.println("Opção inválida! Digite 'CORRENTE' ou 'POUPANCA'.");
            }
        }

        System.out.println("Digite o Número da Agência: ");
        int numberAgency = sc.nextInt();

        System.out.println("Digite o número da conta: ");
        int numberAccount = sc.nextInt();

        System.out.println("Existe saldo inicial? (Sim/Não)");
        sc.nextLine();
        double saldoInicial = 0;
        if (sc.nextLine().equalsIgnoreCase("Sim")){
            System.out.println("Digite o saldo inicial: ");
            saldoInicial = sc.nextDouble();
            sc.nextLine();
        }
            System.out.println("Digite o nome do cliente: ");
            String cliente = sc.nextLine();

            if (tipoConta == CategoriaConta.CORRENTE) {
                banco.adicionarConta(new ContaCorrente(numberAgency, numberAccount, saldoInicial, new Cliente(cliente)));
            } else if (tipoConta == CategoriaConta.POUPANCA) {
                banco.adicionarConta(new ContaPoupanca(numberAgency, numberAccount, saldoInicial, new Cliente(cliente)));
            }

    }

    public static void removeConta(){
        sc.nextLine();
        System.out.println("Digite o nome da conta ser removido: ");
        String nome = sc.nextLine();
        banco.removeConta(nome);
    }


    public static void transferencia(){
        System.out.println("Digite o número da conta de origem: ");
        int numeroOrigem = sc.nextInt();

        System.out.println("Digite o número da conta de destino: ");
        int numeroDestino = sc.nextInt();

        System.out.println("Digite o valor a transferir: ");
        double valor = sc.nextDouble();

        IConta contaOrigem = banco.buscarConta(numeroOrigem);
        IConta contaDestino = banco.buscarConta(numeroDestino);

        if (contaOrigem == null || contaDestino == null) {
            System.out.println("Conta de origem ou destino não encontrada!");
            return;
        }

        try {
            contaOrigem.transferir(valor, contaDestino);
            System.out.println("Transferência realizada com sucesso!");
        } catch (SaldoInsuficienteException e) {
            System.out.println("Erro: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro inesperado: " + e.getMessage());
        }
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
        conta.imprimirExtrato();
    }
}
