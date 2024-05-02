package org.vendingmachine.exceptions;

public class NoAvailableSlotsException extends Exception {
    public NoAvailableSlotsException(String message) {
        super(message);
    }
}
