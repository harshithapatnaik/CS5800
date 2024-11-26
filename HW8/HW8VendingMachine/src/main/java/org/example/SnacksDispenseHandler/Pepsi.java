package org.example.SnacksDispenseHandler;

import org.example.Snack;

public class Pepsi extends SnackDispenseHandler {

    public Pepsi(SnackDispenseHandler next){
        super(next);
    }

    public void dispenseSnack(Snack snack,int quantity){
        if(snack.getName() == "Pepsi"){
            System.out.println("Dispensing Pepsi.");
            snack.setQuantity(snack.getQuantity() - quantity);
        }
        else{
            super.dispenseSnack(snack,quantity);
        }
    }
}
