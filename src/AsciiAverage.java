
/**
 * This class extends the parent class AbstractAscii. In this class we initialize a new AsciiAverage
 * object with the passed vehicleID. We then use this passed vehicleID and find its Ascii
 * average value and return it.
 * 
 * @author Diego Cifuentes
 * @version 1
 */
public class AsciiAverage extends AbstractAscii
{
	/** Where the passed vehicleID will be stored */
	private String passedVehicle;
	
	/**
	 * Initializes an AsciiAverage object with the passed value of vanet.
	 * 
	 * @param vanet		The passed vehicleID to be initialized
	 */
	public AsciiAverage(Vanet vanet) 
	{
		this.passedVehicle = vanet.getVehicleID();		
	}
	
	//Similar code from Project 2 refactors for project 3
	/**
	 * Calculates the Ascii average of the passed vehicleID
	 */
	public int calAverage() 
	{		
		//The passed vehicleID in this case "VEH000"
		String vehicle = passedVehicle; 
		
		//Where the sum of each characters Ascii value will be stored in
		int sumOfCharacters = 0;
		
		//Keeps track of the length of the passed VehicleID
		double idLength = 0;

		//For loop to go through the vehicleID and calculate the sum of the values
			//and keep track of the length
		for(int i = 0; i < vehicle.length(); i++)
		{
			//Adds the values of vehicleID at i into a new char variable
			char character = vehicle.charAt(i);
			
			//Casts the character to an int, thus converting it into its Ascii value
				//and then storing it into the castAscii variable
			int castAscii = (int) character;
			
			//Keeps track of the length of the ID
			idLength++;
			
			//vehicle.lemngth
			
			//Adds the castAscii to the sumOfCharacter variable
			sumOfCharacters += castAscii;
		}
		
		//Divides the total by the length to find the average Ascii value, and then rounds up
		double asciiAverage = sumOfCharacters / idLength;
		
		//Gets the fraction in order to check if the average needs to be floored or ceiled.
		double fraction = asciiAverage % 1;
		
		//Where the value of the AsciiAverage will be stored after it is rounded
		int totalValueAfterRound = 0;
		
		//Checks whether it needs to be rounded up or down.
		if(fraction < 0.5)
		{
			//If the fraction is less than 0.5, then the value is floored
			totalValueAfterRound = (int) Math.floor(asciiAverage);
		}
		else
		{
			//Else the fraction is ceiled
			totalValueAfterRound = (int) Math.ceil(asciiAverage);
		}
				
		return totalValueAfterRound; 
	}
}
