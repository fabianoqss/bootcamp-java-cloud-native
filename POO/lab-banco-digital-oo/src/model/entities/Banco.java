package model.entities;

import model.interfaces.IConta;

import java.util.ArrayList;
import java.util.List;

public class Banco{
    private String nome;
    private List<Conta> contas = new ArrayList<>();

    public String getNome() {
        return nome;
    }

    public List<Conta> getContas() {
        return contas;
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
