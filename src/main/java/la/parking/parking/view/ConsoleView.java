package la.parking.parking.view;

import la.parking.parking.model.Ticket;
import la.parking.parking.model.VehicleType;

import java.util.Scanner;

public class ConsoleView implements ParkingView {
    private final Scanner scanner = new Scanner(System.in);
    
    @Override
    public int showMainMenu() {
        System.out.println("\n=== SYSTÈME DE GESTION DE PARKING ===");
        System.out.println("1. Garer un véhicule");
        System.out.println("2. Récupérer un véhicule");
        System.out.println("3. Afficher les places disponibles");
        System.out.println("4. Quitter");
        System.out.print("Choisissez une option (1-4): ");
        
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return 0; // Retourne une valeur invalide qui sera traitée par le contrôleur
        }
    }
    
    @Override
    public String getVehicleLicensePlate() {
        System.out.println("\n== Garer un véhicule ==");
        System.out.print("Numéro d'immatriculation: ");
        return scanner.nextLine();
    }
    
    @Override
    public VehicleType getVehicleType() {
        System.out.println("Type de véhicule: ");
        System.out.println("1. Voiture");
        System.out.println("2. Moto");
        System.out.println("3. Camion");
        System.out.print("Choisissez (1-3): ");
        
        try {
            int typeChoice = Integer.parseInt(scanner.nextLine());
            switch (typeChoice) {
                case 1: return VehicleType.CAR;
                case 2: return VehicleType.MOTORCYCLE;
                case 3: return VehicleType.TRUCK;
                default: 
                    System.out.println("Option invalide. Par défaut: Voiture");
                    return VehicleType.CAR;
            }
        } catch (NumberFormatException e) {
            System.out.println("Entrée invalide. Par défaut: Voiture");
            return VehicleType.CAR;
        }
    }
    
    @Override
    public int getTicketId() {
        System.out.println("\n== Récupérer un véhicule ==");
        System.out.print("Numéro du ticket: ");
        
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Numéro de ticket invalide.");
            return -1;
        }
    }
    
    @Override
    public void displayParkingSuccess(Ticket ticket) {
        System.out.println("Véhicule garé avec succès!");
        System.out.println("Ticket #" + ticket.getId());
        System.out.println("Place #" + ticket.getParkingSpot().getId());
        System.out.println("Heure d'entrée: " + ticket.getEntryTime());
    }
    
    @Override
    public void displayUnparkingSuccess(double fee) {
        System.out.println("Véhicule récupéré avec succès!");
        System.out.println("Frais à payer: " + fee + "€");
    }
    
    @Override
    public void displayAvailability(int availableSpots, boolean isFull) {
        System.out.println("\nNombre de places disponibles: " + availableSpots);
        if (isFull) {
            System.out.println("Le parking est complet.");
        }
    }
    
    @Override
    public void displayError(String message) {
        System.out.println("Erreur: " + message);
    }
    
    @Override
    public void displayInvalidOption() {
        System.out.println("Option invalide. Veuillez réessayer.");
    }
    
    @Override
    public void displayExitMessage() {
        System.out.println("Merci d'avoir utilisé notre système de parking!");
    }
}
