package org.example.State;

import org.example.StateOfVendingMachine;
import org.example.VendingMachine;
import org.example.SnacksDispenseHandler.SnackDispenseHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.example.Snack;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class InsertMoneyStateTest {

    private VendingMachine vendingMachine;
    private SnackDispenseHandler snackDispenseHandler;
    private ArrayList<Snack> snacks;
    private InsertMoneyState insertMoneyState;

    @BeforeEach
    public void setUp() {
        snackDispenseHandler = null;
        snacks = new ArrayList<>();
        snacks.add(new Snack("Coke", 2.0, 10));
        snacks.add(new Snack("Pepsi", 1.5, 5));
        snacks.add(new Snack("KitKat", 1.0, 8));
        vendingMachine = new VendingMachine(snackDispenseHandler, snacks);
        insertMoneyState = new InsertMoneyState();
    }

    @Test
    public void testInsertMoneyEnoughAmount() {
        vendingMachine.selectSnack(snacks.get(0)); // Coke
        vendingMachine.setInsertedMoney(3.0); // More than enough
        vendingMachine.setStateOfVendingMachine(insertMoneyState);

        insertMoneyState.insertMoney(vendingMachine);

        assertTrue(vendingMachine.getStateOfVendingMachine() instanceof DispenseSnackState);
        assertEquals(3.0, vendingMachine.getInsertedMoney());
    }

    @Test
    public void testInsertMoneyNotEnoughAmount() {
        vendingMachine.selectSnack(snacks.get(1)); // Pepsi
        vendingMachine.setInsertedMoney(1.0); // Less than required
        vendingMachine.setStateOfVendingMachine(insertMoneyState);

        insertMoneyState.insertMoney(vendingMachine);

        assertTrue(vendingMachine.getStateOfVendingMachine() instanceof IdleState);
        assertEquals(0.0, vendingMachine.getInsertedMoney());
        assertNull(vendingMachine.getSelectedSnack());
    }

    @Test
    public void testIdleInInsertMoneyState() {
        vendingMachine.setStateOfVendingMachine(insertMoneyState);
        assertDoesNotThrow(() -> insertMoneyState.idle(vendingMachine));
    }

    @Test
    public void testSelectSnackInInsertMoneyState() {
        vendingMachine.setStateOfVendingMachine(insertMoneyState);
        assertDoesNotThrow(() -> insertMoneyState.selectSnack(vendingMachine));
    }

    @Test
    public void testDispenseSnackInInsertMoneyState() {
        vendingMachine.setStateOfVendingMachine(insertMoneyState);
        assertDoesNotThrow(() -> insertMoneyState.dispenseSnack(vendingMachine));
    }
}
