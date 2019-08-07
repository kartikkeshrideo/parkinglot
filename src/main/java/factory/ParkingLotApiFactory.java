package factory;

import impl.ParkingLotImpl;
import service.ParkingLotService;

public class ParkingLotApiFactory {
    private ParkingLotService parkingLotService;
    public ParkingLotApiFactory(ParkingLotService parkingLotService) {
        this.parkingLotService = parkingLotService;
    }
    public ParkingLotImpl getInstance() {
        return new ParkingLotImpl(this.parkingLotService);
    }
}
