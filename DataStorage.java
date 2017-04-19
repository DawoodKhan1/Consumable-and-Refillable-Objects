/**
 * Class: CSCI 1125-30
 * Semester: Spring 2017
 * @author Dawood Khan
 * Date:4/18/2017
 * Homework Assignment #4
 * 
 * Description: This class defines Data Storage which contains an arrayList 
 * of Identifiable objects and has a few useful methods for it such as calling
 * printSummary on the entire arrayList as well as a linear search method.
 *  
 */
import java.util.ArrayList;
public class DataStorage {

	private ArrayList<Identifiable> loadedData = new ArrayList<Identifiable>();
	
	/**
	 * This method searches the arrayList given an id and returns an 
	 * identifiable object if found, otherwise returns null
	 * @param id The id of the Identifiable object to search for
	 * @return An Identifiable object if it's in the arrayList, otherwise null
	 */
	public Identifiable searchArrayList(int id){
		Boolean found = false;
		int index = 0; 						// index of array list
		
		for(int i = 0; i < loadedData.size() && !found; i++){
			if(loadedData.get(i).getId() == id){
				found = true;
				index = i; 				// keep position of arrayList
			}
		}
		
		if(found){ // if found return the object
			return loadedData.get(index);
		}
		
		return null; 					// if not found, return null object
	}
	
	/**
	 * This method allows an identifiable item to be added to the arrayList 
	 * loadedData.
	 * @param item The object to be added
	 */
	public void addIdentifiable(Identifiable item){
		loadedData.add(item);
	}
	
	/**
	 * This method outputs the status of all the Identifiable objects using 
	 * the printSummary
	 * on all the objects within the arrayList.
	 */
	public void printArray(){
		StringBuilder header = new StringBuilder();
		
		header.append("\n==================================================\n");
		header.append("   Summary of data after running instructions     \n");
		header.append("==================================================");
		
		System.out.println(header);
		
		for(int i = 0; i < loadedData.size(); i++){
			loadedData.get(i).printSummary();
		}
	}
}
