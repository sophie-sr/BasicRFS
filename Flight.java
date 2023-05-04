public class Flight extends Leg {

	Flight(Location origin, Location destination, int distanceInKm, String days, double costPerKm) {
		super(origin, destination, distanceInKm, days, 0.23*distanceInKm);
	}
	
	Flight(Location origin, Location destination, int distanceInKm, String days) {
		super(origin, destination, distanceInKm, days, 0.23*distanceInKm);
	}

}