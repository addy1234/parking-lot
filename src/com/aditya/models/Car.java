package com.aditya.models;

public class Car {
    private int driverAge;
    private String registrationNumber;

    public Car(int driverAge, String registrationNumber) {
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
