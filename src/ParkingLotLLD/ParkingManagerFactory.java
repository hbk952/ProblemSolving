package ParkingLotLLD;

public class ParkingManagerFactory {

	public ParkingSpotManager getParkingManager(Vehicle v) {
		
		if(v.VT.equals(VehicleType.TWOWHEELER)) {
			
			return new ParkingSpotManager(null);
			
		}
		else if (v.VT.equals(VehicleType.TWOWHEELER)) {
			return new ParkingSpotManager(null);
		}
	}

}
