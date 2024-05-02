package org.vendingmachine.model;

import org.vendingmachine.exceptions.NoAvailableSlotsException;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Inventory {

    private final Map<Integer, Product> slotToProduct;
    private final Map<Integer, Integer> productIdToProductCount;
    Queue<Integer> availableSlots;

    public Inventory(int totalSlots) {
        this.slotToProduct = new HashMap<>();
        this.productIdToProductCount = new HashMap<>();
        this.availableSlots = new LinkedList<>();

        for(int i = 0; i < totalSlots; i++) {
            availableSlots.add(i);
        }
    }

    public void addProduct(Product product) throws NoAvailableSlotsException {
        int productId = product.getProductId();

        int productCount = productIdToProductCount.getOrDefault(productId, 0);

        if(productCount == 0) {
            if(availableSlots.isEmpty()) {
                throw new NoAvailableSlotsException("There are no available slots");
            }

            slotToProduct.put(availableSlots.poll(), product);
        }
        productIdToProductCount.put(productId, productCount + 1);
    }

    public void deductProductCount(int slotNumber) {
        int productId = slotToProduct.get(slotNumber).getProductId();
        int updatedProductCount = productIdToProductCount.get(productId)-1;

        if(updatedProductCount == 0) {
            slotToProduct.remove(slotNumber);
            productIdToProductCount.remove(productId);
            availableSlots.add(slotNumber);
        }

        else {
            productIdToProductCount.put(productId, updatedProductCount);
        }
    }

    public boolean checkIfProductAvailable(int productId) {
        return productIdToProductCount.get(productId) > 0;
    }

    public Product getProduct(int slotNumber) {
        return slotToProduct.get(slotNumber);
    }
}
