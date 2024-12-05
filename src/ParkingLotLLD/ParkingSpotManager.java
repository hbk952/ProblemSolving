package ParkingLotLLD;

import java.util.List;

public class ParkingSpotManager {
	List<ParkingSpot> parkingspots;
	ParkingStrategyManager psm;

	public ParkingSpotManager(List<ParkingSpot> parkingspots) {
		super();
		this.parkingspots = parkingspots;
	}
	
	public ParkingSpot findParkingSpace() {
		return parkingspots.get(0); //returning random value initially
	}
	
	public ParkingSpot parkVehicle(Vehicle v) {
		return parkingspots.get(0); //returning random value initially
	}
	
	public ParkingSpot removeVehicle(Vehicle v) {
		return parkingspots.get(0); //returning random value initially
	}


}
