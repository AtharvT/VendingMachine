package org.vendingmachine.model.states;

public interface State {
    void insertCoin(Double amount);
    void pressButton(int slotNumber);
    void dispenseProduct(int slotNumber);

}
