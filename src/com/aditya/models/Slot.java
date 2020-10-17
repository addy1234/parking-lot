package com.aditya.models;

public class Slot {
    private int slotNumber;
    private Car parkedCar;
    public boolean isParked;

    public Slot(int slotNumber) {
        this.slotNumber = slotNumber;
    }

    public boolean isFree() {
        return !isParked;
    }

    public int getSlotNumber() {
        return slotNumber;
    }

    public Car getParkedCar() {
        return parkedCar;
    }

    public void assignSlot(Car car) {
        this.parkedCar = car;
    }

    public void unassignSlot(Car car) {
        this.parkedCar = null;
    }

    public void setParkedCar(Car car) {
        this.parkedCar = car;
    }

    public void setIsParked(boolean flag) {
        this.isParked = flag;
    }

}
