package factory;

import service.ParkingLotService;

public class ParkingLotServiceFactory {
    ParkingLotServiceFactory() {
    }

    public static ParkingLotService getInstance() {
        return new ParkingLotService();
    }
}
