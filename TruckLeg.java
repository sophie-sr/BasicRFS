public class TruckLeg extends Leg {

	TruckLeg(Location origin, Location destination, int distanceInKm, String days, double costPerKm) {
		super(origin, destination, distanceInKm, days, 0.58*distanceInKm);
	}
	
	TruckLeg(Location origin, Location destination, int distanceInKm, String days) {
		super(origin, destination, distanceInKm, days, 0.58*distanceInKm);
	}

}