package la.parking.parking.controller;

import la.parking.parking.model.Ticket;
import la.parking.parking.model.Vehicle;
import la.parking.parking.model.VehicleType;
import la.parking.parking.service.ParkingService;
import la.parking.parking.view.ParkingView;

public class ParkingController {
    private final ParkingService parkingService;
    private final ParkingView view;
    
    public ParkingController(ParkingService parkingService, ParkingView view) {
        this.parkingService = parkingService;
        this.view = view;
    }
    
    public void processUserInput() {
        boolean exit = false;
        
        while (!exit) {
            int choice = view.showMainMenu();
            
            switch (choice) {
                case 1:
                    handleParkVehicle();
                    break;
                case 2:
                    handleUnparkVehicle();
                    break;
                case 3:
                    handleCheckAvailability();
                    break;
                case 4:
                    exit = true;
                    view.displayExitMessage();
                    break;
                case -1: // Cas spécial pour gérer une éventuelle annulation dans l'interface graphique
                    // Ne rien faire, retourner au menu
                    break;
                default:
                    view.displayInvalidOption();
            }
        }
    }
    
    private void handleParkVehicle() {
        String licensePlate = view.getVehicleLicensePlate();
        
        // Vérifier si l'utilisateur a annulé l'opération
        if (licensePlate.isEmpty()) {
            return;
        }
        
        VehicleType type = view.getVehicleType();
        Vehicle vehicle = new Vehicle(licensePlate, type);
        
        try {
            Ticket ticket = parkingService.parkVehicle(vehicle);
            view.displayParkingSuccess(ticket);
        } catch (RuntimeException e) {
            view.displayError(e.getMessage());
        }
    }
    
    private void handleUnparkVehicle() {
        int ticketId = view.getTicketId();
        
        // Vérifier si l'utilisateur a annulé l'opération
        if (ticketId < 0) {
            return;
        }
        
        try {
            double fee = parkingService.unparkVehicle(ticketId);
            view.displayUnparkingSuccess(fee);
        } catch (RuntimeException e) {
            view.displayError(e.getMessage());
        }
    }
    
    private void handleCheckAvailability() {
        int availableSpots = parkingService.getAvailableSpots();
        boolean isFull = parkingService.isParkingFull();
        view.displayAvailability(availableSpots, isFull);
    }
}
