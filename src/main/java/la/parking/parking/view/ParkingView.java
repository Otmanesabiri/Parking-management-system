package la.parking.parking.view;

import la.parking.parking.model.Ticket;
import la.parking.parking.model.VehicleType;

public interface ParkingView {
    int showMainMenu();
    String getVehicleLicensePlate();
    VehicleType getVehicleType();
    int getTicketId();
    void displayParkingSuccess(Ticket ticket);
    void displayUnparkingSuccess(double fee);
    void displayAvailability(int availableSpots, boolean isFull);
    void displayError(String message);
    void displayInvalidOption();
    void displayExitMessage();
}
