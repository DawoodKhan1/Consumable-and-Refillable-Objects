import java.text.DecimalFormat;

/**
 * Class: CSCI 1125-30
 * Semester: Spring 2017
 * @author Dawood Khan
 * Date:4/18/2017
 * Homework Assignment #4
 * 
 * Description: This class defines Pizza which is also consumable and 
 * identifiable. That means this Pizza can be identified, consumed, as 
 * well as being able to return surface area left.
 *  
 */
public class Pizza implements Consumable, Identifiable{

	public static final double PI = 3.14159;// for area calculations
	double diameter; 					// the diameter of the pizza
	String flavor; 					// what is the flavor of the pizza
	int capacity; 					// slices remaining
	int id; 						// unique identifying id
	
	/**
	 * Explicit value constructor
	 */
	Pizza(int id, int diameter, String flavor){
		this.capacity = 8; 			// always starts with 8 slices
		this.id = id; 				// set the Id
		this.diameter = diameter;
		this.flavor = flavor;
	}
	
	/**
	 * This method calculates the remaining the remaining amount of surface 
	 * area left on the pizza.
	 * @return The area as a double
	 */
	double getRemainingSurfaceArea(){
		// Area = pi r^2 * what percentage of pizza remains
		return PI * (diameter / 2) * (diameter / 2) * ((double)capacity / 8); 
	}
	
	/**
	 * This method consumes amount number of slices from the number of slices 
	 * currently.
	 * If the capacity remaining after capacity is less than 0 an error is 
	 * thrown and capacity is set to 0.
	 * @param amount The value that is being subtracted from capacity
	 * @return Remaining number of slices after consumption
	 * @throws OverConsumedException 
	 */
	@Override
	public int consume(int amount) throws OverConsumedException {
		capacity -= amount; 			// consume amount of slices given
		
		// if negative set capacity to min which is 0 and throw an exception
		if(capacity < 0){ 				
			capacity = 0;
			throw new OverConsumedException();
		}
		
		return capacity;
	}

	/***
	 * This simply is a getter for capacity as an int which is number 
	 * of slices remaining.
	 * @return Returns capacity as an int.
	 */
	@Override
	public int getRemainingCapacity() {
		return capacity;
	}
	
	/**
	 * Returns capacity with the word slices after it.
	 * @return Returns remaining capacity + units. i.e. 7 slices
	 */
	@Override
	public String getRemainingCapacityUnits() {
		return capacity + " slices";
	}

	@Override
	public int getId() {
		return id;
	}

	/**
	 * This will print the summary in the format to the console: 
	 * Id, diameter, flavor, remaining surface area
	 * Ex. 1234, 14, Cheese, 25
	 */
	@Override
	public void printSummary() {
		StringBuilder summary = new StringBuilder();
		// making it so if the diameter is a whole number such as 6, it 
		// displays as 6 and 6.5 displays as 6.6
		DecimalFormat format = new DecimalFormat();
		format.setDecimalSeparatorAlwaysShown(false);
		
		summary.append("Pizza: id=");
		summary.append(id);
		summary.append(", diameter=");
		summary.append(format.format(diameter));
		summary.append(", flavor=");
		summary.append(flavor);
		summary.append(", rem_surf_area=");
		summary.append(this.getRemainingSurfaceArea());
		
		System.out.println(summary);
	}	
}
