package com.aditya.models;

public class Car {
    private int driverAge;
    private String registrationNumber;

    public Car(String registrationNumber, int driverAge) {
        this.driverAge = driverAge;
        this.registrationNumber = registrationNumber;
    }

    public int getDriverAge() {
        return driverAge;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }
}
