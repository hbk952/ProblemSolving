package ParkingLotLLD;

public class ParkingSpotTwoWheeler extends ParkingSpot{

	public ParkingSpotTwoWheeler(int id, String spotType) {
		super(id, spotType);
		// TODO Auto-generated constructor stub
	}
	@Override
	public int getPrice() {
		return 20;
	}


}
