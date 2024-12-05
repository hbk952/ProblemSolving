package ParkingLotLLD;

public interface ParkingStrategyManager {
	ParkingSpot p = null;
	default ParkingSpot findSpace(Vehicle v) {
		return p;
	}
}
