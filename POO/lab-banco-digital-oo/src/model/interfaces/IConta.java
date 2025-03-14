package model.interfaces;

public interface IConta {

    void sacar(double valor);

    void depositar(double valor);

    void transferir(double valor, IConta contaOrigem, IConta contaDestino);

    void imprimirExtrato();

    Double getSaldo();
}
