package factory;

import service.ParkingLotService;

public class ParkingLotServiceFactory {
    private volatile static ParkingLotService obj;

    private ParkingLotServiceFactory() {
    }

    public static ParkingLotService getInstance() {

        if (obj == null) {
            // To make thread safe
            synchronized (ParkingLotService.class) {
                // check again as multiple threads
                // can reach above step
                if (obj == null)
                    obj = new ParkingLotService();
            }
        }
        return obj;

    }
}
