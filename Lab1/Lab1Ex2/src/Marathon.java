
public class Marathon {
	
	public int getArrayMinValueIndex(int[] inputArray) {
		int currentMinValue = inputArray[0];
		int currentMinIndex = -1;
		
		for (int i = 0; i < inputArray.length; i++) {
			if (inputArray[i] < currentMinValue) {
				currentMinValue = inputArray[i];
				currentMinIndex = i;
			}
		}
		
		return currentMinIndex;
		
		
	}
	
	public static void main (String[] args) {
		Marathon marathon = new Marathon();
		
		String[] names = { "Elena", "Thomas", "Hamilton", "Suzie",
				"Phil", "Matt", "Alex", "Emma", "John", "James", "Jane",
				"Emily", "Daniel", "Neda", "Aaron", "Kate" };
		
		int[] times = { 341, 273, 278, 329, 445, 402, 388, 275, 243,
				334, 412, 393, 299, 343, 317, 265
		};


		int fastestIndex = marathon.getArrayMinValueIndex(times);
		
		System.out.printf("Fastest time: %ds. Fastest runner: %s.", times[fastestIndex], names[fastestIndex]);
		
		
	} 

}

/* Program Output:
Fastest time: 243s. Fastest runner: John.
*/