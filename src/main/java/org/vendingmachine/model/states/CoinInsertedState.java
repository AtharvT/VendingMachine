package org.vendingmachine.model.states;

import org.vendingmachine.model.Product;
import org.vendingmachine.model.VendingMachine;

public class CoinInsertedState implements State{

    private final VendingMachine vendingMachine;

    public CoinInsertedState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertCoin(Double amount) {
            vendingMachine.setAmount(vendingMachine.getAmount()+amount);
    }

    @Override
    public void pressButton(int slotNumber) {
        var inventory = vendingMachine.getInventory();
        Product product = inventory.getProduct(slotNumber);

        if(vendingMachine.getAmount() < product.getPrice()) {
            throw new IllegalStateException("The vending machine does not have sufficient balance. Please enter more coins");
        }

        if(inventory.getProduct(slotNumber) == null) {
            throw new IllegalStateException("The product is unavailable at the moment");
        }

        vendingMachine.setCurrentVendingMachineState(vendingMachine.getDispenseState());
    }

    @Override
    public void dispenseProduct(int productId) {
        throw new IllegalStateException("Cannot dispense product without entering in DispenseState");
    }
}
