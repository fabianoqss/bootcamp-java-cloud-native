package model.entities;

import model.exception.SaldoInsuficienteException;
import model.interfaces.IConta;

public abstract class Conta implements IConta {

    private Integer agencia;
    private Integer numero;
    protected Double saldo;
    private Cliente cliente;

    public Conta(Integer agencia, Integer numero, Double saldo, Cliente cliente) {
        this.agencia = agencia;
        this.numero = numero;
        this.saldo = saldo;
        this.cliente = cliente;
    }

    @Override
    public void sacar(double valor){
        if(valor > getSaldo()){
            throw new SaldoInsuficienteException("valor maior do que o saldo da conta!");
        }
        saldo -= valor;
    }

    @Override
    public void depositar(double valor){
        this.saldo += valor;
    }

    @Override
    public void transferir(double valor, IConta contaDestino){
        if (this.getSaldo() < valor) {
            throw new SaldoInsuficienteException("Saldo insuficiente para transferência!");
        }
        this.sacar(valor);
        contaDestino.depositar(valor);
    }


    public Integer getAgencia() {
        return agencia;
    }


    public Integer getNumero() {
        return numero;
    }

    @Override
    public Double getSaldo() {
        return saldo;
    }


    public Cliente getCliente() {
        return cliente;
    }


    public void imprimirInfosComuns(){
        StringBuilder sb = new StringBuilder();
        sb.append("Titular: ").append(cliente.getNome()).append("\n");
        sb.append("Agencia: ").append(getAgencia()).append("\n");
        sb.append("Numero: ").append(getNumero()).append("\n");
        sb.append(String.format("Saldo: %.2f\n", getSaldo()));
        System.out.println(sb.toString());
    }

}
