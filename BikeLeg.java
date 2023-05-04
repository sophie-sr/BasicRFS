public class BikeLeg extends Leg {

	BikeLeg(Location origin, Location destination, int distanceInKm, String days, double costPerKm) {
		super(origin, destination, distanceInKm, days, 1*distanceInKm);
	}
	
	BikeLeg(Location origin, Location destination, int distanceInKm, String days) {
		super(origin, destination, distanceInKm, days, 1*distanceInKm);
	}

}