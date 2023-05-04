import java.util.ArrayList;

public class Location {
	
	private String name;
	private ArrayList<Leg> connectingLegs;
	private ArrayList<Route> correctRoutes;
	
	public Location() {

	}
	
	public Location(String n) {
		name = n;
		connectingLegs = new ArrayList<Leg>();
	}
	
	public String getName () {
		return name;
	}
	
	public void addConnection (Leg l) {
		connectingLegs.add(l);
	}
	
	//finds the cheapest route from this location to loc on day
	public Route cheapestRouteTo(Location loc, String day) {
		
		double minCost = Double.MAX_VALUE;
		
		Route bestRoute = null;
				
		if (this.getName().equals(loc.getName())) {
			return new Route();
		}
		
		//iterates through every connecting leg of this location to build up different routes, 
		//compares them against each other to find the cheapest one
		for (int i = 0; i < connectingLegs.size(); i++) {
			
			//checks to see if the days match
			if(connectingLegs.get(i).daysAvailable.contains(day)) {
				
				Route testRoute = connectingLegs.get(i).destination.cheapestRouteTo(loc, day);

				if (testRoute != null) {
					
					testRoute.addLeg(connectingLegs.get(i));
					
					//if the current testRoute is cheaper than the stored bestRoute, testRoute becomes bestRoute
					if (testRoute.totalCost() <= minCost) {
						minCost = testRoute.totalCost();
						bestRoute = testRoute;
					}
				}
			}
		}
		
		return bestRoute;
	}
	
	//finds the route with the least steps from this location to loc on day
	public Route minStepsRouteTo(Location loc, String day) {
		
		double minSteps = Double.MAX_VALUE;
		
		Route bestRoute = null;
				
		if (this.getName().equals(loc.getName())) {
			return new Route();
		}
		
		//iterates through every connecting leg of this location to build up different routes, 
		//compares them against each other to find the cheapest one
		for (int i = 0; i < connectingLegs.size(); i++) {
			
			//checks to see if the days match
			if(connectingLegs.get(i).daysAvailable.contains(day)) {
				
				Route testRoute = connectingLegs.get(i).destination.minStepsRouteTo(loc, day);

				if (testRoute != null) {
					
					testRoute.addLeg(connectingLegs.get(i));
					
					//if the current testRoute is cheaper than the stored bestRoute, testRoute becomes bestRoute
					if (testRoute.totalSteps() <= minSteps) {
						minSteps = testRoute.totalSteps();
						bestRoute = testRoute;
					}
				}
			}
		}
		
		return bestRoute;	
	}
	
	//finds the shortest route from this location to loc on day
	public Route shortestKmRouteTo(Location loc, String day) {
		
		double minKm = Double.MAX_VALUE;
		
		Route bestRoute = null;
				
		if (this.getName().equals(loc.getName())) {
			return new Route();
		}
		
		//iterates through every connecting leg of this location to build up different routes, 
		//compares them against each other to find the cheapest one
		for (int i = 0; i < connectingLegs.size(); i++) {
			
			//checks to see if the days match
			if(connectingLegs.get(i).daysAvailable.contains(day)) {
				
				Route testRoute = connectingLegs.get(i).destination.shortestKmRouteTo(loc, day);

				if (testRoute != null) {
					
					testRoute.addLeg(connectingLegs.get(i));
					
					//if the current testRoute is cheaper than the stored bestRoute, testRoute becomes bestRoute
					if (testRoute.totalDistance() <= minKm) {
						minKm = testRoute.totalDistance();
						bestRoute = testRoute;
					}
				}
			}
		}
		
		return bestRoute;
	}
	
	public String toString () {
		return name;
	}

}
