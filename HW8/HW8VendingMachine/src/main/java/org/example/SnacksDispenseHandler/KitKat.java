package org.example.SnacksDispenseHandler;

import org.example.Snack;

public class KitKat extends SnackDispenseHandler {

    public KitKat(SnackDispenseHandler next){
        super(next);
    }

    public void dispenseSnack(Snack snack,int quantity){
        if(snack.getName() == "KitKat"){
            System.out.println("Dispensing KitKat.");
            snack.setQuantity(snack.getQuantity() - quantity);
        }
        else{
            super.dispenseSnack(snack, quantity);
        }
    }
}
