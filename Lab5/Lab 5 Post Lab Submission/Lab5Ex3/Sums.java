
import java.io.*;

public class Sums {
	
	public static int readIntUntilSuccess(BufferedReader in) {
		while (true) {
			try {
				int readVal = Integer.parseInt(in.readLine());
				return readVal;
			}
			catch (IOException | NumberFormatException e) {
				System.out.println("Invalid number, please re-enter.");
			}
		}
	}
	
	public static String readStrUntilSuccess(BufferedReader in) {
		while (true) {
			try {
				String readVal = in.readLine().trim();
				return readVal;
			}
			catch (IOException e) {
				System.out.println("Error reading input, please re-enter.");
			}
		}
	}

	public static void sum(BufferedReader in) {
		// takes a sequence of integers as inputs, and outputs their sum

		int s, nextInt;
		s = 0;

		System.out.println("Please input the sequence of integers to sum, terminated by a 0");
		nextInt = readIntUntilSuccess(in);
		// Read next datum in input. An integer is expected

		while (nextInt != 0) {
			s = s + nextInt;
			nextInt = readIntUntilSuccess(in);
		}

		System.out.println("The sum is " + s);
	}

	public static void main(String[] arg) {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		// "in" will receive data from the standard input stream
		String c;

		System.out.println("Do you wish to calculate a sum? (y/n)");

		c = readStrUntilSuccess(in);
		// Read next datum in input. A string "y" or "n" is expected

		while (!c.equals("y") && !c.equals("n")) {
			System.out.println("Please answer y or n");
			c = readStrUntilSuccess(in);
		}

		while (c.equals("y")) {
			sum(in);
			System.out.println("Do you wish to calculate another sum? (y/n)");
			c = readStrUntilSuccess(in);

			while (!c.equals("y") && !c.equals("n")) {
				System.out.println("Please answer y or n");
				c = readStrUntilSuccess(in);
			}
		}

		System.out.println("Goodbye");
	}
}
