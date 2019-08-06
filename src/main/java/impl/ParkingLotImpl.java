package impl;

import api.ParkingLotApi;
import model.Car;
import service.ParkingLotService;

public class ParkingLotImpl implements ParkingLotApi {
    private final ParkingLotService parkingLotService;

    public ParkingLotImpl(ParkingLotService parkingLotService) {
        this.parkingLotService = parkingLotService;
    }

    @Override
    public void createParkingLot(int capacity) {
        parkingLotService.createParkingLot(capacity);
    }

    @Override
    public void parkCar(Car car) {
        parkingLotService.parkCar(car);
    }

    @Override
    public void unparkCar(int slotNo) {
        parkingLotService.unparkCar(slotNo);
    }

    @Override
    public void getRegNoForCarsWithColor(String color) {
        parkingLotService.getRegNoForCarsWithColor(color);
    }

    @Override
    public void getSlotNoForCarsWithColor(String color) {
        parkingLotService.getSlotNoForCarsWithColor(color);
    }

    @Override
    public void getSlotNoByCarRegNo(String regNo) {
        parkingLotService.getSlotNoByCarRegNo(regNo);
    }

    @Override
    public void status() {
        parkingLotService.status();
    }
}
