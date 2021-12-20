import java.io.*;
import java.util.*;

/**
 * In this class we read in the VANETData.txt file. We then use the passed in vehicle ID and calculate the Ascii average 
 * for that vehicle. We then go through the vehicle numbers from the list and find the ones with the same Ascii average
 * and then store it in a HashMap.
 * 
 * @author Diego Cifuentes
 * @version 1
 */
public class EqualAverage 
{
	/** Where the vehicle numbers with the same Ascii average will be stored into */
	private HashMap<String, Integer> vehiclesHash = new HashMap<String, Integer>();		
	
	/** Where the vehicles read in from the file will be stored */
	private ArrayList<String> vehicles;
	
	/** Where the passed in vehicleID will be stored */
	private String passedInVehicle;
	
	/**
	 * Reads in the VANETDATA file. First grabs all the vehicle numbers and then gets rid of extra white space.
	 * Then checks if the length of each String is 6, meaning that it is after 100 (VEH###), and then stores into 
	 * an ArrayList
	 */
	public void readFile()
	{
		//A temporary ArrayList where the lines of the file will be stored into
		ArrayList<String> fileLines = new ArrayList<String>();
		File file = new File("VANETData.txt");
		
		//Used to read in the file
		try(BufferedReader br = new BufferedReader(new FileReader(file)))
		{
			//Used to skip the first line of the file
			br.readLine();
			
			//Initializes a String variable where the lines of the file will be read into
			String line;
			
			//Initializes a String variable where the vehicle number will be temporarily stored into
			String vehicleID;
			
			//While the line in the file contains something
				//(e.g not null), go through the while loop
			while((line = br.readLine()) != null)
			{
				//Advice from Mohammed
				//Trims out the whitespace and then stores it in the String variable
				//Uses split to get the data without any whitespace
				vehicleID = line.trim().split("\\s+")[0];
				
				//Stores the read in line into a temporary
					//ArrayList
				fileLines.add(vehicleID);
			}
			
			//Where the vehicle numbers matching the given conditions will be stored into
			vehicles = new ArrayList<String>();
			
			//A for loop to go through the fileLines ArrayList
			for(int i = 0; i < fileLines.size(); i++)
			{
				//Advice from Mohammed
				//Checks if the length of the vehicleID is 6
				if(fileLines.get(i).length() == 6)
				{
					//If so add it to the vehicles ArrayList
					vehicles.add(fileLines.get(i));
				}
			}
		}
	
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * This is a constructor. We assign the passed in vehicleID to the instance variable passedInVehicle
	 * 
	 * @param vehicleId		The passed in vehicle ID to be used to be used for calculations and comparisons
	 */
	public EqualAverage(String vehicleId) 
	{
		passedInVehicle = vehicleId;
	}

	//Help from Office Hours
	/**
	 * Calculates the Ascii average for the passed in vehicleID. Then goes through the ArrayList containing the 
	 * vehicleIDs and calculates their Ascii average. If the average of the file vehicle matches that of the passed 
	 * in vehicle then it is added to a HashMap and returned
	 * 
	 * @return the HashMap vehiclesHash, which contains the vehicle numbers with the same AsciiAverage as the
	 * passed in vehicleID
	 */
	public HashMap<String, Integer> calAsciiEqual() 
	{
		//Calls the readFile() method
		readFile();
		
		//Creates a new Vanet object using the passed in vehicleID
		Vanet vehicleID = new Vanet(passedInVehicle);
		
		//Then creates a new AsciiAverage object using the passed in vehicleID
		AsciiAverage asciiAverage = new AsciiAverage(vehicleID);
		
		//After both steps are done, then calls the calAverage() from the AsciiAverage class in 
			//order to calculate the average, this is done to help prevent writing the same code
		int theAverage = asciiAverage.calAverage(); 

		//Creates a String variable that helps when storing the vehicleID into the HashMap
		String vehicle;
		
		//For loop to go through the vehicles ArrayList
		for(int i = 0; i < vehicles.size(); i++)
		{
			//Assigns the given vehicleID at a given index to the String variable
			vehicle = vehicles.get(i); 
			
			//Creates a new Vanet object using the given vehicleID at a given index
			Vanet fileVehicles = new Vanet(vehicles.get(i));

			//Then creates a new AsciiAverage object using the the given vehicleID at a given index
			AsciiAverage asciiAverage2 = new AsciiAverage(fileVehicles);
			
			//After both steps are done, then calls the calAverage() from the AsciiAverage class in 
				//order to calculate the average, this is done to help prevent writing the same code
			int arrayAverage = asciiAverage2.calAverage();
			
			//Then checks if the average of the file vehicleID is the same as that of the passed in vehicle
			if(arrayAverage == theAverage)
			{
				//If so then it is added to the HashMap
				vehiclesHash.put(vehicle, arrayAverage);
			}
		}
		return vehiclesHash;
	}

}
