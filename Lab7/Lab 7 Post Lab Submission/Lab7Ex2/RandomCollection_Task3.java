import java.util.*;

// RandomCollection.java -> Task 3

/**
 * Stores the results of the threads from RandomThread.
 * 
 * @author Parker Link
 * @since Mar. 20, 2020
 * @version 3.0.0
 */
public class RandomCollection {
	
	volatile private ArrayList<Integer> randomResults;

	public RandomCollection() {
		randomResults = new ArrayList<Integer>();
	}
	
	public int calcSum() {
		int curSum = 0;
		
		for (int i = 0; i < randomResults.size(); i++) {
			curSum += randomResults.get(i);
		}
		
		return curSum;
	}
	
	public void addNumber(int num) {
		randomResults.add(num);
	}

}
