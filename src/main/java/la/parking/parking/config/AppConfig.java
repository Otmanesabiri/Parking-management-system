package la.parking.parking.config;

import la.parking.parking.controller.ParkingController;
import la.parking.parking.repository.ParkingRepository;
import la.parking.parking.repository.TicketRepository;
import la.parking.parking.repository.impl.InMemoryParkingRepository;
import la.parking.parking.repository.impl.InMemoryTicketRepository;
import la.parking.parking.service.FeeCalculationService;
import la.parking.parking.service.ParkingService;
import la.parking.parking.service.impl.ParkingServiceImpl;
import la.parking.parking.service.impl.StandardFeeCalculationService;
import la.parking.parking.view.ConsoleView;
import la.parking.parking.view.ParkingView;

public class AppConfig {
    // Singleton des repositories
    private static ParkingRepository parkingRepository;
    private static TicketRepository ticketRepository;
    
    // Singleton des services
    private static FeeCalculationService feeCalculationService;
    private static ParkingService parkingService;
    
    // Composants MVC
    private static ParkingView parkingView;
    private static ParkingController parkingController;
    
    // Méthodes d'accès aux dépendances (façon simple de simuler un container IoC)
    
    public static ParkingRepository getParkingRepository() {
        if (parkingRepository == null) {
            // Initialiser avec 10 places de voiture, 5 de moto et 3 de camion
            parkingRepository = new InMemoryParkingRepository(10, 5, 3);
        }
        return parkingRepository;
    }
    
    public static TicketRepository getTicketRepository() {
        if (ticketRepository == null) {
            ticketRepository = new InMemoryTicketRepository();
        }
        return ticketRepository;
    }
    
    public static FeeCalculationService getFeeCalculationService() {
        if (feeCalculationService == null) {
            feeCalculationService = new StandardFeeCalculationService();
        }
        return feeCalculationService;
    }
    
    public static ParkingService getParkingService() {
        if (parkingService == null) {
            parkingService = new ParkingServiceImpl(
                getParkingRepository(),
                getTicketRepository(),
                getFeeCalculationService()
            );
        }
        return parkingService;
    }
    
    public static ParkingView getParkingView() {
        if (parkingView == null) {
            // Retour à la vue console
            parkingView = new ConsoleView();
        }
        return parkingView;
    }
    
    public static ParkingController getParkingController() {
        if (parkingController == null) {
            parkingController = new ParkingController(
                getParkingService(),
                getParkingView()
            );
        }
        return parkingController;
    }
}
