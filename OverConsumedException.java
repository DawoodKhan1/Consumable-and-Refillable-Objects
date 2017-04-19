/**
 * Class: CSCI 1125-30
 * Semester: Spring 2017
 * @author Dawood Khan
 * Date:4/18/2017
 * Homework Assignment #4
 * 
 * Description: This is a class that defines an exception that is thrown if 
 * the consumed amount exceeds the current capacity of the object.
 *
 */
public class OverConsumedException extends Exception {

	/**
	 * Needed otherwise it issues a warning.
	 */
	private static final long serialVersionUID = 1L;

	// Parameterless exception
	public OverConsumedException(){}
	
	public OverConsumedException(String message){
		super(message);
	}
}
