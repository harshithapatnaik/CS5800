package org.example;

public interface StateOfVendingMachine {
    void idle(VendingMachine vendingMachine);
    void selectSnack(VendingMachine vendingMachine);
    void insertMoney(VendingMachine vendingMachine);
    void dispenseSnack(VendingMachine vendingMachine);
}
