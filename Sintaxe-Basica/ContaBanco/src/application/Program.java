package application;

import model.entities.ContaTerminal;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<ContaTerminal> account = new ArrayList<>();

        System.out.println("Por favor, digite o número da sua Conta: ");
        int number = sc.nextInt();

        System.out.println("Por favor, digite o número da Agência: ");
        String agency = sc.next();

        System.out.println("Por favor, digite o Nome do Cliente: ");
        String clientName = sc.next();

        System.out.println("Tem Saldo Inicial ? (Y/N) ");
        char answer = sc.next().charAt(0);



        if(answer == 'Y'){
            System.out.println("Digite o Saldo: ");
            double balance = sc.nextDouble();

            account.add(new ContaTerminal(number, agency, clientName, balance));
        }else {
            account.add(new ContaTerminal(number, agency, clientName));
        }

        System.out.println("Deseja realizar Operações de Saque? (Y/N)" );
        char answerBalance = sc.next().charAt(0);

        if (answerBalance == 'Y') {
            System.out.println("Digite o número da conta que deseja fazer o Saque: ");
            int accountNumber = sc.nextInt();

            System.out.println("Digite o valor que deseja sacar: ");
            boolean saqueRealizado = false;

            for (ContaTerminal c : account) {
                if (c.getNumber() == accountNumber) {
                    if (c.getBalance() <= 0.0) {
                        System.out.println("A conta não tem saldo disponível.");
                        break;
                    } else {
                        c.withdraw(sc.nextDouble());
                        saqueRealizado = true;
                        break;
                    }
                }
            }

            if (!saqueRealizado) {
                System.out.println("Conta não encontrada ou saldo insuficiente.");
            }
        }

        System.out.println("Deseja realizar Operações de Deposito? (Y/N)" );
        char answerBalance2 = sc.next().charAt(0);

        if(answerBalance2 == 'Y'){
            System.out.println("Digite o número da conta que deseja fazer o Deposito: ");
            int accountNumber = sc.nextInt();

            System.out.println("Digite o valor que deseja depositar: ");
            sc.nextLine();
            for(ContaTerminal c : account){
                if(c.getNumber() == accountNumber){
                    c.deposit(sc.nextDouble());
                }
            }
        }

        System.out.println("Digite o número da conta que deseja verificar o status: ");
        int numberAccount = sc.nextInt();

        for (ContaTerminal accountt : account){
            if (numberAccount == accountt.getNumber()){
                System.out.println(accountt);
            }
        }

    }
}
