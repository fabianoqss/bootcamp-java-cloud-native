package model.entities;

public class ContaPoupanca extends Conta{
    public ContaPoupanca(Integer agencia, Integer numero, Double saldo, Cliente cliente) {
        super(agencia, numero, saldo, cliente);
    }

    @Override
    public Double getSaldo() {
        return saldo;
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato Conta Poupança ===");
        super.imprimirExtrato();
    }
}
