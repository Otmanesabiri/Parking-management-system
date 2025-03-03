package la.parking.parking.repository.impl;

import la.parking.parking.model.ParkingSpot;
import la.parking.parking.model.Vehicle;
import la.parking.parking.model.VehicleType;
import la.parking.parking.repository.ParkingRepository;
import java.util.ArrayList;
import java.util.List;

public class InMemoryParkingRepository implements ParkingRepository {
    private final List<ParkingSpot> spots;
    
    public InMemoryParkingRepository(int carSpots, int motorcycleSpots, int truckSpots) {
        spots = new ArrayList<>();
        int id = 1;
        
        // Initialiser les places pour voitures
        for (int i = 0; i < carSpots; i++) {
            spots.add(new ParkingSpot(id++, VehicleType.CAR));
        }
        
        // Initialiser les places pour motos
        for (int i = 0; i < motorcycleSpots; i++) {
            spots.add(new ParkingSpot(id++, VehicleType.MOTORCYCLE));
        }
        
        // Initialiser les places pour camions
        for (int i = 0; i < truckSpots; i++) {
            spots.add(new ParkingSpot(id++, VehicleType.TRUCK));
        }
    }
    
    @Override
    public List<ParkingSpot> getAllSpots() {
        return new ArrayList<>(spots);
    }
    
    @Override
    public ParkingSpot findAvailableSpot(Vehicle vehicle) {
        return spots.stream()
                .filter(spot -> spot.canPark(vehicle))
                .findFirst()
                .orElse(null);
    }
    
    @Override
    public void occupySpot(ParkingSpot spot) {
        spots.stream()
                .filter(s -> s.getId() == spot.getId())
                .findFirst()
                .ifPresent(s -> s.setOccupied(true));
    }
    
    @Override
    public void releaseSpot(ParkingSpot spot) {
        spots.stream()
                .filter(s -> s.getId() == spot.getId())
                .findFirst()
                .ifPresent(s -> s.setOccupied(false));
    }
    
    @Override
    public int getAvailableSpotsCount() {
        return (int) spots.stream().filter(spot -> !spot.isOccupied()).count();
    }
}
