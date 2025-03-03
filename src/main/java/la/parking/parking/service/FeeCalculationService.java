package la.parking.parking.service;

import la.parking.parking.model.Ticket;

public interface FeeCalculationService {
    double calculateFee(Ticket ticket);
}
