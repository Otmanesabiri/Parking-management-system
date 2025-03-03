package la.parking.parking.model;

public class ParkingSpot {
    private int id;
    private boolean occupied;
    private VehicleType spotType;
    
    public ParkingSpot(int id, VehicleType spotType) {
        this.id = id;
        this.spotType = spotType;
        this.occupied = false;
    }
    
    public int getId() {
        return id;
    }
    
    public boolean isOccupied() {
        return occupied;
    }
    
    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }
    
    public VehicleType getSpotType() {
        return spotType;
    }
    
    public boolean canPark(Vehicle vehicle) {
        return !occupied && (spotType == vehicle.getType() || spotType == VehicleType.CAR && vehicle.getType() == VehicleType.MOTORCYCLE);
    }
}
