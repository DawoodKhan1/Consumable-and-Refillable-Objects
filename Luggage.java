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
public class Luggage implements Identifiable {

	String color; 						// the color of the luggage
	int Id; 							// specific id of the luggage
	
	/**
	 * Explicit value constructor
	 * @param color The color of the luggage
	 */
	Luggage(int Id, String color){
		this.Id = Id;
		this.color = color;
	}
	
	String getColor(){
		return color; 
	}

	@Override
	public int getId() {
		return Id;
	}

	/**
	 * This prints a summary of the object details. It would be of the form:
	 * Id, color
	 */
	@Override
	public void printSummary() {
		StringBuilder summary = new StringBuilder();
		
		summary.append("Luggage: id=");
		summary.append(Id);
		summary.append(", color=");
		summary.append(color);
		
		System.out.println(summary);	
	}
}
