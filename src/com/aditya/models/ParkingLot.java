package com.aditya.models;

import com.aditya.Exception.NegativeCapacityException;
import com.aditya.Exception.NoCarSlotLeftException;

import java.util.ArrayList;
import java.util.HashMap;

public class ParkingLot {
    int capacity;
    public Slot[] parkingSlots;
    HashMap<String, Integer> carMapping;
    HashMap<Integer, HashMap<Slot, Boolean>> ageMapping;

    public ParkingLot(int capacity) {
        if(capacity <= 0) {
            throw new NegativeCapacityException();
        }
        this.capacity = capacity;
        parkingSlots = new Slot[capacity + 1];
        carMapping = new HashMap<>();
        ageMapping = new HashMap<>();
        initParkingSlots();
    }

    public void initParkingSlots() {
        for(int i=1;i<=capacity;i++){
            parkingSlots[i] = new Slot(i);
            parkingSlots[i].setIsParked(false);
            parkingSlots[i].setParkedCar(null);
        }
    }

    public int getCapacity() {
        return capacity;
    }

    public void assignSlotToCar(Car car) throws NoCarSlotLeftException {
        Slot slot = getCarSlot();
        slot.setParkedCar(car);
        slot.setIsParked(true);

        carMapping.put(car.getRegistrationNumber(), slot.getSlotNumber());
        ageMapping.get(car.getDriverAge()).put(slot, true);
    }

    public Slot getCarSlot() {
        for(int i=1;i<=capacity;i++){
            if(parkingSlots[i].isFree() == true){
                return parkingSlots[i];
            }
        }
    }

    public void unassignSlot(int slotNumber) {
        Slot slot = parkingSlots[slotNumber];
        slot.setParkedCar(null);
        slot.setIsParked(false);

        carMapping.remove(slot.getParkedCar().getRegistrationNumber());
        ageMapping.get(slot.getParkedCar().getDriverAge()).remove(slot);
    }

    public 


}
