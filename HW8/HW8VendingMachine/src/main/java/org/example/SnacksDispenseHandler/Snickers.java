package org.example.SnacksDispenseHandler;

import org.example.Snack;

public class Snickers extends SnackDispenseHandler {

    public Snickers(SnackDispenseHandler next){
        super(next);
    }

    public void dispenseSnack(Snack snack,int quantity){
        if(snack.getName() == "Snickers"){
            System.out.println("Dispensing Snickers.");
            snack.setQuantity(snack.getQuantity() - quantity);
        }
        else{
            super.dispenseSnack(snack, quantity);
        }
    }
}