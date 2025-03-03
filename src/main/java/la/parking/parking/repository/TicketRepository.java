package la.parking.parking.repository;

import la.parking.parking.model.Ticket;

public interface TicketRepository {
    Ticket save(Ticket ticket);
    Ticket findById(int id);
    void update(Ticket ticket);
}
