package org.vendingmachine.model.states;

import org.vendingmachine.model.VendingMachine;

public class DispenseState implements State{

    private final VendingMachine vendingMachine;

    public DispenseState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertCoin(Double amount) {
        throw new IllegalStateException("Cannot insert coin while the product is in Dispense State");
    }

    @Override
    public void pressButton(int slotNumber) {
        throw new IllegalStateException("Cannot press a button while the product is in Dispense State");
    }

    @Override
    public void dispenseProduct(int slotNumber) {
        var inventory = vendingMachine.getInventory();
        var product = inventory.getProduct(slotNumber);

        double change = vendingMachine.getAmount()-product.getPrice();
        inventory.deductProductCount(slotNumber);
        vendingMachine.setAmount(0);
        vendingMachine.setCurrentVendingMachineState(vendingMachine.getNoCoinInsertedState());

        System.out.println("Product with id " + product.getProductId() + " dispensed successfully");
    }
}
