import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author Mohammad Mukhtaruzzaman
 * @version 3.21.10
 * Main class of Project 3
*/

public class Main 
{
	/**
	 * The main method is to direct the students for the project. 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException 
	{
		/** 
		 * To make the coding convenient, we divided this class in sections. 
		 * I divided the content into sections to give you a break from long discussion.
		 * When we want any output from a lines of code, we printed the intended output immediately above the lines of code.
		 * 
		 * 
		 * For output formatting, always see the sample output (SampleOutput.txt). 
		 *  
		 * 
		 * Section 1
	     * 
	     * Read the text file: SimpleDates.txt; to create a hashmap, we will use this dates.
	     * 
	     * The content of the file is like: 
			04.07.2016
			11.12.2018
	     * 
	     * The output from the next lines: the first part is deciding whether a year is a leap year or not. The second part, 
	     * calculate the difference between today and the given date. Today means the server date during execution.
	     * At the same time, save these date in a Hashmap as HashMap<LocalDate, Integer>
	     * Keys are dates from the text file, for map value use numeric values starting from 1. 
	     * Output format is: (for format, use the sample output)
			2016 is a leap year, and the difference: 5 years, 6 months, and 7 days.
			2018 is not a leap year, and the difference: 2 years, 11 months, and 2 days.
		 * 
		 */
	    DateTimeLeap dateTimeLeap = new DateTimeLeap();
	    dateTimeLeap.compareYear();
	    
	    /**
		 * Now print your Hashmap. It may look like below (This is the format, I didn't print whole map):
		 * (i.e., Key:value)
			2020-05-30:3
			2011-03-15:4
		 */
	    System.out.println("\nInitial Hashmap:");	
	    dateTimeLeap.dateHashMap();
 
	    /**
		 * Sort your Hashmap in ascending order using the keys and print. 
		 * 
		 * It will be like below:
			1900-01-01:6
			1900-12-31:8
		 */
	    System.out.println("\nNow the Hashmap after sorting:");	
	    dateTimeLeap.dateHashMapSort();
	    System.out.println("\n");
	    
	    /**
		 * Section 2
		 * 
		 * Now we will calculate the ASCII average of the vehicleID, veh000.
		 * 
		 * To calculate the ASCII average for veh000: add the individual ASCIIs 
		 * v e h 0 0 0 : 118 101 104 48 48 48 
		 * Sum of ASCII = 467 and number of letters is 6, which gives the average = 77.833
		 * If the fraction is less than 0.5, the average is the floor; otherwise, the average is the ceiling.
		 * 	 
		 * NOTE: AsciiAverage class must inherit AbstractAscii class.
		 */
		String vehicleId = "veh000";
		AsciiAverage asciiAverage = new AsciiAverage(new Vanet(vehicleId));
		int asciiAvg = asciiAverage.calAverage();		

		HashMap<String, Integer> asciiVal = new HashMap<String, Integer>();
		asciiVal.put(vehicleId, asciiAvg);
		System.out.print("ASCII average: ");
	    /**
	     * Calculate and print the ASCII average. So, in this case, the average is 78.
		 */
		System.out.println(asciiVal.get(vehicleId));		
		
	    /**
		 * Compute  the ASCII average of all the vehicles. 
		 * Read the file, VANETData.txt and extract the vehicleIDs which have 100 or more in the numeric part, 
		 * i.e., for calculation, use the vehicles starting from veh100 onward.
		 * 
		 * You will get some vehicles have the same ASCII average like veh000, which is 78. 
		 * You will add these vehicleIDs to a hashmap and Print them. The content of the hashmap will be like below:
		 * 
		 * {veh102=78, , , ... veh120=78}
		 */
		EqualAverage equalAverage = new EqualAverage(vehicleId);
		System.out.println("\nStations with the same average are: "+ equalAverage.calAsciiEqual());
		
	    /**
		 * We are printing the same unsorted map again in the following format:
		 * 
		 * 	veh102 has the average of 78
			veh201 has the average of 78
		 */
		System.out.println("\nUnsroted Hashmap:");
		asciiVal = equalAverage.calAsciiEqual();		
		for (String stIds : asciiVal.keySet()) 
		{
		    System.out.println(stIds + " has the average of " + asciiVal.get(stIds));		    
		}		
		
	    /**
		 * Sort your hashmap and print here (We are sorting the data so that we can test your output on Zybook, 
		 * because unsorted data is difficult to test correctly.
		 * Print the vehicleIDs only in the following format (Check the sample output file for actual formatting):
		 * 
		 * 	veh100
			veh101
			veh102			
		 */
		System.out.println("\nThe sorted map:");
		new LexicoGraphical(asciiVal);		
		
	    /**
		 * Section 3
		 *   
		 * For this section read the file, ComplexDates.txt; (Note: file is correct.)
		 * Parse the file and store in a hashmap. The dates as the key and as a date format, not string.
		 * For example, HashMap<LocalDate, Integer>, but you can use any date function
		 * format of the date will be: 2021-03-31
		 * 
		 * For this section, you have to sort using your a sorting algorithm.
		 * Don't use any API/built-in function/treemap etc., you have to implement the algorithm.
		 * You are free to choose any algorithm to implement such as Quick sort, Bubble sort, Radix sort, Insertion sort etc.
		 * All these are for learning purpose to develop your thinking process and programming skill. 
		 * So, if you use any API instead of your own sorting algorithm, you will get partial points during code review.
		 */
		System.out.println("\nThe dates in HashMap are sorted using algorithm:\n");
	    SortingAlg sortingAlg = new SortingAlg();	    
	    
	    /**
		 * Sort the hashmap in descending order
		 * Output format will be like:
			2050-12-31
			2047-02-28
			2042-10-30
		 */
	    System.out.println("Sorting of the dates in descending order:\n");
	    long startTime = System.nanoTime();  
	    sortingAlg.sortDescending();
	    long estimatedTime = System.nanoTime() - startTime;
	    
	    /**
		 * Sort the hashmap in ascending order. 
		 * Output will be like:
			2000-12-15
			2003-04-25
			2004-01-01
		 */
	    System.out.println("\nSorting of the dates in ascending order:");
	    long startTime2 = System.nanoTime();  
	    sortingAlg.sortAscending();
	    long estimatedTime2 = System.nanoTime() - startTime2;
	    
	    /**
		 * You will notice a remarkable difference between two execution times, why? Explain in README. 
		 */
	    System.out.println("\nExecution time for the case 1: " + estimatedTime);
	    System.out.println("Execution time for the case 2: " + estimatedTime2);
	    
	    /**
		 * Use JavaDoc for documentation. 
		 * Write a README with a small paragraph on problem-solving approach and a complete UML.
		 */
	}
}
