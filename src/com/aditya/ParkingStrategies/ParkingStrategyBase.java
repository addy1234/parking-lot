package com.aditya.ParkingStrategies;

/**
 The way in which we want our system to give slots to the vehicles. Eg- It could be nearer to entry gate, exit gate etc.
 */

public interface ParkingStrategyBase {

    public void addSlot(int slot);

    public int removeSlot(int slot);

    public int getNextSlot();

    public void showAllOccupiedSlots();

}
