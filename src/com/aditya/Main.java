package com.aditya;

import com.aditya.Exception.NoCarSlotLeftException;
import com.aditya.Exception.WrongCommandException;
import com.aditya.models.Car;
import com.aditya.models.ParkingLot;
import com.aditya.services.ParkingService;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    private static ParkingLot parkingLot;

    public static void executeCommand(String command) throws WrongCommandException, NoCarSlotLeftException {
        System.out.println(command);
        String splitCommand[] = command.split(" ");

        if(splitCommand[0].equals("Create_parking_lot")) {

            parkingLot = new ParkingLot(Integer.parseInt(splitCommand[1]));
            System.out.println("Created Parking of " + splitCommand[1] + " Slots");

        }else if(splitCommand[0].equals("Park")) {

            Car car = new Car(splitCommand[1], Integer.parseInt(splitCommand[3]));
            parkingLot.assignSlot(car);

        }else if(splitCommand[0].equals("Leave")) {

            parkingLot.unassignSlot(Integer.parseInt(splitCommand[1]));

        }else if(splitCommand[0].equals("Vehicle_registration_number_for_driver_of_age")) {

            ArrayList<String> regList = parkingLot.getAllCarsFromAge(Integer.parseInt(splitCommand[1]));
            System.out.print(command + " is : ");
            for(String i : regList){
                System.out.print(i + ", ");
            }
            System.out.println();

        }else if(splitCommand[0].equals("Slot_number_for_car_with_number")) {

            int slotNumber = parkingLot.getSlotNumber(splitCommand[1]);
            System.out.println(command + " is : " + slotNumber);

        }else if(splitCommand[0].equals("Slot_numbers_for_driver_of_age")) {

            ArrayList<Integer> regList = parkingLot.getAllSlotsFromAge(Integer.parseInt(splitCommand[1]));
            System.out.print(command + " is : ");
            for(Integer i : regList){
                System.out.print(i + ", ");
            }
            System.out.println();

        }else{
            throw new WrongCommandException();
        }
    }

    public static void main(String[] args) throws IOException, WrongCommandException, NoCarSlotLeftException {
        //System.out.println("Hello World");
        ParkingService parkingService = new ParkingService();

        // read input
        // System.out.println("Working Directory = " + System.getProperty("user.dir"));
        FileReader inputFile = new FileReader("../input.txt");
        BufferedReader reader = new BufferedReader(inputFile);

        String command;
        while((command = reader.readLine()) != null) {
            executeCommand(command);
        }
    }
}
