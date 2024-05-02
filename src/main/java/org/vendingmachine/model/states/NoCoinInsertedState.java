package org.vendingmachine.model.states;

import org.vendingmachine.model.VendingMachine;

public class NoCoinInsertedState implements State {

    private final VendingMachine vendingMachine;

    public NoCoinInsertedState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertCoin(Double amount) {
        vendingMachine.setAmount(amount);
        vendingMachine.setCurrentVendingMachineState(vendingMachine.getCoinInsertedState());
    }

    @Override
    public void pressButton(int slotNumber) {
        throw new IllegalStateException("Cannot press a button without entering into Coin Inserted State");
    }

    @Override
    public void dispenseProduct(int productId) {
        throw new IllegalStateException("Cannot dispense product without entering in DispenseState");
    }
}
