package org.example;

import org.example.SnacksDispenseHandler.*;

import java.util.*;

public class Main {

    public static void main(String[] args){

        // Create driver with 6 different snacks -> Coke, Pepsi, Cheetos, Doritos, KitKat, and Snickers.
        Snack kitKat = new Snack("KitKat", 2.00, 4);
        Snack snickers = new Snack("Snickers", 1.50, 3);
        Snack cheetos = new Snack("Cheetos", 1.00, 4);
        Snack doritos = new Snack("Doritos", 2.50, 5);
        Snack coke = new Snack("Coke", 3.00, 5);
        Snack pepsi = new Snack("Pepsi", 3.50, 5);

        ArrayList<Snack> snacks = new ArrayList<Snack>(Arrays.asList(coke, pepsi,
                cheetos, doritos,
                kitKat, snickers));
        SnackDispenseHandler snackDispenseHandler = new Coke(
                new Pepsi(
                        new Cheetos(
                                new Doritos(
                                        new KitKat(
                                                new Snickers(null))))));
        VendingMachine vendingMachine = new VendingMachine(snackDispenseHandler, snacks);

        System.out.println("#############################################");
        System.out.println("# CASE 1:- With NOT enough money:");

        vendingMachine.idle();
        vendingMachine.selectSnack(doritos);
        vendingMachine.insertMoney(2.00);
        vendingMachine.dispenseSnack();
        System.out.println(vendingMachine);

        System.out.println("#############################################");
        System.out.println("# CASE 2:- With enough money and quantity:");

        vendingMachine.idle();
        vendingMachine.selectSnack(pepsi);
        vendingMachine.insertMoney(5.00);
        vendingMachine.dispenseSnack();
        System.out.println(vendingMachine);

        System.out.println("#############################################");
        System.out.println("# CASE 3:- Quantity hits 0 with snickers:");

        vendingMachine.idle();
        vendingMachine.selectSnack(snickers,3);
        vendingMachine.insertMoney(5.00);
        vendingMachine.dispenseSnack();
        System.out.println(vendingMachine);

        System.out.println("#############################################");
        System.out.println("# CASE 4:- With no more quantity:");

        vendingMachine.idle();
        vendingMachine.selectSnack(snickers);
        vendingMachine.insertMoney(4.00);
        vendingMachine.dispenseSnack();
        System.out.println(vendingMachine);

        System.out.println("#############################################");
    }

}