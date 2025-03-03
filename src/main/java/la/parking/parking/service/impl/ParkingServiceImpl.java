package la.parking.parking.service.impl;

import la.parking.parking.model.ParkingSpot;
import la.parking.parking.model.Ticket;
import la.parking.parking.model.Vehicle;
import la.parking.parking.repository.ParkingRepository;
import la.parking.parking.repository.TicketRepository;
import la.parking.parking.service.FeeCalculationService;
import la.parking.parking.service.ParkingService;
import java.time.LocalDateTime;

public class ParkingServiceImpl implements ParkingService {
    private final ParkingRepository parkingRepository;
    private final TicketRepository ticketRepository;
    private final FeeCalculationService feeCalculationService;
    
    // Injection de dépendances via constructeur
    public ParkingServiceImpl(ParkingRepository parkingRepository, 
                             TicketRepository ticketRepository,
                             FeeCalculationService feeCalculationService) {
        this.parkingRepository = parkingRepository;
        this.ticketRepository = ticketRepository;
        this.feeCalculationService = feeCalculationService;
    }
    
    @Override
    public Ticket parkVehicle(Vehicle vehicle) {
        ParkingSpot availableSpot = parkingRepository.findAvailableSpot(vehicle);
        if (availableSpot == null) {
            throw new RuntimeException("No parking spot available for " + vehicle.getType());
        }
        
        parkingRepository.occupySpot(availableSpot);
        
        // Créer un ticket temporaire pour l'enregistrer
        Ticket tempTicket = new Ticket(0, vehicle, availableSpot);
        return ticketRepository.save(tempTicket);
    }
    
    @Override
    public double unparkVehicle(int ticketId) {
        Ticket ticket = ticketRepository.findById(ticketId);
        if (ticket == null) {
            throw new RuntimeException("Invalid ticket ID");
        }
        
        // Marquer la sortie
        ticket.setExitTime(LocalDateTime.now());
        ticketRepository.update(ticket);
        
        // Libérer la place
        parkingRepository.releaseSpot(ticket.getParkingSpot());
        
        // Calculer les frais
        return feeCalculationService.calculateFee(ticket);
    }
    
    @Override
    public boolean isParkingFull() {
        return parkingRepository.getAvailableSpotsCount() == 0;
    }
    
    @Override
    public int getAvailableSpots() {
        return parkingRepository.getAvailableSpotsCount();
    }
}
