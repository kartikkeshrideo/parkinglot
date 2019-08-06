package model;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ParkingLot {
    private int capacity;
    private Map<Integer, Car> carsParked = new HashMap<>();
    private PriorityQueue<Integer> availableSlots = new PriorityQueue<>();

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        for (int i = 0; i < capacity; i++) {
            availableSlots.add(i + 1);
        }
    }

    public boolean isFull() {
        return availableSlots.isEmpty();
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Map<Integer, Car> getCarsParked() {
        return carsParked;
    }

    public void setCarsParked(Map<Integer, Car> carsParked) {
        this.carsParked = carsParked;
    }

    public PriorityQueue<Integer> getAvailableSlots() {
        return availableSlots;
    }

    public void setAvailableSlots(PriorityQueue<Integer> availableSlots) {
        this.availableSlots = availableSlots;
    }

    public int getAvailableSlotNumber() {
        return availableSlots.peek();
    }

}
