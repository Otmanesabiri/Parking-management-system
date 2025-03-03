package la.parking.parking.service;

import la.parking.parking.model.Ticket;
import la.parking.parking.model.Vehicle;

public interface ParkingService {
    Ticket parkVehicle(Vehicle vehicle);
    double unparkVehicle(int ticketId);
    boolean isParkingFull();
    int getAvailableSpots();
}
