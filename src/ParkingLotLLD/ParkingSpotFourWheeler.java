package ParkingLotLLD;

public class ParkingSpotFourWheeler extends ParkingSpot{

	public ParkingSpotFourWheeler(int id, String spotType) {
		super(id, spotType);
		// TODO Auto-generated constructor stub
	}
	@Override
	public int getPrice() {
		return 50;
	}

}
