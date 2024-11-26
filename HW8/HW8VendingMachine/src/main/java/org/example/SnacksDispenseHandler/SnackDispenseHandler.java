package org.example.SnacksDispenseHandler;

import org.example.Snack;

public abstract class SnackDispenseHandler {
    private SnackDispenseHandler next;

    public SnackDispenseHandler(SnackDispenseHandler next){
        this.next = next;
    }

    public void dispenseSnack(Snack snack, int quantity){
        if(next != null){
            next.dispenseSnack(snack, quantity);
        }
    }
}
