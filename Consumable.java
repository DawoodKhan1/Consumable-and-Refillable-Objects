/**
 * Class: CSCI 1125-30
 * Semester: Spring 2017
 * @author Dawood Khan
 * Date:4/18/2017
 * Homework Assignment #4
 * 
 * Description: This interface is for consumable classes such as pizza, 
 * battery, etc. but not luggage. It defines the prototypes for basic 
 * methods which are consume and getters.
 *  
 */
public interface Consumable {

	/**
	 * This method will consume the amount parameter from the total capacity 
	 * if the capacity remaining after capacity is less than 0 an error is 
	 * thrown and capacity is set to 0.
	 * @param amount The value that is being subtracted from capacity
	 * @return Remaining amount after consumption
	 * @throws OverConsumedException Will be thrown if total amount remaining 
	 * is less than 0
	 */
	int consume(int amount) throws OverConsumedException;
	
	/**
	 * This simply is a getter for capacity as an int.
	 * @return Returns capacity as an int.
	 */
	int getRemainingCapacity();
	
	/**
	 * Returns capacity will the specific value and units depending on what 
	 * class implements it.
	 * @return Returns remaining capacity + units. i.e. 7 slices
	 */
	String getRemainingCapacityUnits();
}
