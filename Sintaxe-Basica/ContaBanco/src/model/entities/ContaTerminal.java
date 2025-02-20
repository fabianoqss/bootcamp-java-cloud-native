package model.entities;

public class ContaTerminal {
    private Integer number;
    private String agency;
    private String clientName;
    private Double balance;

    public ContaTerminal(Integer number, String agency, String clientName) {
        this.number = number;
        this.agency = agency;
        this.clientName = clientName;
    }

    public ContaTerminal(Integer number, String agency, String clientName, Double balance) {
        this.number = number;
        this.agency = agency;
        this.clientName = clientName;
        this.balance = balance;
    }

    public Integer getNumber() {
        return number;
    }


    public String getAgency() {
        return agency;
    }


    public String getClientName() {
        return clientName;
    }


    public Double getBalance() {
        return balance;
    }

    public void withdraw(Double balance){
        this.balance -= balance;
    }

    public void deposit(Double balance){
        this.balance += balance;
    }

    @Override
    public String toString(){
        return "Olá " + getClientName() + " obrigado por criar uma conta em nosso banco, sua agência é "
                + getAgency() + ", conta "
                + getNumber() + " e seu saldo " +
                getBalance() + " já está disponível para Saque";
    }

}
