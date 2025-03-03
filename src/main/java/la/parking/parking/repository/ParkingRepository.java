package la.parking.parking.repository;

import la.parking.parking.model.ParkingSpot;
import la.parking.parking.model.Vehicle;
import java.util.List;

public interface ParkingRepository {
    List<ParkingSpot> getAllSpots();
    ParkingSpot findAvailableSpot(Vehicle vehicle);
    void occupySpot(ParkingSpot spot);
    void releaseSpot(ParkingSpot spot);
    int getAvailableSpotsCount();
}
