package org.vendingmachine.model;

import org.vendingmachine.exceptions.NoAvailableSlotsException;
import org.vendingmachine.model.states.CoinInsertedState;
import org.vendingmachine.model.states.DispenseState;
import org.vendingmachine.model.states.NoCoinInsertedState;
import org.vendingmachine.model.states.State;

public class VendingMachine {
    private double amount;
    private CoinInsertedState coinInsertedState;
    private DispenseState dispenseState;
    private NoCoinInsertedState noCoinInsertedState;
    private State currentVendingMachineState;
    private final Inventory inventory;

    public VendingMachine(double amount, Inventory inventory) {
        this.amount = 0.0;
        this.coinInsertedState = new CoinInsertedState(this);
        this.dispenseState = new DispenseState(this);
        this.noCoinInsertedState = new NoCoinInsertedState(this);
        this.currentVendingMachineState = noCoinInsertedState;
        this.inventory = inventory;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setCurrentVendingMachineState(State vendingMachineState) {
        this.currentVendingMachineState = vendingMachineState;
    }

    public double getAmount() {
        return amount;
    }

    public CoinInsertedState getCoinInsertedState() {
        return coinInsertedState;
    }

    public void setCoinInsertedState(CoinInsertedState coinInsertedState) {
        this.coinInsertedState = coinInsertedState;
    }

    public DispenseState getDispenseState() {
        return dispenseState;
    }

    public void setDispenseState(DispenseState dispenseState) {
        this.dispenseState = dispenseState;
    }

    public NoCoinInsertedState getNoCoinInsertedState() {
        return noCoinInsertedState;
    }

    public void setNoCoinInsertedState(NoCoinInsertedState noCoinInsertedState) {
        this.noCoinInsertedState = noCoinInsertedState;
    }

    public State getCurrentVendingMachineState() {
        return currentVendingMachineState;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void insertCoin(Double amount) {
        this.currentVendingMachineState.insertCoin(amount);
        System.out.println("Amount " + amount +  " has been inserted");
    }

    public void pressButton(int slotNumber) {
        this.currentVendingMachineState.pressButton(slotNumber);
        this.currentVendingMachineState.dispenseProduct(slotNumber);
    }

    public void addProduct(Product product) {
        try {
            this.getInventory().addProduct(product);
        } catch (NoAvailableSlotsException e) {
            throw new RuntimeException(e);
        }
    }

}
