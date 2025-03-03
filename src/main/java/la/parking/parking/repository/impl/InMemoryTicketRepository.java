package la.parking.parking.repository.impl;

import la.parking.parking.model.Ticket;
import la.parking.parking.repository.TicketRepository;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class InMemoryTicketRepository implements TicketRepository {
    private final Map<Integer, Ticket> tickets = new HashMap<>();
    private final AtomicInteger idCounter = new AtomicInteger(1);
    
    @Override
    public Ticket save(Ticket ticket) {
        int id = idCounter.getAndIncrement();
        Ticket newTicket = new Ticket(id, ticket.getVehicle(), ticket.getParkingSpot());
        tickets.put(id, newTicket);
        return newTicket;
    }
    
    @Override
    public Ticket findById(int id) {
        return tickets.get(id);
    }
    
    @Override
    public void update(Ticket ticket) {
        if (tickets.containsKey(ticket.getId())) {
            tickets.put(ticket.getId(), ticket);
        }
    }
}
