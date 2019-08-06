package api;

import model.Car;

public interface ParkingLotApi {
    void createParkingLot(int capacity);

    void parkCar(Car car);

    void unparkCar(int slotNo);

    void getRegNoForCarsWithColor(String color);

    void getSlotNoForCarsWithColor(String color);

    void getSlotNoByCarRegNo(String regNo);

    void status();
}
