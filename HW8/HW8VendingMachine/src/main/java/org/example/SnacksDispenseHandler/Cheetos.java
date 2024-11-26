package org.example.SnacksDispenseHandler;

import org.example.Snack;

public class Cheetos extends SnackDispenseHandler {

    public Cheetos(SnackDispenseHandler next){
        super(next);
    }

    public void dispenseSnack(Snack snack,int quantity){
        if(snack.getName() == "Cheetos"){
            System.out.println("Dispensing Cheetos.");
            snack.setQuantity(snack.getQuantity() - quantity);
        }
        else{
            super.dispenseSnack(snack, quantity);
        }
    }
}