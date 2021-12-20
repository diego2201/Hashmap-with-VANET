import java.util.*;
import java.util.Map.Entry;

/**
 * This class extends the AbstractSort class. In this class we sort the HashMap that was obtained in the 
 * EqualAverage class using a TreeMap, prints it out and then sorts it.
 * 
 * @author Diego Cifuentes
 * @version 1
 */
public class LexicoGraphical extends AbstractSort
{
	/** Where the sorted Vanet values will be stored into */
	private TreeMap<String, Integer> sortedAsciiVal;
	
	//Help from Office Hours
	/**
	 * Sorts the HashMap containing the vehicle numbers with the same Ascii average value.
	 * 
	 * @param asciiVal		This is the map that we obtained in the EqualAverage method, containing all the vanet data with the same AsciiAverage
	 */
	public LexicoGraphical(HashMap<String, Integer> asciiVal)
	{	
		//Creates a TreeMap in order to sort the asciiVal HashMap
		sortedAsciiVal = new TreeMap<String, Integer>(asciiVal);
				
		//Uses an enhanced for loop in order to go through all the entries in the 
			//TreeMap
		for(Entry<String, Integer> entry : sortedAsciiVal.entrySet())
		{
			//Prints out the keys of the TreeMap with the correct formatting
			System.out.println(entry.getKey());
		}
	}

	@Override
	/**
	 * Returns the sorted TreeMap containing the same average Ascii value.
	 * 
	 * @param unsorted			The map to be sorted
	 * @return the newly sorted TreeMap
	 */
	Map<String, Integer> sortedMap(HashMap<String, Integer> unsorted) 
	{
		return sortedAsciiVal;
	}
}
