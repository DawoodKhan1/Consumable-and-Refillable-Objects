/**
 * Class: CSCI 1125-30
 * Semester: Spring 2017
 * @author Dawood Khan
 * Date:4/18/2017
 * Homework Assignment #4
 * 
 * Description: This interface is for identifiable classes that basically 
 * need to be identified.
 * It has a prototype for a getter for the id and a method to print the 
 * object details.
 *  
 */
public interface Identifiable {

	/**
	 * This is a getter for the id which is an integer.
	 * @return the unique identification of the product as an int
	 */
	int getId();
	
	/**
	 * This prints a summary of the object details. It would be of the form:
	 * Id, other object specific data members separated by commas.
	 */
	void printSummary();
}
