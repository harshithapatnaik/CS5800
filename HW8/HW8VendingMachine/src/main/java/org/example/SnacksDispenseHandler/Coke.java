package org.example.SnacksDispenseHandler;

import org.example.Snack;

public class Coke extends SnackDispenseHandler {

    public Coke(SnackDispenseHandler next){
        super(next);
    }

    public void dispenseSnack(Snack snack,int quantity){
        if(snack.getName() == "Coke"){
            System.out.println("Dispensing Coke.");
            snack.setQuantity(snack.getQuantity() - quantity);
        }
        else{
            super.dispenseSnack(snack, quantity);
        }
    }
}