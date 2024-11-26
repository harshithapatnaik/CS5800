package org.example;

import org.example.State.IdleState;
import org.example.SnacksDispenseHandler.SnackDispenseHandler;

import java.util.ArrayList;

public class VendingMachine {

    private int quantity;
    private StateOfVendingMachine stateOfVendingMachine;
    private Snack selectedSnack;
    private double insertedMoney;
    private SnackDispenseHandler snackDispenseHandler;
    private ArrayList<Snack> snacks;

    public VendingMachine(SnackDispenseHandler snackDispenseHandler, ArrayList<Snack> snacks){
        this.stateOfVendingMachine = new IdleState();
        this.selectedSnack = null;
        this.insertedMoney = 0.0;
        this.snackDispenseHandler = snackDispenseHandler;
        this.snacks = snacks;
        this.quantity = 0;
    }

    public StateOfVendingMachine getStateOfVendingMachine(){
        return this.stateOfVendingMachine;
    }

    public void setStateOfVendingMachine(StateOfVendingMachine stateOfVendingMachine){
        this.stateOfVendingMachine = stateOfVendingMachine;
    }

    public Snack getSelectedSnack(){
        return this.selectedSnack;
    }

    public void setSelectedSnack(Snack selectedSnack){
        this.selectedSnack = selectedSnack;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    public int getQuantity(){
        return this.quantity;
    }

    public double getInsertedMoney(){
        return this.insertedMoney;
    }

    public void setInsertedMoney(double insertedMoney){
        this.insertedMoney = insertedMoney;
    }

    public SnackDispenseHandler getSnackDispenseHandler(){
        return this.snackDispenseHandler;
    }

    public void setSnackDispenseHandler(SnackDispenseHandler snackDispenseHandler){
        this.snackDispenseHandler = snackDispenseHandler;
    }

    public ArrayList<Snack> getSnacks(){
        return this.snacks;
    }

    public void setSnacks(ArrayList<Snack> snacks){
        this.snacks = snacks;
    }

    public void idle(){
        getStateOfVendingMachine().idle(this);
    }

    public void selectSnack(Snack snack){
        this.setSelectedSnack(snack);
        this.setQuantity(1);
        getStateOfVendingMachine().selectSnack(this);
    }

    public void selectSnack(Snack snack, int quantity){
        this.setSelectedSnack(snack);
        this.setQuantity(quantity);
        getStateOfVendingMachine().selectSnack(this);
    }

    public void insertMoney(double money){
        this.setInsertedMoney(money);
        getStateOfVendingMachine().insertMoney(this);
    }

    public void dispenseSnack(){
        getStateOfVendingMachine().dispenseSnack(this);
    }

    public String toString(){
        System.out.println("--------------------------------------");
        String output = "Vending machine status -";
        output += "\n   State: [IDLE]";
        output += "\n   Available snacks are:- ";
        for(Snack snack: getSnacks()){
            output += "\n   \t \t" + snack.toString();
        }
        return output;
    }
}