
//  RandomGenerator.java

import java.util.Random;

/**
 * Implements a Random Integer Generator.
 * 
 * Note that this class could also be implemented as a single static method.
 * 
 * Source: ENSF 409, Lab 4, Ex 3, Provided File
 * 		UCalgary, Winter 2020
 * 
 * @author M. Moshirpour
 * @version 1.1.0
 * @since Unknown
 *
 */
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
