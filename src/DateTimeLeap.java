import java.io.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.Map.Entry;

//Help from Office Hours
/**
 * This class reads in the SimpleDates.txt and then stores it into a HashMap. 
 * Then checks if the year is a leap year or not and prints out the date 
 * and its corresponding sentence depending on this. 
 * Also prints out the entire HashMap before sorting and then after
 * 
 * @author Diego Cifuentes
 * @version 1
 */
public class DateTimeLeap 
{
	/** The HashMap where the dates and the values will be stored into */
	private HashMap<LocalDate, Integer> simpleDates = new HashMap<LocalDate, Integer>();		
	
	/** Used in order to help format the date correctly in order to be output in the correct format*/
	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("MM.dd.yyyy");
	
	//Help from Office Hours
	/**
	 * Reads in the SimpleDate.txt file and then stores it into a HashMap. 
	 * Then checks if the year is a leap year or not and then prints out 
	 * if it is one or not. Also prints out the difference of the 
	 * given year from the file and today's date.
	 */
	public void compareYear() 
	{
		simpleDates.clear();

		File file = new File("SimpleDates.txt");
		
		//Used to read in the file
		try(BufferedReader br = new BufferedReader(new FileReader(file)))
		{
			//Initializes a String variable where the lines of the file will be read into
			String line;
			
			//The key value, will be incremented to keep up with the keys
			int counter = 1;
			
			//While the line in the file contains something
				//(e.g not null), go through the while loop
			while((line = br.readLine()) != null)
			{
				//Parses the String from the file and then converts it into a LocalDate object
				LocalDate parseDate = LocalDate.parse(line, FORMATTER);
				
				//Checks if the given year is a leap year
				if(parseDate.isLeapYear())
				{
					//If it is then the following output is printed
					System.out.print(parseDate.getYear() + " is a leap year, "
							+ "and the difference: ");
				}
				
				//If its not then the following output is printed.
				else 
				{
					System.out.print(parseDate.getYear() + " is not a leap year, "
							+ "and the difference: ");
				}
				
				//Checks for the difference between the passed date from the file and today's date
				Period diff = Period.between(parseDate, LocalDate.now());
				
				//Prints out the difference between the parsed date and today's date
					//matching the format given from the sampleOutput file
				System.out.print(diff.getYears() + " years, " + diff.getMonths() + " months, and "
						+ diff.getDays() + " days.\n");

				//Adds the key and value to the HashMap
				simpleDates.put(parseDate, counter++);
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	//Help from Ethan Ho
	/**
	 * Goes through the HashMap and prints out with the given format
	 */
	public void dateHashMap() 
	{
		//Uses an enhanced for loop in order to go through all the entries in the 
			//HashMap
		for(Entry<LocalDate, Integer> entry : simpleDates.entrySet())
		{
			//Prints out the values of the HashMap with the correct formatting
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}
	}
	
	//Idea from in class lecture
	/**
	 * Sorts the HashMap using a TreeMap and then uses similar logic as the dateHashMap() method
	 * and prints out the TreeMap
	 */
	public void dateHashMapSort() 
	{
		//Creates a TreeMap in order to sort the simpleDates HashMap
		TreeMap<LocalDate, Integer> sortedSimpleDates = new TreeMap<LocalDate, Integer>(simpleDates);
		
		//Uses an enhanced for loop in order to go through all the entries in the 
			//TreeMap
		for(Entry<LocalDate, Integer> entry : sortedSimpleDates.entrySet())
		{
			//Prints out the values of the TreeMap with the correct formatting
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}
	}
}
