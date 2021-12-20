# Project 3: Hashmap with VANET

## UML Diagrams
![Project 3 - Page 1](https://user-images.githubusercontent.com/89539958/139112734-788b750d-3561-4178-b467-e81447c56e62.jpeg)

![Project 3 - Page 1 (1)](https://user-images.githubusercontent.com/89539958/139113171-faaac829-1bac-4de6-923c-544a21761958.jpeg)

![Project 3 - Page 1 (3)](https://user-images.githubusercontent.com/89539958/139326029-8bce37e7-9f2a-4512-bae8-3a6ec2099a28.jpeg)

![Project 3 - Page 1 (2)](https://user-images.githubusercontent.com/89539958/139325346-4f270803-f830-459c-a8f9-25ddc501eef3.jpeg)

![Project 3 - Page 1 (4)](https://user-images.githubusercontent.com/89539958/139356590-3e2ae583-d86f-4be0-a4f7-7a78478016d4.jpeg)

![Project 3 - Page 1 (5)](https://user-images.githubusercontent.com/89539958/139356616-143d5357-5648-4bb5-a6e7-8d3a6a79d933.jpeg)

![Project 3 - Page 1 (6)](https://user-images.githubusercontent.com/89539958/139356641-79839b43-c7bf-4c57-84bd-5b2af500378b.jpeg)

## DateTimeLeap
* `compareYear()`: In this method I first read in the “SimpleDates” file. I do this by initializing a String variable named line and then assigning the read in line to that variable. I then go through a while loop while the read in line is not null, and increment a counter, which will serve as the value for the HashMap. After that I parse the String read in from the file and then convert it into a LocalDate object, which is what is asked when storing into the HashMap later on. This conversion also provides some helpful methods that will be needed such as .isLeapYear(). After this I then check if the passed in year is a leap year using the previously stated method. After this check, I print out the corresponding print statement. I then need to find the difference between the date from the file and the current date. To do this I use the Period class and then the .between() method, and pass in the file date (parseDate) and call for the current date (LocalDate.now()). I then print out the statement with the differences between the dates, and then put the parsed in file date and its value (counter) into the HashMap.

* `dateHashMap()`: In this method, I go through the HashMap and then print it out with the given format. I do this by going through the HashMap using an enhanced for loop, and then using .getKey() and .getValue() to grab the corresponding values and then print them out to the console.

* `dateHashMapSort()`: In this method I am tasked with sorting the keys and values in the HashMap and then print them out. To do this I used a TreeMap which automatically does this. I then use the same logic as in dateHashMap() and use an enhanced for loop, and then using .getKey() and .getValue() to grab the corresponding values and then print them out to the console.

## AsciiAverage (extends AbstractAscii)
* `AsciiAverage(Vanet vanet)`: This is the constructor. Assigns the passed vanet (which is the vehicleID) to the instance variable passedVehicle. 

* `calAverage()`: In this method we take the passed in vehicleID (vanet, if we look in the main class we can see that in this case it is “VEH000”), and we need to calculate the AsciiAverage for all its characters. To do this I create a new local String variable, called vehicle, and then store the vehicleID into it. I then create two new local variables called sumOfCharacters (where I will store the sum of the Ascii values for each character) and idLength, which will keep track of how many characters are in the given vehicle ID. I will be using the equation m (mean / average) = (sum of terms / number of terms). I then use a for loop to go through each character of the vehicle. I create a char character and store the value of the vehicle at i into it. I then convert this char into an int by casting (int) and then storing into a new int variable. I then add this new int into sumOfCharacters and increment idLength, and repeat this for each character of the vehicle ID. I then declare a new double variable and store in the average, this is found by doing double asciiAverage = sumOfCharacters / idLength; I then divide this new average by %1 to get the fraction. This is done in order to find if we need to use Math.ceil (to round up) or Math.floor (to round down). I then use and if else statement to check. After this I return the new rounded value.

## EqualAverage 
* `readFile()`: In this method we are tasked with reading in the VANETData file and grabbing the vehicleID’s that are after 100. To do this I first created a new ArrayList which would temporarily hold all the vehicleIDs from the file, as this would help with sorting. I then used a BufferedReader to read in the file. I used br.readLine(); to skip over the first line of the file, as it did not hold anything significant to what needed to be done. I then created a new String variable called line and another String variable called vehicleID. These two will help with reading in the file and then storing the data. I then use a while loop to go through each line of the file as long as the next line is not null. After this I use the trim method to get rid of any white space and the split method and then store that new String into vehicleID. I then add vehicleID to the ArrayList. After this I created a new ArrayList, vehicles, which is a private variable, and where all the vehicle IDs that come after 100 will be stored into. To do this I create a for loop to go through each index of the previous ArrayList, and then use an if statement to check if the length of the vehicleID string in the ArrayList is equal to 6, then it is added to the vehicles ArrayList. This is because if the String is equal to 5, then it does not have a 100’s place, and therefore is not what is needed. 

* `EqualAverage(String vehicleID)`: This is a constructor for the EqualAverage Object. I assign the passed in vehicleID to the instance variable passedInVehicle. This vehicle will serve as the base, we will find its AsciiAverage and then find other vehicle IDs that have the same average. 

* `calAsciiEqual()`: In this class we are calculating the AsciiAverage of the passed in vehicle, and then finding other vehicles with this same average and then storing them in a HashMap that will then be printed out to the console. To do this I first call the readFile method. I then create a new Vanet Object using the passedInVehicle as its parameter. I then create a new AsciiAverage object using the newly created Vanet object as its parameter. After this I then call the calAverage method from the AsciiAverage class. This essentially calculates the Ascii average for me, and makes it so I do not have to write redundant code. I then store this Ascii average, as it will be used later on. I then use a for loop to go through the ArrayList vehicles. I then repeat the steps listed above, I create a new Vanet object using the vehicle at a given index, and create a new AsciiAverage Object using the new Vanet object. I then call the calAverage method to calculate the Ascii average, and then use an if statement if this new average matches up with the ascii average of the passed vehicle. If so then it is added to the HashMap as a key, and its ascii average as its value, and then returned.

## LexicoGraphical (extends AbstractSort)
* `LexicoGraphical(HashMap<String, Integer> asciiVal)`: In this method we need to sort the HashMap that we obtained in the previous class, containing all the vehicle numbers with the same Ascii average as the passed in vehicle. I did this by using very similar code as the one in the DateTimeLeap. I created a TreeMap inserting the HashMap in order to sort it, and then using an enhanced for loop to go through the TreeMap and then printing it out to the console.

* `Map<String, Integer> sortedMap(HashMap<String, Integer> unsorted)`: In this method I return the sorted TreeMap. 

## SortingAlg
* `readFile()`: For this I used the same logic as when I read in the file for the compareYear method in the DateTimeLeap class. It was refactored a bit in order to help better fit this situation. For example, the print statements and the leap year checks were removed. Other than that the code is very similar and works in the same way, at the end the complex dates from the ComplexDates file are read in and stored in a HashMap with their values. 

* `sortAscending()`: In this method we are tasked with sorting the HashMap with the complex dates using our own algorithm, meaning we cannot use the help of things such as sort() or a TreeMap. To do this I decided to do the bubble sort after some research. (https://www.youtube.com/watch?v=Jdtq5uKz-w4&t=347s&ab_channel=mycodeschool)
I found this to make the most sense to me so I used it. In order to do this I created a new List and then stored the HashMap keys into it. I then declared a temp variable and a flag and made a while loop to go through the List while it is not sorted. I then use the compareTo method and if it returns a 1 it will go and perform the swaps necessary and move the biggest element to the end, and continue this process until the list is sorted in an ascending order.

* `sortDescending()`: This method we are tasked with sorting the dates from the HashMap in descending order. To do this I reuse the code from the sortAscending method, except I created a new List to store the newly sorted descending list. I then go through the same method to sort the list in an ascending order. After this is done I go through a for loop in order to go through the ascended list and then grab the last element from the last (the biggest element) and assign it to the first element of the descending list, and continue until the List is now in descending order.