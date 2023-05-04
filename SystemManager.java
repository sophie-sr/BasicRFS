import java.util.ArrayList;

public class SystemManager {
	
	static ArrayList<Location> locations = new ArrayList<Location>(); //stores all locations
	static ArrayList<Leg> legs = new ArrayList<Leg>(); //stores all legs
	
	//prints all the legs and locations currently in the system
	public static void displaySystemDetails () {
		System.out.println("Legs:");
		
		for (Leg str : legs) {
			System.out.println(str);
		}
		
		System.out.println("Locations:");
		
		for (Location str : locations) {
			System.out.println(str);
		}
	}
	
	//adds location to locations if l is a valid location
	public static void addLocation (Location l) {
		
		//if l is an Airport, name must be 3 uppercase letters
		if (l instanceof Airport) {
			if (l.getName().length() == 3 && l.getName().toUpperCase() == l.getName()) {
				locations.add(l);
			} else {
				System.out.println("Error, that location doesn't work :(");
				System.exit(0);
			}
		}
		
		//if l is a TruckDepot, name must be 8 uppercase letters
		if (l instanceof TruckDepot) {
			if (l.getName().length() == 8 && l.getName().toUpperCase() == l.getName()) {
				locations.add(l);
			} else {
				System.out.println("Error, that location doesn't work :(");
				System.exit(0);
			}
		}
		
		//if l is a BikeDeliveryLocation, name can be anything
		if (l instanceof BikeDeliveryLocation) {
			locations.add(l);
		}
	}
	
	//adds leg to legs if the leg is possible
	public static void addLeg (Leg l) {
		
		//checks for invalid distance
		if (l.distance < 1) {
			System.out.println("Error, that leg doesn't work :(");
			System.exit(0);
		}
		
		//checks for invalid days
		for (int i = 0; i < l.daysAvailable.length(); i++) {
			if (!"MTWRFSU".contains(l.daysAvailable.substring(i, i+1))) {
				System.out.println("Error, that leg doesn't work :(");
				System.exit(0);
			}
		}
		
		//if l is a BikeLeg, origin and/or destination must be a BikeDeliveryLocation, the other being a TruckDepot
		if (l instanceof BikeLeg) {
			if ((l.origin instanceof BikeDeliveryLocation && l.destination instanceof BikeDeliveryLocation) || 
					(l.origin instanceof BikeDeliveryLocation && l.destination instanceof TruckDepot) || 
					(l.origin instanceof TruckDepot && l.destination instanceof BikeDeliveryLocation)) {
						legs.add(l);
			} else {
				System.out.println("Error, that leg doesn't work :(");
				System.exit(0);
			}
		}
		
		//if l is a Flight, origin and destination must be a Airport
		if (l instanceof Flight) {
			if (l.origin instanceof Airport && l.destination instanceof Airport) {
						legs.add(l);
			} else {
				System.out.println("Error, that leg doesn't work :(");
				System.exit(0);
			}
		}
		
		//if l is a TruckLeg, origin and/or destination must a TruckDepot, the other being a Airport
		if (l instanceof TruckLeg) {
			if ((l.origin instanceof TruckDepot && l.destination instanceof TruckDepot) || 
					(l.origin instanceof Airport && l.destination instanceof TruckDepot) || 
					(l.origin instanceof TruckDepot && l.destination instanceof Airport)) {
						legs.add(l);
			} else {
				System.out.println("Error, that leg doesn't work :(");
				System.exit(0);
			}
		}
		
	}
	
	//finds and returns a location within locations based on a given name
	public static Location findLocation (String s) {
				
		for (Location l: locations) {
			if (l.getName().equals(s)) {
				return l;
			}
		}
		
		return null;
	}
	
	//finds the cheapest route from origin to destination
	public static Route findCheapestRoute (Location origin, Location destination, String day) {
		
		return origin.cheapestRouteTo(destination, day);
	
	}
	
	//finds the route with the least steps from origin to destination
	public static Route findMinStepsRoute (Location origin, Location destination, String day) {
		return origin.minStepsRouteTo(destination, day);
	}
	
	//finds the shortest route from origin to destination
	public static Route findShortestKmRoute (Location origin, Location destination, String day) {
		return origin.shortestKmRouteTo(destination, day);
	}

}