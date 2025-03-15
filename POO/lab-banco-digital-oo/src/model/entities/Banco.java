package model.entities;

import model.interfaces.IConta;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco{
    private List<Conta> contas = new ArrayList<>();

    public void adicionarConta(Conta conta){
        contas.add(conta);
    }

    public void removeConta(String nome){
        Iterator<Conta> iterator = contas.iterator();
        while (iterator.hasNext()) {
            Conta c = iterator.next();
            if (c.getCliente().getNome().equals(nome)) {
                iterator.remove();
            }else{
                throw new IllegalArgumentException("Conta não encontrada e não removida!");
            }
        }
    }

    public Conta buscarConta(int numeroConta) {
        for (Conta conta : contas) {
            if (conta.getNumero() == numeroConta) {
                return conta;
            }
        }
        return null;
    }

    public void imprimeContas(){
        System.out.println("======== Lista de Clientes ========");
        for(Conta c: contas){
            System.out.println("----------------------------------");
            System.out.println("Titular: " + c.getCliente().getNome());
            System.out.println("Agência: " + c.getAgencia());
            System.out.println("Numero: " + c.getNumero());
            System.out.println("----------------------------------");
        }
    }
}
