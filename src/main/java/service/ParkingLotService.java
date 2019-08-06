package service;

import model.Car;
import model.ParkingLot;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ParkingLotService {
    private static ParkingLot parkingLot;

    public void createParkingLot(int capacity) {
        parkingLot = new ParkingLot(capacity);
        System.out.println("Created a parking lot with " + capacity + " slots");
    }

    public void parkCar(Car car) {
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
        if (parkingLot.getCarsParked().containsKey(slotNo)) {
            parkingLot.getCarsParked().remove(slotNo);
            parkingLot.getAvailableSlots().add(slotNo);
            System.out.println("Slot number " + slotNo + " is free");
            return;
        }
        System.out.println("Not found");
    }

    public void status() {
        System.out.println("Slot No.\t\t\tRegistration No\t\t\t\t\tColour");
        for (Map.Entry<Integer, Car> entry : parkingLot.getCarsParked().entrySet()) {
            System.out.println(entry.getKey() + "\t\t\t\t\t" +
                    entry.getValue().getRegNo() + "\t\t\t\t\t" + entry.getValue().getColor());
        }
    }

    public void getRegNoForCarsWithColor(String color) {
        List<String> regNos = new ArrayList<>();
        for (Map.Entry<Integer, Car> entry : parkingLot.getCarsParked().entrySet()) {
            if (entry.getValue().getColor().equals(color)) {
                regNos.add(entry.getValue().getRegNo());
            }
        }
        System.out.println(String.join(",", regNos));
    }

    public void getSlotNoForCarsWithColor(String color) {
        List<String> slotNos = new ArrayList<>();
        for (Map.Entry<Integer, Car> entry : parkingLot.getCarsParked().entrySet()) {
            if (entry.getValue().getColor().equals(color)) {
                slotNos.add(entry.getKey().toString());
            }
        }
        System.out.println(String.join(",", slotNos));
    }

    public void getSlotNoByCarRegNo(String regNo) {
        for (Map.Entry<Integer, Car> entry : parkingLot.getCarsParked().entrySet()) {
            if (entry.getValue().getRegNo().equals(regNo)) {
                System.out.println(entry.getKey());
                return;
            }
        }
        System.out.println("Not found");
    }
}
