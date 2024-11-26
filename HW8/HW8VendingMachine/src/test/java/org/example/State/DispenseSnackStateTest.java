package org.example.State;

import org.example.Snack;
import org.example.SnacksDispenseHandler.SnackDispenseHandler;
import org.example.VendingMachine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class DispenseSnackStateTest {

    private VendingMachine vendingMachine;
    private SnackDispenseHandler snackDispenseHandler;
    private ArrayList<Snack> snacks;
    private DispenseSnackState dispenseSnackState;

    @BeforeEach
    public void setUp() {
        snacks = new ArrayList<>();
        snacks.add(new Snack("Coke", 2.0, 10));
        snacks.add(new Snack("Pepsi", 1.5, 5));
        snacks.add(new Snack("KitKat", 1.0, 8));
        vendingMachine = new VendingMachine(snackDispenseHandler, snacks);
        dispenseSnackState = new DispenseSnackState();
    }

    @Test
    public void testDispenseSnackEnoughQuantity() {
        Snack selectedSnack = snacks.get(0); // Coke
        vendingMachine.selectSnack(selectedSnack, 2);
        vendingMachine.insertMoney(5.0);
        vendingMachine.setStateOfVendingMachine(dispenseSnackState);
    }

    @Test
    public void testDispenseSnackNotEnoughQuantity() {
        Snack selectedSnack = snacks.get(1); // Pepsi
        vendingMachine.selectSnack(selectedSnack, 6); // More than available
        vendingMachine.insertMoney(10.0);
        vendingMachine.setStateOfVendingMachine(dispenseSnackState);

        dispenseSnackState.dispenseSnack(vendingMachine);

        assertEquals(5, selectedSnack.getQuantity()); // Quantity should remain unchanged
        assertNull(vendingMachine.getSelectedSnack());
        assertEquals(0.0, vendingMachine.getInsertedMoney());
    }

    @Test
    public void testDispenseSnackWithChange() {
        Snack selectedSnack = snacks.get(2); // KitKat
        vendingMachine.selectSnack(selectedSnack, 3);
        vendingMachine.insertMoney(5.0); // More than required
        vendingMachine.setStateOfVendingMachine(dispenseSnackState);
    }

    @Test
    public void testDispenseSnackExactAmount() {
        Snack selectedSnack = snacks.get(0); // Coke
        vendingMachine.selectSnack(selectedSnack, 1);
        vendingMachine.insertMoney(2.0); // Exact amount
        vendingMachine.setStateOfVendingMachine(dispenseSnackState);
    }
}
