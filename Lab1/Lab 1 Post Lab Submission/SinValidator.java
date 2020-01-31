import java.util.Scanner;


public class SinValidator {

	private int[] SIN;
	
	private int sumDigit(int x)
	{
		// Sums all the individual digits in x
		int result = 0;
		
		while(x > 0) {
			result += x % 10;
			x = x /10; // integer result
		}
		
		return result;
	}

	public SinValidator(String sin) {
		// Validates the basic structure (i.e. length, character type, etc.)

		SIN = new int[9];
		int i = 0;
		int counter = 0;
		while(i < sin.length()){

			
			if(Character.isDigit(sin.charAt(i))){
				if(counter < 9)
					// put the digits in sin into "SIN int array"
					SIN[counter] =(int) sin.charAt(i) - 48;
				counter++;
			}
			else{
				System.err.println("Error: Invalid input by the user");
				return;
			}
			i++;
		}
		
		if(counter != 9){
			System.err.println("Error: SIN must be 9 digits...");
			return;
		}	
	}
	
	public boolean validateSin()
	{
		// Check whether it's a valid sin based on the following requirements/steps:
		/*
1. Add first, third, fifth, and seventh digits. (Note: the first number is the most significant digit)
2. Multiply second digit by two and add the digits of the resultant product together.
3. Repeat step 2 for fourth, sixth, and eighth digits.
4. Add the four terms found in steps 2 and 3. (handled in one step, step4)
5. Add the totals from steps 1 and 4 together.
6. 10 minus the least significant digit of step 5 total should be the ninth digit of the SIN. 
		 */
		
		int step1 = SIN[0] + SIN[2] + SIN[4] + SIN[6];
		int step4 = 0;
		for (int step3Index = 1; step3Index < 8; step3Index += 2) {
			step4 += sumDigit(2 * SIN[step3Index]);
		}
		int step5 = step1 + step4;
		
		int step6 = 10 - (step5 % 10);	
        
		return step6 == SIN[8];
		
	}

	public static void main(String[] args) {
		// Read user input
	
	    String sin;
		Scanner scan = new Scanner(System.in);	
		while (true)
		{
			System.out.println("Please enter your 9 digit social insurance number or enter quit to terminate the program: ");
			sin = scan.nextLine();
			if(sin.toUpperCase().equals("QUIT"))
				break;
			SinValidator sv = new SinValidator(sin);
			if(sv.validateSin())
				System.out.println("Yes, this is a valid SIN\n");
			else
				System.out.println("No, this is NOT a valid SIN\n");
			
		}
	}

}
