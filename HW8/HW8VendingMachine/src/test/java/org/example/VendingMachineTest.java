package org.example;

import org.example.State.IdleState;
import org.example.SnacksDispenseHandler.SnackDispenseHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class VendingMachineTest {

    private VendingMachine vendingMachine;
    private SnackDispenseHandler snackDispenseHandler;
    private ArrayList<Snack> snacks;

    @BeforeEach
    public void setUp() {
        snackDispenseHandler = null;
        snacks = new ArrayList<>();
        snacks.add(new Snack("Coke", 2.0, 10));
        snacks.add(new Snack("Pepsi", 1.5, 5));
        snacks.add(new Snack("KitKat", 1.0, 8));
        vendingMachine = new VendingMachine(snackDispenseHandler, snacks);
    }

    @Test
    public void testVendingMachineInitialization() {
        assertNotNull(vendingMachine.getStateOfVendingMachine());
        assertTrue(vendingMachine.getStateOfVendingMachine() instanceof IdleState);
        assertNull(vendingMachine.getSelectedSnack());
        assertEquals(0.0, vendingMachine.getInsertedMoney());
        assertEquals(snacks, vendingMachine.getSnacks());
        assertEquals(0, vendingMachine.getQuantity());
    }

    @Test
    public void testSelectSnack() {
        Snack selectedSnack = snacks.get(0); // Coke
        vendingMachine.selectSnack(selectedSnack);

        assertEquals(selectedSnack, vendingMachine.getSelectedSnack());
        assertEquals(1, vendingMachine.getQuantity());
    }

    @Test
    public void testSelectSnackWithQuantity() {
        Snack selectedSnack = snacks.get(1); // Pepsi
        vendingMachine.selectSnack(selectedSnack, 3);

        assertEquals(selectedSnack, vendingMachine.getSelectedSnack());
        assertEquals(3, vendingMachine.getQuantity());
    }

    @Test
    public void testInsertMoney() {
        Snack selectedSnack = snacks.get(0); // Coke
        vendingMachine.selectSnack(selectedSnack);
        vendingMachine.insertMoney(2.0);

        assertEquals(2.0, vendingMachine.getInsertedMoney());
    }

    @Test
    public void testToStringOutput() {
        String output = vendingMachine.toString();
        assertTrue(output.contains("Vending machine status"));
        assertTrue(output.contains("State: [IDLE]"));
        assertTrue(output.contains("Available snacks are"));
    }
}
