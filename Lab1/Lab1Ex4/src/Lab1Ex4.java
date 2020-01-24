
public class Lab1Ex4 {
	private char[][] mainArray;
	
	public void populateMainArray(String[] args) {
		mainArray = new char[3][60];


		// Copy args[0] into mainArray[0] in reverse order
		for (int argI = args[1].length()-1, mainArrayI = 0; argI >= 0; argI--, mainArrayI++) {
			mainArray[0][mainArrayI] = args[1].charAt(argI);
		}
		
		// Copy args[1] into mainArray[1], with the words in reverse order
		String [] eachWordArgs1 = args[1].split(" ");
		int curStrIndex = 0; // place to insert into char array
		for (int wordIndex = 0; wordIndex < eachWordArgs1.length; wordIndex++) {
			for (int charIndexInWord = 0; charIndexInWord < eachWordArgs1[wordIndex].length(); charIndexInWord++) {
				mainArray[1][curStrIndex++] = eachWordArgs1[wordIndex].charAt(charIndexInWord);
			}
			mainArray[1][curStrIndex++] = 32; // insert space
		}
		
		// Copy args[2] into mainArray[2], with places divisible by 5 being capitalized
		String args2Upper = args[2].toUpperCase();
		String args2Lower = args[2].toLowerCase();
		for (int i = 0; i < args[2].length(); i++) {
			if (i % 5 == 0) {
				// Divisible by 5, capital
				mainArray[2][i] = args2Upper.charAt(i);
			}
			else {
				// Not divisible by 2, lower case
				mainArray[2][i] = args2Lower.charAt(i);
				
			}
		}
		
	}

	public static void main(String[] args) {
		Lab1Ex4 mainObj = new Lab1Ex4();
		
		mainObj.populateMainArray(args);
		
		for (int i = 0; i < 3; i++) {
			// Print out the character array for each i
			System.out.printf("mainArray[%d] = %s\n", i, new String(mainObj.mainArray[i]));
		}

	}

}

// Testing Parameters: "I like Programming!" "I like Programming!" "I like Programming!"