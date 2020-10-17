package com.aditya.models;

import com.aditya.Exception.NegativeCapacityException;
import com.aditya.Exception.NoCarSlotLeftException;

public class ParkingLot {
    int capacity;
    int

    public ParkingLot(int capacity) {
        if(capacity <= 0) {
            throw new NegativeCapacityException();
        }
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void assignSlotToCar() throws NoCarSlotLeftException {
        int slot = getCarSlot();
        if(slot == -1){
            throw new NoCarSlotLeftException();
        }
    }

    public int getCarSlot() {

    }

}
