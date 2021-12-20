import java.io.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * This class reads in the ComplexDates file and then 
 * implements the Bubble sort in order to sort the dates in ascending order
 * and descending order
 * 
 * @author Diego Cifuentes
 * @version 1
 */
public class SortingAlg 
{
	/** The HashMap where the dates and the values will be stored into */
	private static HashMap<LocalDate, Integer> complexDates = new HashMap<LocalDate, Integer>();	
	
	/** Used in order to help format the date correctly in order to be output in the correct format */
	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	
	/**
	 * Reads in the ComplexDates file. First grabs all the vehicle numbers and then gets rid of extra white space.
	 * Then checks if the length of each String is 6, meaning that it is after 100 (VEH###), and then stores into 
	 * an ArrayList
	 */
	public void readFile()
	{
		//Reuses code from the DateTimeLeap class, refactored to better fit this class
		File file = new File("ComplexDates.txt");
		
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
				LocalDate parseDate = LocalDate.parse(line.trim().replaceAll("\\s+",""), FORMATTER);
				
				//Adds the parsed in date and its value to the HashMap
				complexDates.put(parseDate, counter++);
			}
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}

	}
	
	/**
	 * Sorts the dates from least to most (ascending),
	 * by using the Bubble sort method
	 */
	public void sortAscending() 
	{
		//Calls the readFileMethod
		readFile();
		
		//Where the dates will be stored first
		List<LocalDate> list = new ArrayList<LocalDate>();
		
        //Adds the HashMaps keys to the list
        list.addAll(complexDates.keySet());

		//Used to help with swapping positions
        LocalDate temp;
        boolean flag = false;
        
        //Runs while the list is not sorted
        while (!flag) 
        {
            flag = true;

            //For loop to go through the list
            for (int i = 0; i < list.size()-1; i++) 
            {
                if (list.get(i).compareTo(list.get(i + 1)) > 0) 
                {
                	//Compares the two values using the compareTo method
            			//if it returns something greater than 1, so less
            			//Then it will swap positions
                	
                	//Sets the temp variable to the position at i
                    temp = list.get(i);
                    
                    //sets the list to i + 1
                    list.set(i, list.get(i + 1));
                    
                    //And then sets the next position off list to the temp array
                    list.set(i + 1, temp);
                    flag = false;
                }
            }
        }
        
        //For loop to go through the now sorted list and then print out
        for(int i = 0; i < list.size(); i++)
        {
            System.out.println(list.get(i));
        }
	}
	
	//Help from Stack Overflow
	/**
	 * Sorts the read in complex dates from most to least (descending),
	 * by using the bubble sort method
	 */
	public void sortDescending() 
	{
		//Calls the readFileMethod
		readFile();
		   
		//Where the dates will be stored first
		List<LocalDate> list = new ArrayList<LocalDate>();

		//Where the will be reversed and then stored
        List<LocalDate> reversedList = new ArrayList<LocalDate>();
       
        //Adds the HashMaps keys to the list
		list.addAll(complexDates.keySet());
        
		//Used to help with swapping positions
        LocalDate temp;
        
        boolean flag = false;
        
        //Runs while the list is not sorted
        while (!flag) 
        {
        	//Sets to true
            flag = true;
            
            //For loop to go through the list
            for (int i = 0; i < list.size()-1; i++) 
            {
            	//Compares the two values using the compareTo method
            		//if it returns something greater than 1, so less
            		//Then it will swap positions
                if (list.get(i).compareTo(list.get(i + 1)) > 0) 
                {
                    temp = list.get(i);
                    list.set(i, list.get(i + 1));
                    list.set(i + 1, temp);
                    flag = false;
                }
            }
        }
        
        //Help from Professor Maiti
        //For loop to go through the now ascending sorted List and reverses it
        for(int i = 0; i < list.size(); i++)
        {
        	//Sets the first index of the reversedList to the last index of the list
        		//in order to reverse
        	reversedList.add(list.get(list.size() - i - 1));
        	
        	//Prints out the reversedList
            System.out.println(reversedList.get(i));
        }
	}

}
