import api.ParkingLotApi;
import config.ParkingLotCommand;
import factory.ParkingLotApiFactory;
import factory.ParkingLotServiceFactory;
import model.Car;
import service.ParkingLotService;

import java.io.*;

public class ParkingLotCommandParser {
    private static final ParkingLotService parkingLotService = ParkingLotServiceFactory.getInstance();
    private static final ParkingLotApi parkingLotApi = new ParkingLotApiFactory(parkingLotService).getInstance();

    public ParkingLotCommandParser() {

    }

    public void execute(String input) {
        String[] args = input.split(" ");
        switch (ParkingLotCommand.valueOf(args[0])) {
            case create_parking_lot:
                parkingLotApi.createParkingLot(Integer.valueOf(args[1]));
                break;
            case status:
                parkingLotApi.status();
                break;
            case park:
                parkingLotApi.parkCar(new Car(args[1], args[2]));
                break;
            case leave:
                parkingLotApi.unparkCar(Integer.valueOf(args[1]));
                break;
            case slot_numbers_for_cars_with_colour:
                parkingLotApi.getSlotNoForCarsWithColor(args[1]);
                break;
            case slot_number_for_registration_number:
                parkingLotApi.getSlotNoByCarRegNo(args[1]);
                break;
            case registration_numbers_for_cars_with_colour:
                parkingLotApi.getRegNoForCarsWithColor(args[1]);
                break;

        }
    }

    public void parseFileInput(String filePath) throws IOException {
        File inputFile = new File(filePath);
        try {
            BufferedReader br = new BufferedReader(new FileReader(inputFile));
            String line;
            try {
                while ((line = br.readLine()) != null) {
                    execute(line.trim());
                }
            } catch (IOException e) {
                System.out.println("Error in reading the input file.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found in the path specified.");
        }
    }
}
