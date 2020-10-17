package com.aditya;

import com.aditya.Exception.WrongCommandException;
import com.aditya.models.ParkingLot;
import com.aditya.services.ParkingService;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    private static ParkingLot parkingLot;

    public static void executeCommand(String command) throws WrongCommandException {
        System.out.println(command);
        String splitCommand[] = command.split(" ");

        if(splitCommand[0].equals("Create_parking_lot")) {

            parkingLot = new ParkingLot(Integer.parseInt(splitCommand[1]));
            System.out.println("Created Parking of " + splitCommand[1] + " Slots");

        }else if(splitCommand[0].equals("Park")) {


        }else if(splitCommand[0].equals("Leave")) {

        }else if(splitCommand[0].equals("Vehicle_registration_number_for_driver_of_age")) {

        }else if(splitCommand[0].equals("Slot_number_for_car_with_number")) {

        }else if(splitCommand[0].equals("Slot_numbers_for_driver_of_age")) {

        }else{
            throw new WrongCommandException();
        }
    }

    public static void main(String[] args) throws IOException, WrongCommandException {
        //System.out.println("Hello World");
        ParkingService parkingService = new ParkingService();

        // read input
        FileReader inputFile = new FileReader("./input2.txt");
        BufferedReader reader = new BufferedReader(inputFile);

        String command = reader.readLine();
        while(reader.readLine() != null) {
            command = reader.readLine();
            executeCommand(command);
        }
    }
}
