// Lab 1, Ex 5 (similar to Lab 1, Ex 2)

import java.util.ArrayList;
import java.util.Scanner;

public class Marathon {
	
	public int getArrayMinValueIndex(ArrayList<Integer> inputArray) {
		int currentMinValue = inputArray.get(0);
		int currentMinIndex = 0;
		
		for (int i = 0; i < inputArray.size(); i++) {
			if (inputArray.get(i) < currentMinValue) {
				currentMinValue = inputArray.get(i);
				currentMinIndex = i;
			}
		}
		
		return currentMinIndex;
		
		
	}
	
	public static void main (String[] args) {
		// Create Object
		Marathon marathon = new Marathon();
		
		// Declare two ArrayLists
		ArrayList <String> names = new ArrayList <String>();
		ArrayList <Integer> times = new ArrayList <Integer>();

		// Begin Scanning for User Input, and store it
		String sin;
		Scanner scan = new Scanner(System.in);
		while (true)
		{
			// Read name
			System.out.println("Please enter the name of the participant");
			sin = scan.nextLine();
			if(sin.toUpperCase().equals("QUIT"))
				break;
			
			// Add the name to your ArrayList
			names.add(new String(sin));
			
			// Read running time
			System.out.println("Please enter the running time of the participant");
			sin = scan.nextLine();
			
			// Add the running time to your array list
			times.add(new Integer(sin));
		}
		
		// Call the function findFastestRunner and pass the running times ArrayList to it
		int fastestIndex = marathon.getArrayMinValueIndex(times);
		
		// Print the name of the fastest runner to the console
		System.out.printf("Fastest time: %ds. Fastest runner: %s.", times.get(fastestIndex), names.get(fastestIndex));
		
		
	} 

}