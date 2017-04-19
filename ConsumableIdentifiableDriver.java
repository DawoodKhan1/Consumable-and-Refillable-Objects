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
		
		boolean generateBinaryFiles = false; 
		String binaryFile = "program_data.dat"; // name of binary file
		// name of consumption instruction file
		String consumptionFile = "consumption_instructions.txt";
		// class to store the arrayList of identifiables as well as 
		// provide some useful methods
		DataStorage programData = new DataStorage();
		// class that will process the binary and consumption files
		FileProcessor ioProcessor = new FileProcessor();

		if(generateBinaryFiles){
			// --- MAKING MY OWN BINARY FILE -- // 
			// Making program_data2.dat
			FileOutputStream fstream2 = new FileOutputStream(
					"program_data2.dat");
			DataOutputStream outputFile2 = new DataOutputStream (fstream2);
			DataStorage programData2 = new DataStorage();
			
			outputFile2.writeChar('P');
			outputFile2.writeInt(1);
			outputFile2.writeInt(12);
			outputFile2.writeUTF("Cheese");
			
			outputFile2.writeChar('l');
			outputFile2.writeInt(2);
			outputFile2.writeUTF("blue");
			
			outputFile2.writeChar('B');
			outputFile2.writeInt(3);
			outputFile2.writeInt(3000);
			
			outputFile2.close();
			
			// Opening the binary file, taking in the information into 
			// DataStorage, and then closing it
			ioProcessor.openBinaryFile("program_data2.dat");
			ioProcessor.readBinaryFile(programData2);
		    ioProcessor.closeBinaryFile();
			/* Opening the consumption instruction files, altering DataStorage 
			 * accordingly, and then closing it.*/ 
		    ioProcessor.openConsumptionFile(consumptionFile);
		    ioProcessor.readConsumptionFile(programData2);
		    ioProcessor.closeInstructionFile();
		    // output all the objects summaries using printSummary
			programData2.printArray();
			
			
			// Making program_data3.dat
			FileOutputStream fstream3 = new FileOutputStream(
					"program_data3.dat");
			DataOutputStream outputFile3 = new DataOutputStream (fstream3);
			DataStorage programData3 = new DataStorage();
			// purposefully not writing anything to the binary file			
			outputFile3.close();
			
			// Opening the binary file, taking in the information into 
			// DataStorage, and then closing it
			ioProcessor.openBinaryFile("program_data3.dat");
			ioProcessor.readBinaryFile(programData3);
		    ioProcessor.closeBinaryFile();
			/* Opening the consumption instruction files, altering DataStorage 
			 * accordingly, and then closing it.*/ 
		    ioProcessor.openConsumptionFile(consumptionFile);
		    ioProcessor.readConsumptionFile(programData3);
		    ioProcessor.closeInstructionFile();
		    // output all the objects summaries using printSummary
			programData3.printArray();
			
			
			// Making program_data4.dat
			FileOutputStream fstream4 = new FileOutputStream(
					"program_data4.dat");
			DataOutputStream outputFile4 = new DataOutputStream (fstream4);
			DataStorage programData4 = new DataStorage();
			// everything will be a luggage item
			outputFile4.writeChar('l');
			outputFile4.writeInt(0);
			outputFile4.writeUTF("blue");
			
			outputFile4.writeChar('l');
			outputFile4.writeInt(1);
			outputFile4.writeUTF("blue");
			
			outputFile4.writeChar('l');
			outputFile4.writeInt(2);
			outputFile4.writeUTF("red");
			
			outputFile4.writeChar('l');
			outputFile4.writeInt(3);
			outputFile4.writeUTF("orange");
			
			outputFile4.writeChar('l');
			outputFile4.writeInt(4);
			outputFile4.writeUTF("black");
			
			outputFile4.writeChar('l');
			outputFile4.writeInt(5);
			outputFile4.writeUTF("gray");
			
			outputFile4.writeChar('l');
			outputFile4.writeInt(6);
			outputFile4.writeUTF("brown");
			
			outputFile4.writeChar('l');
			outputFile4.writeInt(7);
			outputFile4.writeUTF("yellow");
			
			outputFile4.writeChar('l');
			outputFile4.writeInt(8);
			outputFile4.writeUTF("violet");
			
			outputFile4.writeChar('l');
			outputFile4.writeInt(9);
			outputFile4.writeUTF("pink");
			
			outputFile4.writeChar('l');
			outputFile4.writeInt(10);
			outputFile4.writeUTF("green");
			
			outputFile4.close();
					
			// Opening the binary file, taking in the information into 
			// DataStorage, and then closing it
			ioProcessor.openBinaryFile("program_data4.dat");
			ioProcessor.readBinaryFile(programData4);
			ioProcessor.closeBinaryFile();
			/* Opening the consumption instruction files, altering DataStorage 
			* accordingly, and then closing it.*/ 
			ioProcessor.openConsumptionFile(consumptionFile);
			ioProcessor.readConsumptionFile(programData4);
			ioProcessor.closeInstructionFile();
			// output all the objects summaries using printSummary
			programData4.printArray();
		}// end binary file generation for testing
		
		
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