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


}
