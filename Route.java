import java.util.ArrayList;

public class Route {
	
	static ArrayList<Leg> legs = new ArrayList<Leg>();
	
	private double cost = 0;
	private int distance = 0;
	private int steps = 0;

	//finds and returns the total cost of the route
	public double totalCost () {
				
		for (Leg l : legs) {
			cost += l.getCost();
		}
		
		return cost;
	}
	
	//finds and returns the total distance of the route
	public int totalDistance () {
		
		for (Leg l : legs) {
			distance += l.getDistance();
		}
		
		return distance;
	}
	
	//finds and returns the total number of steps of the route
	public int totalSteps () {
		
		for (Leg l : legs) {
			steps++;
		}
		
		return steps;
	}
	
	//adds a leg to the route
	public void addLeg (Leg l) {
		
		legs.add(l);
		
	}
	
	public String toString () {
		String s = "Steps: " + this.totalSteps() + " Distance: " + this.totalDistance() + " Cost: " + this.totalCost();
		String r = "\nRoute Start:";
		String l = "";
		for (int i = legs.size()-1; i > 0; i--) {
			l += String.format("%-25s", "\nOrigin: " + legs.get(i).origin) + String.format("%-25s", " Destination: " + legs.get(i).destination);
		}
		String e = "\nRoute End.";
		return s + r + l + e;
	}
	
}