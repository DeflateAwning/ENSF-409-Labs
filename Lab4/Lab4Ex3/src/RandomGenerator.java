
//  RandomGenerator.java

import java.util.Random;

class RandomGenerator {

/**
 * Creates a random number ranging between lo and hi, inclusively.
 * The random number can be equal to lo and/or hi.
 * 
 * @param lo Minimum random number (inclusive)
 * @param hi Maximum random number (inclusive)
 * @return A random integer between lo and hi, inclusively.
 */
	int discrete(int lo, int hi)
	{
		if(lo >= hi){
			System.out.println("Error discrete, lo >= hi");
			System.exit(0);
		}
		
		Random r = new Random();
		int d = r.nextInt(hi - lo + 1) + lo;
		return d;
	}
	
}
