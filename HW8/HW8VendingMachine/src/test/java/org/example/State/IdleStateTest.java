package org.example.State;

import org.example.StateOfVendingMachine;
import org.example.VendingMachine;
import org.example.SnacksDispenseHandler.SnackDispenseHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.example.Snack;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class IdleStateTest {

    private VendingMachine vendingMachine;
    private SnackDispenseHandler snackDispenseHandler;
    private ArrayList<Snack> snacks;
    private IdleState idleState;

    @BeforeEach
    public void setUp() {
        snackDispenseHandler = null;
        snacks = new ArrayList<>();
        snacks.add(new Snack("Coke", 2.0, 10));
        snacks.add(new Snack("Pepsi", 1.5, 5));
        snacks.add(new Snack("KitKat", 1.0, 8));
        vendingMachine = new VendingMachine(snackDispenseHandler, snacks);
        idleState = new IdleState();
    }

    @Test
    public void testIdleStateTransition() {
        vendingMachine.setStateOfVendingMachine(idleState);
        idleState.idle(vendingMachine);

        assertTrue(vendingMachine.getStateOfVendingMachine() instanceof SelectSnackState);
    }

    @Test
    public void testSelectSnackInIdleState() {
        vendingMachine.setStateOfVendingMachine(idleState);
        assertDoesNotThrow(() -> idleState.selectSnack(vendingMachine));
    }

    @Test
    public void testInsertMoneyInIdleState() {
        vendingMachine.setStateOfVendingMachine(idleState);
        assertDoesNotThrow(() -> idleState.insertMoney(vendingMachine));
    }

    @Test
    public void testDispenseSnackInIdleState() {
        vendingMachine.setStateOfVendingMachine(idleState);
        assertDoesNotThrow(() -> idleState.dispenseSnack(vendingMachine));
    }
}
