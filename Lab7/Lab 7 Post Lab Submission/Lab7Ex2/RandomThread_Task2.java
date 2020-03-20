import java.util.Random;

// RandomThread.java -> Task 2

/*
 * Program Output:
 * Sum of 5 generated random numbers: 274
 */

/**
 * Implements a single runnable thread, for Task 2.
 * 
 * @author Parker Link
 * @since Mar. 20, 2020
 * @version 2.0.0
 *
 */
public class RandomThread implements Runnable {

	private int randomNumber;
	private RandomCollection randomCollection;
	
	public RandomThread(RandomCollection randomCollection) {
		this.randomCollection = randomCollection;
	}
	
	/**
	 * Creates a random number ranging between lo and hi, inclusively.
	 * The random number can be equal to lo and/or hi.
	 * 
	 * Source: ENSF 409, Lab 4, Ex 3, Provided File
	 * 		UCalgary, Winter 2020
	 * 
	 * @author M. Moshirpour
	 * @version 1.1.0
	 * @since Unknown
	 * 
	 * @param lo Minimum random number (inclusive)
	 * @param hi Maximum random number (inclusive)
	 * @return A random integer between lo and hi, inclusively.
	 */
	private int makeRandomNumber(int lo, int hi)
	{
		if(lo >= hi){
			System.out.println("Error discrete, lo >= hi");
			System.exit(0);
		}

		Random r = new Random();
		int d = r.nextInt(hi - lo + 1) + lo;
		return d;
	}
	
	/**
	 * Gets a random number between 1 and 100, as per the assignment spec.
	 * 
	 * @return A random number between 1 and 100.
	 */
	public int makeRandomNumber() {
		return makeRandomNumber(1, 100);
	}
	
	/**
	 * Runs the thread by generating a random number.
	 */
	@Override
	public void run() {
		// Make a random number
		randomNumber = makeRandomNumber();
		
		// Means that only one thread can add a number to the collection at a time without things breaking
		// This may not be necessary because we use the .join() method in main
		synchronized(randomCollection) {
			// Add it to the collection
			randomCollection.addNumber(randomNumber);
		}
	}
	
	public static void main(String[] args) {
		RandomCollection myRandomCollection = new RandomCollection();
		RandomThread myRandomThread = new RandomThread(myRandomCollection);
		
		for (int i = 0; i < 5; i++) {
			Thread thisThread = new Thread(myRandomThread);
			
			thisThread.start();
			
			// Wait for this thread to complete before moving on
			try {
				thisThread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
		System.out.println("Sum of 5 generated random numbers: " + myRandomCollection.calcSum());

	}

}
