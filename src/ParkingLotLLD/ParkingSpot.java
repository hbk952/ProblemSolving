package ParkingLotLLD;

public class ParkingSpot {
	private int id;
	private String spotType;
	private int price;
	private Vehicle currentParkedVehicle = null;
	
	public boolean isEmpty() {
		if(currentParkedVehicle == null) {
			return true;
		}
		else {
			return false;
		}
	}
	public ParkingSpot(int id, String spotType) {
		super();
		this.id = id;
		this.spotType = spotType;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSpotType() {
		return spotType;
	}
	public void setSpotType(String spotType) {
		this.spotType = spotType;
	}
	public int getPrice() {
		return 100;
	}
	
	public Vehicle getCurrentParkedVehicle() {
		return currentParkedVehicle;
	}
	public void setCurrentParkedVehicle(Vehicle currentParkedVehicle) {
		this.currentParkedVehicle = currentParkedVehicle;
	}
	
	

}
