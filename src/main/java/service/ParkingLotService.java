package service;

import model.Car;
import model.ParkingLot;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ParkingLotService {
    private static ParkingLot parkingLot;

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public void createParkingLot(int capacity) {
        parkingLot = new ParkingLot(capacity);
        System.out.println("Created a parking lot with " + capacity + " slots");
    }

    public void parkCar(Car car) {
        if(parkingLot == null) {
            System.out.println("Parking lot is not created, please create it first.");
            return;
        }
        if (parkingLot.isFull()) {
            System.out.println("Sorry, parking lot is full");
            return;
        }
        int slotNo = parkingLot.getAvailableSlotNumber();
        parkingLot.getAvailableSlots().remove(slotNo);

        parkingLot.getCarsParked().put(slotNo, car);
        System.out.println("Allocated slot number: " + slotNo);
    }

    public void unparkCar(int slotNo) {
        if(parkingLot == null) {
            System.out.println("Parking lot is not created, please create it first.");
            return;
        }
        if (parkingLot.getCarsParked().containsKey(slotNo)) {
            parkingLot.getCarsParked().remove(slotNo);
            parkingLot.getAvailableSlots().add(slotNo);
            System.out.println("Slot number " + slotNo + " is free");
            return;
        }
        System.out.println("Not found");
    }

    public void status() {
        if(parkingLot == null) {
            System.out.println("Parking lot is not created, please create it first.");
            return;
        }
        System.out.println("Slot No.\t\t\tRegistration No\t\t\t\t\tColour");
        for (Map.Entry<Integer, Car> entry : parkingLot.getCarsParked().entrySet()) {
            System.out.println(entry.getKey() + "\t\t\t\t\t" +
                    entry.getValue().getRegNo() + "\t\t\t\t\t" + entry.getValue().getColor());
        }
    }

    public String getRegNoForCarsWithColor(String color) {
        if(parkingLot == null) {
            System.out.println("Parking lot is not created, please create it first.");
            return null;
        }
        List<String> regNos = new ArrayList<>();
        for (Map.Entry<Integer, Car> entry : parkingLot.getCarsParked().entrySet()) {
            if (entry.getValue().getColor().equals(color)) {
                regNos.add(entry.getValue().getRegNo());
            }
        }
        System.out.println(String.join(",", regNos));
        return String.join(",", regNos);
    }

    public String getSlotNoForCarsWithColor(String color) {
        if(parkingLot == null) {
            System.out.println("Parking lot is not created, please create it first.");
            return null;
        }
        List<String> slotNos = new ArrayList<>();
        for (Map.Entry<Integer, Car> entry : parkingLot.getCarsParked().entrySet()) {
            if (entry.getValue().getColor().equals(color)) {
                slotNos.add(entry.getKey().toString());
            }
        }
        System.out.println(String.join(",", slotNos));
        return String.join(",", slotNos);
    }

    public int getSlotNoByCarRegNo(String regNo) {
        if(parkingLot == null) {
            System.out.println("Parking lot is not created, please create it first.");
            return -1;
        }
        for (Map.Entry<Integer, Car> entry : parkingLot.getCarsParked().entrySet()) {
            if (entry.getValue().getRegNo().equals(regNo)) {
                System.out.println(entry.getKey());
                return entry.getKey();
            }
        }
        System.out.println("Not found");
        return -1;
    }
}
