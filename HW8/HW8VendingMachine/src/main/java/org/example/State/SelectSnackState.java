package org.example.State;

import org.example.StateOfVendingMachine;
import org.example.VendingMachine;

public class SelectSnackState implements StateOfVendingMachine {

    public void idle(VendingMachine vendingMachine){}

    public void selectSnack(VendingMachine vendingMachine){
        System.out.println("--------------------------------------");
        System.out.println("Vending machine in [SELECT SNACK STATE].");
        System.out.println("Selected snack - " );
        System.out.println("\t"+vendingMachine.getSelectedSnack());
        vendingMachine.setStateOfVendingMachine(new InsertMoneyState());
        System.out.println("Transitioning -> [INSERT MONEY STATE].");
    }

    public void insertMoney(VendingMachine vendingMachine){}
    public void dispenseSnack(VendingMachine vendingMachine){}

}