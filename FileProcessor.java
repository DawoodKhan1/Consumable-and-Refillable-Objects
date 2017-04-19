/**
 * Class: CSCI 1125-30
 * Semester: Spring 2017
 * @author Dawood Khan
 * Date:4/18/2017
 * Homework Assignment #4
 * 
 * Description: This class defines FileProcessor. The point of this class is 
 * to process the two input files. For the binaryFile it uses DataStorage to 
 * store all the information about the Identifiable objects and DataInputStream
 * to read in the binary data. 
 * It also has a method for taking in consumption instruction from a regular 
 * textFile using Scanner. It then takes in a DataStorage object and then call
 * .consume() on it depending if the id in the file is in the DataStorage
 * object or if it is consumable.
 * It also has open and close methods for the binary and text files.
 *  
 */
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class FileProcessor {
	private FileInputStream fstream = null;
	// the binary file with the initial values for the identifiable objects
	private DataInputStream inputFile = null; 
	// the text file with the consumption instructions
	private Scanner instructionsFile = null;
	
	/**
	 * Opens a binaryFie.
	 * @param filename The name of the binary File.
	 * @throws FileNotFoundException
	 */
	public void openBinaryFile(String filename) {
		
		try{
			fstream = new FileInputStream(filename);
			inputFile = new DataInputStream(fstream);
			
		} catch (FileNotFoundException e) {
			System.out.println("Binary file: " + filename + " was not found.");
			System.exit(1);
		}
	}

	/**
	 * This method opens a scanner object to read in consumption instructions.
	 * @param filename the name of the file to open.
	 * @throws FileNotFoundException
	 */
	public void openConsumptionFile(String filename){
		File file = new File(filename);
		
		try {
			instructionsFile = new Scanner(file);
			
		} catch (FileNotFoundException e) {
			System.out.println("Text file: " + filename + " was not found.");
			System.exit(1);
		}
	}
	
	/**
	 * This method goes through the binary file and initializing all the 
	 * required objects to 
	 * their initial values.
	 * @param data The DataStorage object which has an arrayList<Identifiable>
	 * @return The DataStorage object with all the objects added to it
	 * @throws EOFException for when done reading the file
	 * @throws IOException if a critical issue has happened
	 */
	public DataStorage readBinaryFile(DataStorage data){
		boolean endOfFile = false; 	// assume haven't reached EOF marker
		// the type of object, Pizza, Battery, or Luggage based on char
		char type; 					

		while(!endOfFile){
			try{
				// get the first character of type of object
				type = inputFile.readChar();
				type = Character.toUpperCase(type);

				if(type == 'P'){
					data.addIdentifiable( new Pizza(inputFile.readInt(), 
							inputFile.readInt(), inputFile.readUTF()));
				}
				else if(type == 'B'){
					data.addIdentifiable(new Battery(inputFile.readInt(), 
							inputFile.readInt()));
				}
				else if(type == 'L'){
					data.addIdentifiable(new Luggage(inputFile.readInt(), 
							inputFile.readUTF()));
				}
			}
			
			catch(EOFException e){
				endOfFile = true;// if reached the end of file stop the loop
			}
			catch(IOException e){ // if critical error stop the program
				System.out.println("Input/Output error with file.");
				System.exit(1);
			}

		}
		return data;
	}
	
	/**
	 * This method reads in consumption data and alters the arrayList within 
	 * DataStorage 
	 * accordingly. This throws an Over
	 * @param data
	 * @catch OverConsumedException if there is not enough capacity to consume
	 */
	public void readConsumptionFile(DataStorage data) {
		// use a StringBuilder for output
		StringBuilder consumptionResults = new StringBuilder(); 
		int id = 0; 						// the id of the object
		// string array to have the input of file
		String[] instruction = new String[2];
		// Generic identifiable object for identifiable methods
		Identifiable idObject; 				
		// Generic Consumable object for consumable methods
		Consumable consumeObject; 			
		
		consumptionResults.append("============================================"
				+ "======\n");
		consumptionResults.append("           Executing instructions           "
				+ "      \n");
		consumptionResults.append("============================================"
				+ "======\n");
		
		// don't need EOFException since using hasNextLine()
		for(int i = 1; instructionsFile.hasNextLine(); i++){ 
			// take in input into string array id, how much to consume
				instruction = instructionsFile.nextLine().split(",");
				instruction[0] = instruction[0].trim(); 
				instruction[1] = instruction[1].trim();
				id = Integer.parseInt(instruction[0]);
				// returns a reference to an object not the object itself
				idObject = data.searchArrayList(id); 
				
				if(idObject == null){ // if empty says so
					consumptionResults.append(i);
					consumptionResults.append("- ");
					consumptionResults.append(id);
					consumptionResults.append(" not found.\n");
				}
				// not a consumable object and found so say it isn't consumable
				else if( !(idObject instanceof Consumable) ){
					consumptionResults.append(i);
					consumptionResults.append("- ");
					consumptionResults.append(id);
					consumptionResults.append(" not consumable.\n");
				}
				else{ // has id and is consumable so call .consume
					try{
						// cast to consumable so we can call .consume on it
						consumeObject = (Consumable) idObject; 
						consumeObject.consume(Integer.parseInt(instruction[1]));
						
						// if valid get output the result of .consume()
						consumptionResults.append(i);
						consumptionResults.append("- ");
						consumptionResults.append(id);
						consumptionResults.append(" has ");
						consumptionResults.append(
								consumeObject.getRemainingCapacityUnits());
						consumptionResults.append(" remaining\n");
					}
					// if exception is thrown say why it was thrown
					catch(OverConsumedException oce){
						consumptionResults.append(i);
						consumptionResults.append("- ");
						consumptionResults.append(id);
						consumptionResults.append(
								" didn't have enough and is now empty\n");
					}	
				}
		}
		System.out.print(consumptionResults); // output all the results 
	}
	
	public void closeBinaryFile(){
		if(inputFile != null){
			try{
				inputFile.close();
			} catch (IOException e) {	
				System.out.println("Input/Output error with file.");
				System.exit(1);
			}		
		}
	}
	
	public void closeInstructionFile(){
		if(instructionsFile != null){
			
			instructionsFile.close();		
		}
	}
}
