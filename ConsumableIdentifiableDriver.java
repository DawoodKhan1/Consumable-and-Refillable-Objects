/**
 * Class: CSCI 1125-30
 * Semester: Spring 2017
 * @author Dawood Khan
 * Date:4/18/2017
 * Homework Assignment #4
 * 
 * Description: This class uses the DataStorage class in order to store all 
 * the objects withinit's arrayList of Identifiable. The Identifiable objects
 * are Battery, Luggage, and Pizza.
 * It then uses the FileProcessor class to then process the input binary file
 * to initialize all the Identifiable objects in the arrayList within 
 * DataStorage. 
 * Next it reads in consumptionInstructions and then depending on the id, 
 * whether it can be consumable, or if it has enough capacity left it 
 * displays a message.
 * 
 *  
 */
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ConsumableIdentifiableDriver {

	public static void main(String[] args) throws IOException {
		
		String binaryFile = "program_data.dat"; // name of binary file
		// name of consumption instruction file
		String consumptionFile = "consumption_instructions.txt";
		// class to store the arrayList of identifiables as well as 
		// provide some useful methods
		DataStorage programData = new DataStorage();
		// class that will process the binary and consumption files
		FileProcessor ioProcessor = new FileProcessor();
		
		// Opening the binary file, taking in the information into DataStorage,
		// and then closing it
		ioProcessor.openBinaryFile(binaryFile);
		ioProcessor.readBinaryFile(programData);
	    	ioProcessor.closeBinaryFile();
		/* Opening the consumption instruction files, altering DataStorage 
		* accordingly, and then closing it.*/ 
	  	ioProcessor.openConsumptionFile(consumptionFile);
	  	ioProcessor.readConsumptionFile(programData);
	  	ioProcessor.closeInstructionFile();
	  	// output all the objects summaries using printSummary
		programData.printArray();
	}
}
