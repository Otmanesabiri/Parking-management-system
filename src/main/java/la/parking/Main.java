package la.parking;

import la.parking.parking.config.AppConfig;
import la.parking.parking.controller.ParkingController;

/**
 *
 * @author red
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Démarrage du système de gestion de parking...");
        
        // Obtenir le contrôleur depuis la configuration IoC
        ParkingController controller = AppConfig.getParkingController();
        
        // Lancer l'application avec le contrôleur
        controller.processUserInput();
    }
}
