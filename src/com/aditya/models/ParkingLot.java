package com.aditya.models;

import com.aditya.Exception.NegativeCapacityException;
import com.aditya.Exception.NoCarSlotLeftException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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

    public void assignSlot(Car car) throws NoCarSlotLeftException {
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

    public ArrayList<String> getAllCarsFromAge(int age) {
        ArrayList<String> registrationList = new ArrayList();
        for(Map.Entry<Slot, Boolean> slot : ageMapping.get(age).entrySet()) {
            registrationList.add(slot.getKey().getParkedCar().getRegistrationNumber());
        }
        return registrationList;
    }

    public Integer getSlotNumber(String registrationNumber) {
        return carMapping.get(registrationNumber);
    }

    public ArrayList<Integer> getAllSlotsFromAge(int age) {
        ArrayList<Integer> slotList = new ArrayList();
        for(Map.Entry<Slot, Boolean> slot : ageMapping.get(age).entrySet()) {
            slotList.add(slot.getKey().getSlotNumber());
        }
        return slotList;
    }
}
