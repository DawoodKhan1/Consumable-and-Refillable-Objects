import java.text.DecimalFormat;

/**
 * Class: CSCI 1125-30
 * Semester: Spring 2017
 * @author Dawood Khan
 * Date:4/18/2017
 * Homework Assignment #4
 * 
 * Description: This class defines Luggage which consists of getter for color 
 * and is also identifiable meaning it also has methods for getting id as well
 * as printing summary details about the object.
 *  
 */
public class Battery implements Consumable, Identifiable {
	// how many milliampere-hours of capacity it has
	public static final int mAHMax = 3000;
	int mAH; 							// current capacity
	int Id; 							// unique identifier for Id
	
	/**
	 * Explicit Value constructor
	 * @param mAH starting capacity
	 * @param Id  unique Id
	 */
	Battery(int Id, int mAH){
		this.Id = Id;
		this.mAH = mAH;
	}
	
	/**
	 * This returns the battery left as a percentage in terms of total 
	 * battery possible.
	 * @return Percentage as a double
	 */
	double getPercentBatteryLeft(){
		return (double) mAH / mAHMax * 100; // to avoid integer division
	}
	
	
	public int getId() {
		return Id;
	}

	/**
	 * This prints a summary of the object details. It would be of the form:
	 * Id, percent battery left
	 * Ex. 1234, 64.1%
	 */
	@Override
	public void printSummary() {
		StringBuilder summary = new StringBuilder();
		
		summary.append("Battery: id=");
		summary.append(Id);
		summary.append(", % left=");
		summary.append(this.getPercentBatteryLeft()); 
		
		System.out.println(summary);
	}

	/**
	 * This method consumes amount of capacity from initial capacity.
	 * If the capacity remaining after capacity is less than 0 an error 
	 * is thrown and capacity is set to 0.
	 * @param amount The value that is being subtracted from capacity
	 * @return Remaining number of mAH after consumption
	 * @throws OverConsumedException Will be thrown if total amount 
	 * remaining is less than 0
	 */
	@Override
	public int consume(int amount) throws OverConsumedException {
		mAH -= amount; 			// consume amount of slices given
		
		// if negative set capacity to min which is 0 and throw an exception
		if(mAH < 0){ 				
			mAH = 0;
			throw new OverConsumedException();
		}
		
		return mAH;
	}

	@Override
	public int getRemainingCapacity() {
		return mAH;
	}

	/**
	 * @returns a string remaining battery left as a string in format:
	 * capacity + mAH
	 * Ex. 1000 mAH
	 */
	@Override
	public String getRemainingCapacityUnits() {

		return mAH + " mAH";
	}
}
