package model.entities;

public class Conta {

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
