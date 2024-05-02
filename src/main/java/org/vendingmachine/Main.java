package org.vendingmachine;

import org.vendingmachine.exceptions.NoAvailableSlotsException;
import org.vendingmachine.model.Inventory;
import org.vendingmachine.model.Product;
import org.vendingmachine.model.VendingMachine;

public class Main {
    public static void main(String[] args) throws NoAvailableSlotsException {
        Inventory inventory = new Inventory(50);
        VendingMachine vendingMachine = new VendingMachine(0.0, inventory);

        System.out.println("Addding Product 1 : Item1");
        for(int i = 0; i < 3; i++) {
            inventory.addProduct(new Product(1, "Item1", 3.0));
        }

        System.out.println("Adding Product 2 : Item2");
        for(int i = 0; i < 3; i++) {
            inventory.addProduct(new Product(2,"Item2", 5.0));
        }


        vendingMachine.insertCoin(5.0);
        vendingMachine.insertCoin(2.0);
        vendingMachine.pressButton(1);



    }
}