package model.entities;

public class ContaCorrente extends Conta{

    public ContaCorrente(Integer agencia, Integer numero, Double saldo, Cliente cliente) {
        super(agencia, numero, saldo, cliente);
    }

    @Override
    public Double getSaldo() {
        return saldo;
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato Conta Corrente ===");
        super.imprimirExtrato();
    }
}
