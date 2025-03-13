package model.entities;

import model.exception.SaldoInsuficienteException;
import model.interfaces.IConta;

public abstract class Conta implements IConta {

    private Integer agencia;
    private Integer numero;
    private Double saldo;
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
    public void transferir(double valor, IConta contaOrigem, IConta contaDestino){

    }


    public Integer getAgencia() {
        return agencia;
    }


    public Integer getNumero() {
        return numero;
    }


    public Double getSaldo() {
        return saldo;
    }


    public Cliente getCliente() {
        return cliente;
    }

    @Override
    public String toString(){
        return "";
    }

}
