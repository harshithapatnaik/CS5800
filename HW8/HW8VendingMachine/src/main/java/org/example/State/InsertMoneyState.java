package org.example.State;

import org.example.StateOfVendingMachine;
import org.example.VendingMachine;

public class InsertMoneyState implements StateOfVendingMachine {

    public void idle(VendingMachine vendingMachine){}
    public void selectSnack(VendingMachine vendingMachine){}

    public void insertMoney(VendingMachine vendingMachine){
        System.out.println("--------------------------------------");
        System.out.println("Vending machine in [INSERT MONEY STATE].");
        double insertedMoney = vendingMachine.getInsertedMoney();
        double price = vendingMachine.getSelectedSnack().getPrice();
        System.out.println("Inserted money - $" + insertedMoney);
        if(insertedMoney >= price){
            vendingMachine.setStateOfVendingMachine(new DispenseSnackState());
            System.out.println("Inserted enough money, transitioning -> [DISPENSE SNACK STATE].");
        }
        else{
            vendingMachine.setStateOfVendingMachine(new IdleState());
            System.out.println("Not enough money inserted, transitioning -> [IDLE STATE].");
            System.out.println("Returning $" + insertedMoney);
            vendingMachine.setInsertedMoney(0.0);
            vendingMachine.setSelectedSnack(null);
        }
    }

    public void dispenseSnack(VendingMachine vendingMachine){}

}