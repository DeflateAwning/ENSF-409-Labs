
public class Lab1Ex1 {

	public static void main(String [] args) {
		double curSum = 0;
		
		System.out.printf("The 4 numbers are: ");
		
		for (int i = 0; i < args.length; i++) {
			curSum += Double.parseDouble(args[i]);
			
			System.out.printf("%.3f ", Double.parseDouble(args[i]));
		}
		
		
		
		System.out.printf("\n\nAnd their average is: %.3f\n", curSum/args.length);
		
	}
}

/* Example Output:
The 4 numbers are: 4.500 4.689 4.333 4.300 

And their average is: 4.456
*/