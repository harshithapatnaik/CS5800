package org.example.State;

import org.example.VendingMachine;

public class DispenseSnackState extends SelectSnackState {

    public void idle(VendingMachine vendingMachine){}
    public void selectSnack(VendingMachine vendingMachine){}
    public void insertMoney(VendingMachine vendingMachine){}

    public void dispenseSnack(VendingMachine vendingMachine){
        System.out.println("--------------------------------------------");
        System.out.println("Vending machine in [DISPENSE SNACK STATE]");
        int quantity = vendingMachine.getSelectedSnack().getQuantity();
        double insertedMoney = vendingMachine.getInsertedMoney();
        int requiredQuantity = vendingMachine.getQuantity();
        double price = vendingMachine.getSelectedSnack().getPrice() * requiredQuantity;
        if( quantity >= requiredQuantity){
            System.out.println("Enough quantity, dispensing snack.");
            vendingMachine.getSnackDispenseHandler().dispenseSnack(vendingMachine.getSelectedSnack(), requiredQuantity);
            if(insertedMoney > price){
                System.out.println("Transitioning to idle state.");
                System.out.println("Returning change $" + (insertedMoney - price));
            }
        }
        else{
            System.out.println("Not enough quantity, requested " + requiredQuantity +", Current stock "+ quantity+".  Transitioning to idle state.");
            System.out.println("Returning $" + insertedMoney);
        }
        vendingMachine.setStateOfVendingMachine(new IdleState());
        vendingMachine.setInsertedMoney(0.0);
        vendingMachine.setQuantity(0);
        vendingMachine.setSelectedSnack(null);
    }

}
