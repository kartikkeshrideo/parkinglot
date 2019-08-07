package service;

import factory.ParkingLotServiceFactory;
import model.Car;
import org.junit.Test;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class ParkingLotServiceTest {
    private static ParkingLotService parkingLotService = ParkingLotServiceFactory.getInstance();

    @Test
    public void testParkCar_availableSpace() {
        parkingLotService.createParkingLot(2);
        parkingLotService.parkCar(new Car("1234", "white"));
        assertEquals(2, parkingLotService.getParkingLot().getAvailableSlotNumber());
    }

    @Test
    public void testParkCar_No_availableSpace() {
        parkingLotService.createParkingLot(1);
        parkingLotService.parkCar(new Car("1234", "white"));
        assertTrue(parkingLotService.getParkingLot().isFull());
    }


    @Test
    public void testGetSlotNoByCarRegNo_if_car_is_present() {
        parkingLotService.createParkingLot(1);
        parkingLotService.parkCar(new Car("1234", "white"));
        int actual = parkingLotService.getSlotNoByCarRegNo("1234");
        assertEquals(1, actual);
    }

    @Test
    public void testGetSlotNoByCarRegNo_if_car_is_not_present() {
        parkingLotService.createParkingLot(1);
        parkingLotService.parkCar(new Car("1234", "white"));
        int actual = parkingLotService.getSlotNoByCarRegNo("2345");
        assertEquals(-1, actual);
    }

    @Test
    public void testUnparkCar() {
        parkingLotService.createParkingLot(2);
        parkingLotService.parkCar(new Car("1234", "white"));
        parkingLotService.parkCar(new Car("2345", "black"));
        parkingLotService.unparkCar(2);
        int actual = parkingLotService.getParkingLot().getAvailableSlotNumber();
        assertEquals(2, actual);
    }

    @Test
    public void testGetRegNoForCarsWithColor() {
        parkingLotService.createParkingLot(3);
        parkingLotService.parkCar(new Car("1234", "white"));
        parkingLotService.parkCar(new Car("12345", "white"));
        parkingLotService.parkCar(new Car("2345", "black"));
        String actual1 = parkingLotService.getRegNoForCarsWithColor("white");
        String actual2 = parkingLotService.getRegNoForCarsWithColor("black");
        assertEquals("1234,12345", actual1);
        assertEquals("2345", actual2);
    }

    @Test
    public void testGetSlotNoForCarsWithColor() {
        parkingLotService.createParkingLot(3);
        parkingLotService.parkCar(new Car("1234", "white"));
        parkingLotService.parkCar(new Car("12345", "white"));
        parkingLotService.parkCar(new Car("2345", "black"));
        String actualSlotNos = parkingLotService.getSlotNoForCarsWithColor("white");
        assertEquals("1,2", actualSlotNos);
    }
}
