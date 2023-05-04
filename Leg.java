
public class Leg {
	
	Location origin;
	Location destination;
	String daysAvailable;
	int distance;
	static double costPerKm;
	
	Leg (Location origin1, Location destination1, int distanceInKm, String days, double costPerKm1) {
		origin = origin1;
		destination = destination1;
		daysAvailable = days;
		distance = distanceInKm;
		costPerKm = costPerKm1;
	}
	
	public int getDistance () {
		return distance;
	}
	
	public double getCost () {
		return costPerKm;
	}
	
	public Location getOrigin () {
		return origin;
	}
	
	public Location getDestination () {
		return destination;
	}
	
	public Leg getLeg () {
		return this;
	}
	
	public String toString() {

		return String.format("%-25s", "Origin: " + origin) + String.format("%-25s", " Destination: " + destination);
	}

}
