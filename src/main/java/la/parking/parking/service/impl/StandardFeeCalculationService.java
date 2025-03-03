package la.parking.parking.service.impl;

import la.parking.parking.model.Ticket;
import la.parking.parking.service.FeeCalculationService;
import java.time.Duration;
import java.time.LocalDateTime;

public class StandardFeeCalculationService implements FeeCalculationService {
    private static final double HOURLY_RATE_CAR = 2.0;
    private static final double HOURLY_RATE_MOTORCYCLE = 1.0;
    private static final double HOURLY_RATE_TRUCK = 4.0;
    
    @Override
    public double calculateFee(Ticket ticket) {
        LocalDateTime exitTime = ticket.getExitTime() != null ? ticket.getExitTime() : LocalDateTime.now();
        long hours = Duration.between(ticket.getEntryTime(), exitTime).toHours() + 1; // +1 pour compter l'heure commencée
        
        switch (ticket.getVehicle().getType()) {
            case CAR:
                return hours * HOURLY_RATE_CAR;
            case MOTORCYCLE:
                return hours * HOURLY_RATE_MOTORCYCLE;
            case TRUCK:
                return hours * HOURLY_RATE_TRUCK;
            default:
                return 0.0;
        }
    }
}
